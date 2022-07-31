package LeagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class gamePanel extends JPanel implements ActionListener, KeyListener {

	// GamePanel variables
	Timer frameDraw;
	Font titleFont;
	Font smallerTitleFont;
	Font lowerTitleFont;
	Font endGameFont;
	Font killCountFont;
	Font restartFont;
	rocketShip rocket = new rocketShip(250, 700, 50, 50);
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	LeagueObjectManager leagueobjectmanager = new LeagueObjectManager(rocket);
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

	gamePanel() {
		titleFont = new Font("Arial", Font.PLAIN, 48);
		smallerTitleFont = new Font("Arial", Font.PLAIN, 30);
		lowerTitleFont = new Font("Arial", Font.PLAIN, 30);
		endGameFont = new Font("Arial", Font.PLAIN, 60);
		killCountFont = new Font("Arial", Font.PLAIN, 30);
		restartFont = new Font("Arial", Font.PLAIN, 30);
		frameDraw = new Timer(1000 / 60, this);
		frameDraw.start();
	}

	// Game state methods

	void updateMenuState() {

	}

	void updateGameState() {
		rocket.update();
		leagueobjectmanager.update();
	}

	void updateEndState() {

	}

	// Game drawing state methods

	void drawMenuState(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, aLeagueInvaders.WIDTH, aLeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.GRAY);
		g.drawString("League Invaders", 70, 150);
		g.setFont(smallerTitleFont);
		g.setColor(Color.GRAY);
		g.drawString("Press ENTER to Start", 100, 400);
		g.setFont(lowerTitleFont);
		g.setColor(Color.GRAY);
		g.drawString("Press SPACE for Instructions", 60, 450);
	}

	void drawGameState(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, aLeagueInvaders.WIDTH, aLeagueInvaders.HEIGHT);
		leagueobjectmanager.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, aLeagueInvaders.WIDTH, aLeagueInvaders.HEIGHT);
		g.setFont(endGameFont);
		g.setColor(Color.BLACK);
		g.drawString("GAME OVER", 70, 150);
		g.setFont(killCountFont);
		g.setColor(Color.BLACK);
		g.drawString("You killed enemies", 100, 400);
		g.setFont(restartFont);
		g.setColor(Color.BLACK);
		g.drawString("Press SPACE to Restart", 70, 450);

		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (currentState == MENU) {
			updateMenuState();
		} else if (currentState == GAME) {
			updateGameState();
		} else if (currentState == END) {
			updateEndState();
		}
		System.out.println("ACTION");
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
			} else {
				currentState++;
			}
		}
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			  rocket.UP(true);
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			    rocket.DOWN(true);
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			    rocket.LEFT(true);
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			   rocket.RIGHT(true);
			}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			  rocket.UP(false);
			}
			if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			    rocket.DOWN(false);
			}
			if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			    rocket.LEFT(false);
			}
			if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			   rocket.RIGHT(false);
			}

	}

}
