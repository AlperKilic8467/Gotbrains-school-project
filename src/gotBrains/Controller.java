package gotBrains;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main class that starts the application by creating all windows and shows the
 * menuWindow so that the user can choose what to do.
 * 
 * @author Isak Hartman
 *
 */
public class Controller {

	private JFrame frame;
	private JPanel panelContainer = new JPanel();
	private MainMenu mainMenu;
	private SpellThisMenu spellThisMenu;
	private SpellThisGame spellThisGame;
	private MemorizeThisWindow memorizeThisWindow;
	private CalculateThisMenu calculateThisMenu;
	private CalculateThisGame calculateThisGame;
	private Leaderboard leaderboard;
	private Simon simon;
	private String currentUsername;
	private File backgroundMusic = new File("sounds/backgroundMusic.wav");
	private File correctSound = new File("sounds/correctSound.wav");
	private File incorrectSound = new File("sounds/incorrectSound.wav");
	private File alarmSound = new File("sounds/alarmSound.wav");
	private File buttonSound = new File("sounds/buttonSound.wav");
	private Clip music;
	private boolean mutedMusic = false;
	private boolean mutedSound = false;

	private HighscoreManager hm = new HighscoreManager();
	private CardLayout cl = new CardLayout();
	private Font customFont;
	
	public Controller(JFrame frame) {
		this.frame = frame;
		panelContainer.setLayout(cl);
		loadApp();
		startMusic();
	}

	public void loadApp() {
		mainMenu = new MainMenu(this);
		spellThisMenu = new SpellThisMenu(this);
		memorizeThisWindow = new MemorizeThisWindow(this);
		calculateThisMenu = new CalculateThisMenu(this);

		panelContainer.add(mainMenu, "mainMenu");
		panelContainer.add(spellThisMenu, "spellThisMenu");
		panelContainer.add(memorizeThisWindow, "memorizeThisWindow");
		panelContainer.add(calculateThisMenu, "calculateThisMenu");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panelContainer);
		frame.setSize(800, 600);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
		frame.setUndecorated(true);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);

		cl.show(panelContainer, "mainMenu");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mainMenu.fieldUsername.grabFocus();
	}

	public Font getCustomFont(String filepath, int style, int size) {
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(filepath))).deriveFont(style,
					size);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: " + e);
		} catch (FontFormatException e) {
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR: " + e);
			e.printStackTrace();
		}
		return customFont;
	}

	public void startMusic() {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(backgroundMusic);
			music = AudioSystem.getClip();
			music.open(ais);
			FloatControl gainControl = (FloatControl) music.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(-15.0f);
			music.start();
			music.loop(100);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void toggleMusic() {
		if (!mutedMusic) {
			music.stop();
			mutedMusic = true;
		} else if (mutedMusic) {
			startMusic();
			mutedMusic = false;
		}
	}

	public void toggleSound() {
		if (mutedSound) {
			mutedSound = false;
		} else
			mutedSound = true;
	}

	public void correctSound(boolean correct) {
		if (!mutedSound) {
			try {
				if (correct) {
					AudioInputStream ais = AudioSystem.getAudioInputStream(correctSound);
					Clip sound = AudioSystem.getClip();
					sound.open(ais);
					sound.start();
				} else if (!correct) {
					AudioInputStream ais = AudioSystem.getAudioInputStream(incorrectSound);
					Clip sound = AudioSystem.getClip();
					sound.open(ais);
					sound.start();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void alarmSoundSound() {
		if (!mutedSound) {
			try {
				AudioInputStream ais = AudioSystem.getAudioInputStream(alarmSound);
				Clip sound = AudioSystem.getClip();
				sound.open(ais);
				sound.start();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public void buttonSound() {
		if(!mutedSound) {
			try {
				AudioInputStream ais = AudioSystem.getAudioInputStream(buttonSound);
				Clip sound = AudioSystem.getClip();
				sound.open(ais);
				sound.start();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void showSpellThisMenu() {
		cl.show(panelContainer, "spellThisMenu");
	}

	public void showMemorizeThisWindow() {
		cl.show(panelContainer, "memorizeThisWindow");
	}

	public void showCalculateThisMenu() {
		cl.show(panelContainer, "calculateThisMenu");
	}

	public void startSimon() {
		simon = new Simon(this);
		panelContainer.add(simon, "simonGame");

		cl.show(panelContainer, "simonGame");
	}

	public void startSpellThisGame(int difficulty) {
		spellThisGame = new SpellThisGame(this);
		panelContainer.add(spellThisGame, "spellThisGame");

		spellThisGame.setDifficulty(difficulty);
		spellThisGame.startLevel();
		cl.show(panelContainer, "spellThisGame");
		spellThisGame.textField.grabFocus();
	}

	public void startCalculateThisGame(int difficulty) {
		calculateThisGame = new CalculateThisGame(this);
		panelContainer.add(calculateThisGame, "calculateThisGame");

		calculateThisGame.setDifficulty(difficulty);
		calculateThisGame.startLevel();
		cl.show(panelContainer, "calculateThisGame");
		calculateThisGame.textField.grabFocus();
	}

	public void showLeaderboard() {
		leaderboard = new Leaderboard(this);
		panelContainer.add(leaderboard, "leaderboard");
		cl.show(panelContainer, "leaderboard");
	}

	public void showMainMenu() {
		cl.show(panelContainer, "mainMenu");
		mainMenu.fieldUsername.grabFocus();
	}

	public void minimizeApp() {
		frame.setState(JFrame.ICONIFIED);
	}

	public void setCurrentUsername(String username) {
		this.currentUsername = username;
	}

	public void addPlayer(String username) {
		hm.addPlayer(username);
	}

	public String getLeaderboardPlacement() {
		return hm.getLeaderboardPlacement();
	}

	public String getLeaderboardScore() {
		return hm.getLeaderboardScore();
	}

	public void clearLeaderboard() {
		hm.clearScores();
	}

	public void newCalculateThisScore(int score) {
		hm.addCalculateThisScore(this.currentUsername, score);
	}

	public void newSpellThisScore(int score) {
		hm.addSpellThisScore(this.currentUsername, score);
	}

	public void newMemorizeThisScore(int score) {
		hm.addMemorizeThisScore(this.currentUsername, score);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Controller controller = new Controller(frame);
	}

}
