package LeagueInvaders;

import java.awt.Rectangle;

public class GameObject {

	// gameObject variables

	Rectangle collisionBox;
	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	Boolean isActive = false;

	// Initializer method

	GameObject(int x, int y, int width, int height, Rectangle collisionBox) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.collisionBox = collisionBox;
	}

	// Update method

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

}
