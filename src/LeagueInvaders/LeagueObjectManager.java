package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class LeagueObjectManager implements ActionListener {
	// Game variables

	rocketShip rocketShip;
	ArrayList<Projectile> Projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> Aliens = new ArrayList<Alien>();
	Random random = new Random();
	int score = 0;
	// Constructor

	LeagueObjectManager(rocketShip rocketShip) {
		this.rocketShip = rocketShip;
	}

	// Projectile methods

	void addProjectile(Projectile projectile) {
		Projectiles.add(projectile);
	}

	// Alien methods

	void addAlien() {
		Aliens.add(new Alien(random.nextInt(aLeagueInvaders.WIDTH), 0, 50, 50));
	}

	// Update method

	void update() {
		for (int i = 0; i < Aliens.size(); i++) {
			Aliens.get(i).update();
			if (Aliens.get(i).y > aLeagueInvaders.HEIGHT) {
				Aliens.get(i).isActive = false;
			}

		}
		for (int i = 0; i < Projectiles.size(); i++) {
			Projectiles.get(i).update();
			if (Projectiles.get(i).y < 0) {
				Projectiles.get(i).isActive = false;
			}
		}
		checkCollision();
		purgeObjects();
	}

	// Draw method

	void draw(Graphics g) {
		for (int i = 0; i < Aliens.size(); i++) {
			Aliens.get(i).draw(g);
		}
		for (int i = 0; i < Projectiles.size(); i++) {
			Projectiles.get(i).draw(g);
		}
		rocketShip.draw(g);
	}

	// PurgeObjects method

	void purgeObjects() {
		for (int i = 0; i < Aliens.size(); i++) {
			if (Aliens.get(i).isActive == false) {
				Aliens.remove(i);
			}
		}
		for (int i = 0; i < Projectiles.size(); i++) {
			if (Projectiles.get(i).isActive == false) {
				Projectiles.remove(i);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		addAlien();
	}

	public void checkCollision() {
		for(int i = 0; i<Aliens.size(); i++) {
			for(int j = 0; j<Projectiles.size(); j++) {
				if (Projectiles.get(j).collisionBox.intersects(Aliens.get(i).collisionBox)) {
					Aliens.get(i).isActive = false;
					Projectiles.get(j).isActive = false;
					score+=1;
				}
			}

		}
		
		
		
	}

	public int getScore() {
		return score;
	}
	
}