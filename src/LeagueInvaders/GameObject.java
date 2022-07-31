package LeagueInvaders;

public class GameObject {
	
	// gameObject variables
	
	int x;
	int y;
	int width;
	int height;
	int speed = 0;
	Boolean isActive = false;
	
	// Initializer method
	
	GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	// Update method
	
	void update() {
		
	}
	
}
