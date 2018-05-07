package gotBrains;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Simon extends JPanel implements ActionListener, MouseListener {

	public static Simon simon;
	private JButton b1 = new JButton();
	public Renderer renderer;
	public static final int WIDTH = 300, HEIGHT = 300;
	public int flashed = 0, dark, ticks, indexPattern;
	public boolean creatingPattern = true;
	public ArrayList<Integer> pattern;
	public Random random;
	private boolean gameOver;
	private int score;
	
	private Controller controller;
	
	private JButton btnQuit = new JButton(new ImageIcon("images/quitButton.png"));
	private JButton btnMenu = new JButton(new ImageIcon("images/menuButton.png"));

	public Simon(Controller controller) {
		this.controller = controller;
		simon = this;
		setLayout(null);
		setPreferredSize(new Dimension(800, 600));

		add(btnQuit);
		btnQuit.setOpaque(false);
		btnQuit.setContentAreaFilled(false);
		btnQuit.setBorderPainted(false);
		btnQuit.setBounds(758, 2, 40, 35);
		btnQuit.addActionListener((e) -> {
			 if (e.getSource() == btnQuit) {
					System.exit(0);
			 }
		});
		btnQuit.setRolloverIcon(new ImageIcon("images/quitButtonHover.png"));

		add(btnMenu);
		btnMenu.setOpaque(false);
		btnMenu.setContentAreaFilled(false);
		btnMenu.setBorderPainted(false);
		btnMenu.setBounds(-2, -2, 120, 30);
		btnMenu.addActionListener((e) -> {
			if (e.getSource() == btnMenu) {
				controller.showMainMenu();
			}
		});
		btnMenu.setRolloverIcon(new ImageIcon("images/menuButtonHover.png"));
		
		Timer timer = new Timer(20, this);
		renderer = new Renderer();

		add(renderer);
		renderer.setOpaque(false);
		renderer.setSize(WIDTH + 8, HEIGHT + 30);
		renderer.setBounds(250, 200, WIDTH, HEIGHT);
		renderer.addMouseListener(this);
		renderer.setVisible(true);
		
		start();
		timer.start();
	}
	
	protected void paintComponent(Graphics g) {
		ImageIcon background = new ImageIcon("images/simonSaysBackground.png");
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}

	public void start() {
		random = new Random();
		pattern = new ArrayList<Integer>();
		indexPattern = 0;
		dark = 2;
		flashed = 0;
		ticks = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ticks++;

		if (ticks % 20 == 0) {
			flashed = 0;

			if (dark >= 0) {
				dark--;
			}
		}

		if (creatingPattern) {
			if (dark <= 0) {
				if (indexPattern >= pattern.size()) {
					flashed = random.nextInt(40) % 4 + 1;
					pattern.add(flashed);
					indexPattern = 0;
					creatingPattern = false;
				} else {
					flashed = pattern.get(indexPattern);
					indexPattern++;
				}

				dark = 2;
			}
		} else if (indexPattern == pattern.size()) {
			creatingPattern = true;
			indexPattern = 0;
			dark = 2;
		}

		renderer.repaint();
	}

	public void paint(Graphics2D g) {		
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (flashed == 1) {
			g.setColor(Color.GREEN);
		} else {
			g.setColor(Color.GREEN.darker());
		}

		g.fillRect(0, 0, WIDTH / 2, HEIGHT / 2);

		if (flashed == 2) {
			g.setColor(Color.RED);
		} else {
			g.setColor(Color.RED.darker());
		}

		g.fillRect(WIDTH / 2, 0, WIDTH / 2, HEIGHT / 2);

		if (flashed == 3) {
			g.setColor(Color.ORANGE);
		} else {
			g.setColor(Color.ORANGE.darker());
		}

		g.fillRect(0, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);

		if (flashed == 4) {
			g.setColor(Color.BLUE);
		} else {
			g.setColor(Color.BLUE.darker());
		}

		g.fillRect(WIDTH / 2, HEIGHT / 2, WIDTH / 2, HEIGHT / 2);

		g.setColor(Color.BLACK);
		g.fillRoundRect(220, 220, 350, 350, 300, 300);
		g.fillRect(WIDTH / 2 - WIDTH / 12, 0, WIDTH / 7, HEIGHT);
		g.fillRect(0, WIDTH / 2 - WIDTH / 12, WIDTH, HEIGHT / 7);

		g.setColor(Color.GRAY);
		g.setStroke(new BasicStroke(200));
		g.drawOval(-100, -100, WIDTH + 200, HEIGHT + 200);

		g.setColor(Color.BLACK);
		g.setStroke(new BasicStroke(10));
		g.drawOval(0, 0, WIDTH, HEIGHT);

		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", 1, 25));

		if (gameOver) {
			g.drawString("Game-Over", WIDTH / 2 - 60, HEIGHT / 2 + 5);
		} else {
			g.drawString(indexPattern + "/" + pattern.size(), WIDTH / 2 - 20, HEIGHT / 2 + 10);
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX(), y = e.getY();

		if (!creatingPattern && !gameOver) {
			if (x > 0 && x < WIDTH / 2 && y > 0 && y < HEIGHT / 2) {
				flashed = 1;
				ticks = 1;
			} else if (x > WIDTH / 2 && x < WIDTH && y > 0 && y < HEIGHT / 2) {
				flashed = 2;
				ticks = 1;
			} else if (x > 0 && x < WIDTH / 2 && y > HEIGHT / 2 && y < HEIGHT) {
				flashed = 3;
				ticks = 1;
			} else if (x > WIDTH / 2 && x < WIDTH && y > HEIGHT / 2 && y < HEIGHT) {
				flashed = 4;
				ticks = 1;
			}

			if (flashed != 0) {
				if (pattern.get(indexPattern) == flashed) {
					indexPattern++;
				} else {
					gameOver = true;
				}
			}
		} else if (gameOver) {
			start();
			gameOver = false;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
