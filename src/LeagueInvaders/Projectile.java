package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject {

	// Projectile constructor
	
	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
	}
	
	// Update and Draw methods
	
		void update() {
			y-=speed;
		}
		void draw(Graphics g) {
	        g.setColor(Color.RED);
	        g.fillRect(x, y, width, height);
		}

}
