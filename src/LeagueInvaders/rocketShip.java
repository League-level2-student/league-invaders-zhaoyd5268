package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class rocketShip extends gameObject {
	// Boolean member variables
	
	boolean up;
	boolean down;
	boolean left;
	boolean right;
	
	// rocketShip constructor
	
	rocketShip(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;

	}
	
	// Draw method
	
	void draw(Graphics g) {
		g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height);
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
    	if (up == true) {
    		y-=4;
    	}
    	if (down == true) {
    		y+=4;
    	}
    	if (left == true) {
    		x-=4;
    	}
    	if (right == true) {
    		x+=4;
    	}
    	
    
    }
}
