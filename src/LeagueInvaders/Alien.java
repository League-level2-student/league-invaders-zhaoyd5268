package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Alien extends GameObject {

	// Image member variables

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	// Alien constructor

	Alien(int x, int y, int width, int height, Rectangle collisionBox) {
		super(x, y, width, height, collisionBox);
		speed = 1;
		if (needImage) {
		    loadImage ("alien.png");
		}
	}

	// Update and Draw methods

	void update() {
		y+=speed;
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y+=speed, width, height, null);
		} else {
			g.setColor(Color.GREEN);
			g.fillRect(x, y, width, height);
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

}
