package gotBrains;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.System.exit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MemorizeThisWindow extends JPanel implements ActionListener {
	private ImageIcon iconQuit = new ImageIcon("images/quitButton.png");
	private ImageIcon iconQuitHover = new ImageIcon("images/quitButtonHover.png");
	private ImageIcon iconMenu = new ImageIcon("images/menuButton.png");
	private ImageIcon iconMenuHover = new ImageIcon("images/menuButtonHover.png");
	
	private JButton btnQuit = new JButton(iconQuit);
	private JButton btnMenu = new JButton(iconMenu);
	private JButton btnp = new JButton();
	
	private Controller controller;
	private int score = 0;
	private JLabel lblText = new JLabel("", SwingConstants.CENTER);

	private JLabel lblTimer = new JLabel("", SwingConstants.LEFT);

	public MemorizeThisWindow(Controller controller) {

		this.controller = controller;
		setLayout(null);
		setPreferredSize(new Dimension(800, 600));

		add(btnQuit);
		btnQuit.setOpaque(false);
		btnQuit.setContentAreaFilled(false);
		btnQuit.setBorderPainted(false);
		btnQuit.setBounds(758, 2, 40, 35);
		btnQuit.addActionListener(this);
		btnQuit.setRolloverIcon(iconQuitHover);

		add(btnMenu);
		btnMenu.setOpaque(false);
		btnMenu.setContentAreaFilled(false);
		btnMenu.setBorderPainted(false);
		btnMenu.setBounds(10, 20, 120, 30);
		btnMenu.addActionListener(this);
		btnMenu.setRolloverIcon(iconMenuHover);

		add(btnp);
		btnp.setOpaque(false);
		btnp.setText("Start");
		btnp.setContentAreaFilled(false);
		btnp.setBorderPainted(true);
		btnp.setBounds(340, 270, 120, 100);
		btnp.addActionListener(this);
		btnp.setRolloverIcon(iconQuitHover);
		btnp.setFont(new Font(Font.SANS_SERIF, Font.BOLD,25));

	}

	protected void paintComponent(Graphics g) {
		ImageIcon background = new ImageIcon("images/simonSaysBackground.png");
		super.paintComponent(g);
		g.drawImage(background.getImage(), 0, 0, null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMenu) {
			controller.showMainMenu();

		} else if (e.getSource() == btnp) {

			controller.startSimon();

		}

		else if (e.getSource() == btnQuit) {
			System.exit(0);
		}
	}

}
