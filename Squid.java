import greenfoot.*;

/**
 * The squid is the smallest invader, with a row of them on the top.
 * 
 * @author Jason Yang, Sai Enduri, Krish G
 * @version 5/24/2018
 */
public class Squid extends Octopus {

	/**
	 * Sets the two images of the squid.
	 */
	public Squid() {
		img1 = getImage();
		img2 = new GreenfootImage("octopus-2.gif");
	}

	/**
	 * Replaces this object with a dead alien and populates the invaders if there
	 * are none left.
	 */
	public void destroy() {
		MyWorld world = ((MyWorld) getWorld());
		getWorld().addObject(new DeadAlien(this), getX(), getY());
		world.addPoints(40);
		world.invaders--;
		if (world.invaders == 0) {
			((MyWorld) getWorld()).populate();
		}
		getWorld().removeObject(this);
	}
}
