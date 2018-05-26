import greenfoot.*;
import java.util.*;

/**
 * The randomly spawned, random points alien flying on the top of the screen.
 * 
 * @author Jason Yang, Sai Enduri, Krish G
 * @version 5/24/2018
 */
public class UFO extends Actor {
	private int moveTimer;
	GreenfootImage img1;

	public UFO() {
		img1 = getImage();
	}

	/**
	 * Deals with bullets if they hit this object and moves.
	 */
	public void act() {
		List<PlayerBullet> bullets = getNeighbours(3, false, PlayerBullet.class);
		if (!bullets.isEmpty()) {
			Actor b = (Actor) bullets.get(0);
			if (b instanceof PlayerBullet) {
				MyWorld world = (MyWorld) getWorld();
				world.removeObject(bullets.get(0));
				world.setShoot(1);
				destroy();
				return;
			}
		} else {
			move();
		}
	}

	/**
	 * Gives the user a random number of points from 100 to 149 and replaces this
	 * object with a dead one.
	 */
	public void destroy() {
		((MyWorld) getWorld()).addPoints((int) (Math.random() * 50 + 100));
		((MyWorld) getWorld()).addObject(new DeadUFO(this), getX(), getY());
		((MyWorld) getWorld()).removeObject(this);
	}

	/**
	 * Moves one pixel to the right until it reaches the 97th pixel.
	 */
	public void move() {
		setLocation(getX() + 1, getY());
		if (getX() >= 97) {
			getWorld().removeObject(this);
		}
	}
}
