import greenfoot.*;
import java.util.*;

/**
 * The animation that plays when the UFO dies.
 * 
 * @author Jason Yang, Sai Enduri, Krish G
 * @version 5/24/2018
 */
public class DeadUFO extends Actor {
	private int time = 0;
	private GreenfootImage img1;
	private UFO dead;
	private int direction;
	private int shouldMove;
	private int shouldSwitch;

	/**
	 * Initializes the image and sets the dead UFO variable.
	 * 
	 * @param unidentified
	 *            the dead UFO
	 */
	public DeadUFO(UFO unidentified) {
		img1 = getImage();
		dead = unidentified;
	}

	/**
	 * Moves with the rest of the world, then deletes the image once it is dead.
	 */
	public void act() {
		move();
		if (getImage() != null) {
			getWorld().removeObject(this);
			return;
		}
	}

	/**
	 * Moves the x location of the object one pixel to the right.
	 */
	public void move() {
		setLocation(getX() + 1, getY());
		if (getX() >= 97) {
			getWorld().removeObject(this);
		}
	}

	/**
	 * Removes the object from the world.
	 */
	public void destroy() {
		if (getImage() != null) {
			getWorld().removeObject(this);
		}
	}
}
