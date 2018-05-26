import greenfoot.*;
import java.util.*;

/**
 * The spaceship that the player controls on the bottom of the screen.
 * 
 * @author Jason Yang, Sai Enduri, Krish G
 * @version 5/24/2018
 */
public class Ship extends Actor {

	/**
	 * Checks and deals with potential bullets that hit the ship, then moves
	 * accordingly.
	 */
	public void act() {
		List<EnemyBullet> bullets = getNeighbours(3, false, EnemyBullet.class);
		if (!bullets.isEmpty()) {
			Actor bullet = (Actor) bullets.get(0);
			if (bullet instanceof EnemyBullet) {
				getWorld().removeObject(bullet);
				destroy();
			}
		} else {
			perform();
		}
	}

	/**
	 * Moves the ship to the left/right when pressing the left/right arrow keys.
	 * Shoots when the up arrow key is pressed and the player can shoot.
	 */
	private void perform() {
		int x = getX();
		if (Greenfoot.isKeyDown("right")) {
			x = x + 1;
			setLocation(x, getY());
		}
		if (Greenfoot.isKeyDown("left")) {
			x = x - 1;
			setLocation(x, getY());
		}
		if (Greenfoot.isKeyDown("up") && ((MyWorld) getWorld()).canShoot()) {
			getWorld().addObject(new PlayerBullet(), getX(), getY() - 2);
			MyWorld world = ((MyWorld) getWorld());
			world.setShoot(0);
		}
	}

	/**
	 * Replaces the object with a dead animation and sets the shoot to 0.
	 */
	private void destroy() {
		getWorld().addObject(new Dead(), getX(), getY());
		MyWorld world = ((MyWorld) getWorld());
		world.setShoot(0);
		world.removeObject(this);
	}
}
