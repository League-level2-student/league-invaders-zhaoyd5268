package LeagueInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class LeagueObjectManager {
	// Game variables

	rocketShip rocketShip;
	ArrayList<Projectile> Projectiles = new ArrayList<Projectile>();
	ArrayList<Alien> Aliens = new ArrayList<Alien>();
	Random random = new Random();

	// Constructor

	LeagueObjectManager(rocketShip rocketShip) {
		this.rocketShip = rocketShip;
	}

	// Projectile methods

	void addProjectile(Projectile projectile) {

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
		for (int i = 0; i < Aliens.size(); i++) {
			Aliens.get(i).update();
			if (Projectiles.get(i).y > aLeagueInvaders.HEIGHT) {
				Projectiles.get(i).isActive = false;
			}
		}
	}

	void updateProjectile() {

	}

	// Draw method

	void draw(Graphics g) {
		for(int i = 0; i < Aliens.size(); i++) {
			Aliens.get(i).draw(g);
		}
		for(int i = 0; i < Projectiles.size(); i++) {
			Projectiles.get(i).draw(g);
		}
		rocketShip.draw(g);
	}

	// PurgeObjects method
	
	void purgeObjects() {
		for(int i = 0; i < Aliens.size(); i++) {
			if (Aliens.get(i).isActive == false) {
				Aliens.remove(i);
			}
		}
		for(int i = 0; i < Projectiles.size(); i++) {
			if (Projectiles.get(i).isActive == false) {
				Projectiles.remove(i);
			}
		}
	}




}