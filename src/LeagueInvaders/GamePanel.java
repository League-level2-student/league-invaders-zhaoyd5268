package LeagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

	// GamePanel variables

	Font titlefont;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;

	// Graphics paintComponent method

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == MENU) {
			drawMenuState(g);
		} else if (currentState == GAME) {
			drawGameState(g);
		} else if (currentState == END) {
			drawEndState(g);
		}
	}

	// Font constructor

	GamePanel() {
		titlefont = new Font("Arial", Font.PLAIN, 48);
	}

	// Game state methods

	void updateMenuState() {

	}

	void updateGameState() {

	}

	void updateEndState() {

	}

	// Game drawing state methods

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titlefont);
		g.setColor(Color.GREEN);
		g.drawString("League Invaders", 80, 150);
	}

	void drawGameState(Graphics g) {

	}

	void drawEndState(Graphics g) {

	}

}
