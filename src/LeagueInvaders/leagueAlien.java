package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class leagueAlien extends gameObject {

	// Alien constructor
	
	leagueAlien(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 1;
	}
	
	// Update and Draw methods
	
		void update() {
			y+=speed;
		}
		void draw(Graphics g) {
	        g.setColor(Color.YELLOW);
	        g.fillRect(x, y, width, height);
		}
		
}
