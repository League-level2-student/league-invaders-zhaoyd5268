package LeagueInvaders;

import java.awt.Dimension;
import javax.swing.JFrame;

public class LeagueInvaders {

	// Game variables
	JFrame frame;
	GamePanel gamePanel;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;

	// JFrame initialization constructor

	LeagueInvaders() {
		frame = new JFrame();
		gamePanel = new GamePanel();
	}

	// Main method

	public static void main(String[] args) {
		LeagueInvaders leagueInvaders = new LeagueInvaders();
		leagueInvaders.setup();
	}

	// Setup method

	void setup() {
		frame.add(gamePanel);
		Dimension d = new Dimension(WIDTH, HEIGHT);
		frame.setSize(d);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
