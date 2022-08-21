package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class rocketShip extends GameObject {

	// Image member variables

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	// Boolean member variables

	boolean up;
	boolean down;
	boolean left;
	boolean right;

	// rocketShip constructor

	rocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		if (needImage) {
			loadImage("rocket.png");
		}
		isActive = true;
	}

	// Draw method

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y, width, height, null);
		} else {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}

	}

	// Rocket control methods

	public void UP(boolean up) {
		this.up = up;
	}

	public void DOWN(boolean down) {
		this.down = down;
	}

	public void LEFT(boolean left) {
		this.left = left;
	}

	public void RIGHT(boolean right) {
		this.right = right;
	}

	// Update method

	public void update() {
		super.update();
		if (up == true) {
			y -= 2;
		}
		if (down == true) {
			y += 2;
		}
		if (left == true) {
			x -= 2;
		}
		if (right == true) {
			x += 2;
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

	// Projectile shooter method

	public Projectile getProjectile() {
		return new Projectile(x + width / 2, y, 10, 10);
	}
}
