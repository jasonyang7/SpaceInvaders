import greenfoot.*;

/**
 * The Enemy Bullet tries to hit the player, and it also destroys the barriers.
 * 
 * @author Jason Yang, Sai Enduri, Krish G
 * @version 5/24/2018
 */
public class EnemyBullet extends Actor {
	private GreenfootImage img1;
	private GreenfootImage img2;

	/**
	 * Sets the two images.
	 */
	public EnemyBullet() {
		img1 = getImage();
		img2 = new GreenfootImage("enemybullet-2.gif");
	}

	/**
	 * Makes the bullet move one pixel up and alternates the image.
	 */
	public void act() {
		int y = getY();
		y++;
		setLocation(getX(), y);

		if (getY() + 5 == getWorld().getHeight()) {
			destroy();
		}

		if (getImage() == img1) {
			setImage(img2);
		} else {
			setImage(img1);
		}
	}

	/**
	 * Removes the object from the world.
	 */
	private void destroy() {
		getWorld().removeObject(this);
	}
}
