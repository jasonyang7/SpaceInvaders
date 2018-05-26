import greenfoot.*;

/**
 * Plays an animation when the spaceship dies.
 * 
 * @author Jason Yang, Sai Enduri, Krish G
 * @version 5/24/2018
 */
public class Dead extends Actor {
	private int time;
	private GreenfootImage img1;
	private GreenfootImage img2;

	/**
	 * Initiates the time to zero and sets the two images.
	 */
	public Dead() {
		time = 0;
		img1 = getImage();
		img2 = new GreenfootImage("images/shipdie-2.gif");
	}

	/**
	 * Waits for twenty five acts, then the object is removed from the grid.
	 */
	public void act() {
		time++;
		if (time > 25) {
			MyWorld world = ((MyWorld) getWorld());
			world.die();
			getWorld().removeObject(this);
		} else {
			if (getImage() == img1) {
				setImage(img2);
			} else {
				setImage(img1);
			}
		}
	}
}
