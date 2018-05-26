import greenfoot.*;

/**
 * The crab is the alien in the third and fouth layers of the alien team.
 * 
 * @author Jason Yang, Sai Enduri, Krish G
 * @version 5/24/2018
 */
public class Crab extends Octopus {
	/**
	 * Sets the two images.
	 */
	public Crab() {
		img1 = getImage();
		img2 = new GreenfootImage("crab-2.gif");
	}

	/**
	 * Gives the player twenty points, plays the dead alien animation, and updates
	 * the remaining number of invaders.
	 */
	public void destroy() {
		MyWorld world = ((MyWorld) getWorld());
		getWorld().addObject(new DeadAlien(this), getX(), getY());
		world.addPoints(20);
		world.invaders--;
		if (world.invaders == 0) {
			world.populate();
			world.invaders = 50;
		}
		getWorld().removeObject(this);
	}
}
