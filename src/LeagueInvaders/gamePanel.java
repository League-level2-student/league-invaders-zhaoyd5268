package LeagueInvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class gamePanel extends JPanel implements ActionListener, KeyListener {

	// Image member variables

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	// GamePanel variables
	JLabel label = new JLabel();
	Timer frameDraw;
	Timer alienSpawn;
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
		startGame();
		frameDraw.start();
	}

	// Game state methods

	void updateMenuState() {

	}

	void updateGameState() {
		add(label);
		label.setText(leagueobjectmanager.getScore()+ "");
		label.setLocation(100, 100);
		rocket.update();
		leagueobjectmanager.update();
		if (needImage) {
			loadImage("space.png");
		}
		if (rocket.isActive == false) {
			currentState = END;
		}
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
		if (gotImage) {
			g.drawImage(image, 0, 0, aLeagueInvaders.WIDTH, aLeagueInvaders.HEIGHT, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, aLeagueInvaders.WIDTH, aLeagueInvaders.HEIGHT);
		}
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
				alienSpawn.stop();
				currentState = MENU;
			} else {
				if (currentState == GAME) {
					startGame();
				}
				currentState++;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.UP(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.DOWN(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.LEFT(true);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.RIGHT(true);
		}
		
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			leagueobjectmanager.addProjectile(leagueobjectmanager.rocketShip.getProjectile());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocket.UP(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocket.DOWN(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocket.LEFT(false);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocket.RIGHT(false);
		}

	}
	// Image loader method

	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
	
	// Start game method

	void startGame() {
	    alienSpawn = new Timer(1000 , leagueobjectmanager);
	    alienSpawn.start();
	}
}




















