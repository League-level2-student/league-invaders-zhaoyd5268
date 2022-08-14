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
	Boolean isActive = true;

	// Initializer method

	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		collisionBox = new Rectangle(x, y, width, height);
	}

	// Update method

	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

}
