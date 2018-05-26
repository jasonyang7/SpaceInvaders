import greenfoot.*;
import java.util.*;

/**
 * Creates the world for the game.
 * 
 * @author Jason Yang, Sai Enduri, Krish G
 * @version 5/24/2018
 */
public class MyWorld extends World {
	public int shot = 1;
	public int invaders = 55;
	private int alien = 0;
	private double chance = 1;
	NumberListener score = new NumberListener("Score: ");
	NumberListener lives = new NumberListener("Lives: ");

	/**
	 * Adds the new objects into the world, and adds two lives to the world.
	 */
	public MyWorld() {
		super(100, 100, 5);
		addObject(new Ship(), 50, 90);
		addObject(new Barrier(), 80, 70);
		addObject(new Barrier(), 60, 70);
		addObject(new Barrier(), 40, 70);
		addObject(new Barrier(), 20, 70);
		addObject(score, 15, 95);
		addObject(lives, 95, 95);
		lives.add(2);
		populate();
	}

	/**
	 * Changes the ability to shoot. 0 is no, and 1 is okay.
	 * 
	 * @param num
	 */
	public void setShoot(int num) {
		shot = num;
	}

	/**
	 * Determines if the player can shoot. 0 is no, and 1 is okay.
	 * 
	 * @return whether the player can shoot
	 */
	public boolean canShoot() {
		return shot == 1;
	}

	/**
	 * Adds points to the player.
	 * 
	 * @param pts
	 *            the number of points that are earned.
	 */
	public void addPoints(int pts) {
		score.add(pts);
	}

	/**
	 * Removes a life from the number of lives, adds a new ship, and sets the shoot
	 * to 1.
	 */
	public void die() {
		lives.subtract(1);
		if (lives.getValue() == 0) {
			gameOver();
		}

		addObject(new Ship(), 50, 90);
		shot = 1;
	}

	/**
	 * Adds a game over overlay to the screen and stops the game.
	 */
	public void gameOver() {
		addObject(new GameOverScore(score.getValue()), getWidth() / 2, getHeight() / 2);
		Greenfoot.stop();
	}

	/**
	 * Adds the aliens to the world.
	 */
	public void populate() {
		lives.add(1);
		LinkedList<Squid> squids = new LinkedList<Squid>();
		for (int i = 0; i < 11; i++) {
			Squid s = new Squid();
			squids.add(s);
			addObject(s, (i * 5) + 5, 10);
		}
		LinkedList<Crab> crabs = new LinkedList<Crab>();
		for (int i = 0; i < 11; i++) {
			Crab c = new Crab();
			crabs.add(c);
			addObject(c, (i * 5) + 5, 15);
		}
		for (int i = 11; i < 22; i++) {
			Crab c = new Crab();
			crabs.add(c);
			addObject(c, ((i * 5) + 5) - 55, 20);
		}
		LinkedList<Octopus> octopuses = new LinkedList<Octopus>();
		for (int i = 0; i < 11; i++) {
			Octopus octo = new Octopus();
			octopuses.add(octo);
			addObject(octo, (i * 5) + 5, 25);
		}

		for (int i = 11; i < 22; i++) {
			Octopus s = new Octopus();
			octopuses.add(s);
			addObject(s, ((i * 5) + 5) - 55, 30);
		}
		chance += 4;
		invaders = 55;
	}

	/**
	 * Returns the chance of the alien to shoot.
	 * 
	 * @return the chance to shoot.
	 */
	public double getChance() {
		return chance;
	}
}
