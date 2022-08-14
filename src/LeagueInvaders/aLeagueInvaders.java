package LeagueInvaders;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class aLeagueInvaders {

	// Game variables
	JFrame frame;
	gamePanel gamePanel;
	public static final int WIDTH = 500;   
	public static final int HEIGHT = 800;

	// JFrame initialization constructor

	aLeagueInvaders() {
		frame = new JFrame();
		gamePanel = new gamePanel();
	}

	// Main method

	public static void main(String[] args) {
		aLeagueInvaders leagueInvaders = new aLeagueInvaders();
		leagueInvaders.setup();
	}

	// Setup method

	void setup() {
		frame.add(gamePanel);
		Dimension d = new Dimension(WIDTH, HEIGHT);
		frame.setSize(d);
		frame.addKeyListener(gamePanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
