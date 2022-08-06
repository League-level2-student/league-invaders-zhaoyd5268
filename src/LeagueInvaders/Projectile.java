package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Projectile extends GameObject {

	// Image member variables

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;

	// Projectile constructor

	Projectile(int x, int y, int width, int height, Rectangle collisionBox) {
		super(x, y, width, height, collisionBox);
		speed = 10;
		if (needImage) {
			loadImage("bullet.png");
		}
	}

	// Update and Draw methods

	void update() {
		y-=speed;
        super.update();
	}

	void draw(Graphics g) {
		if (gotImage) {
			g.drawImage(image, x, y-=speed, width, height, null);
		} else {
			g.setColor(Color.RED);
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
