import greenfoot.*;
import java.util.*;

/**
 * The basic alien class, also the alien on the bottom-most and second to bottom
 * levels.
 * 
 * @author Jason Yang, Sai Enduri, Krish G
 * @version 5/24/2018
 */
public class Octopus extends Actor {
	public int time = 0;
	public int shouldMove = 0;
	public int shouldSwitch = 0;
	public int direction = 1; // 1 is left and 2 is right
	public GreenfootImage img1;
	public GreenfootImage img2;
	public GreenfootImage img3;
	public int shoot;
	public int moveDistance;
	public int ufoTime;
	public int destroyTimer = 0;

	/**
	 * Sets the two images of the Octopus and initializes the move distance to 4
	 * pixels.
	 */
	public Octopus() {
		img1 = getImage();
		img2 = new GreenfootImage("squid-2.gif");
		moveDistance = 4;
	}

	/**
	 * The octopus shoots, moves, and deals with the bullets. Also, every once in a
	 * while, it adds an UFO to the world.
	 */
	public void act() {
		changeSpeed();
		ufoTime++;
		if (ufoTime == 400) {
			getWorld().addObject(new UFO(), 1, 5);
			ufoTime = 0;
		}
		List<PlayerBullet> bullets = getNeighbours(3, false, PlayerBullet.class);
		if (!bullets.isEmpty()) {
			Actor b = (Actor) bullets.get(0);
			if (b instanceof PlayerBullet) {

				MyWorld world = (MyWorld) getWorld();
				world.removeObject(bullets.get(0));
				world.setShoot(1);
				destroy();
			}
		} else {
			shoot();
			move();
		}
	}

	/**
	 * Destroys the octopus by replacing it with a DeadAlien. Populates the world if
	 * there are no more invaders.
	 */
	public void destroy() {

		MyWorld world = (MyWorld) getWorld();
		getWorld().addObject(new DeadAlien(this), getX(), getY());
		world.removeObject(this);
		world.invaders--;
		world.addPoints(10);

		if (world.invaders == 0) {
			world.populate();
		}
	}

	/**
	 * Changes the speed based on the number of aliens in the world.
	 */
	public void changeSpeed() {
		if (((MyWorld) getWorld()).invaders >= 45) {
			moveDistance = 5;
		} else if (((MyWorld) getWorld()).invaders >= 30) {
			moveDistance = 6;
		} else if (((MyWorld) getWorld()).invaders >= 20) {
			moveDistance = 7;
		} else if (((MyWorld) getWorld()).invaders >= 10) {
			moveDistance = 8;
		} else {
			moveDistance = 9;
		}
	}

	/**
	 * Shoots a bullet.
	 */
	public void shoot() {
		MyWorld world = (MyWorld) getWorld();
		if (shouldMove == 1) {
			if (Greenfoot.getRandomNumber(400) <= world.getChance()) {
				getWorld().addObject(new EnemyBullet(), getX(), getY() + 2);
			}
		}
	}

	/**
	 * Moves the aliens left and right.
	 */
	public void move() {

		if (direction == 1 && shouldSwitch == 1) {
			if (getX() + 10 > getWorld().getWidth()) {
				switchDirectionR();
				switchOthersRight();
				time = 0;
				shouldMove = 0;
			}
		}

		else if (direction == 2 && shouldSwitch == 1) {
			if (getX() - 10 < 0) {
				switchDirectionL();
				switchOthersLeft();
				time = 0;
				shouldMove = 0;
			}

		}

		if (direction == 1 && shouldMove == 1) {
			if (getImage() == img1) {
				setImage(img2);
			} else {
				setImage(img1);
			}
			setLocation(getX() + moveDistance, getY());
			shouldMove = 0;
		}

		else if (direction == 2 && shouldMove == 1) {
			if (getImage() == img1) {
				setImage(img2);
			} else {
				setImage(img1);
			}
			setLocation(getX() - moveDistance, getY());
			shouldMove = 0;
		}

		else if (shouldMove == 0) {
			time++;
			if (time == 24) {
				shouldSwitch = 1;
			} else if (time == 25) {
				shouldMove = 1;
				shouldSwitch = 0;
				time = 0;
			}
		}
	}

	/**
	 * Switches the alien's direction to the right.
	 */
	private void switchDirectionR() {
		MyWorld world = (MyWorld) getWorld();
		setLocation(getX(), getY() + 5);
		direction = 2;

		if (getY() > 70) {
			((MyWorld) getWorld()).gameOver();
		}
	}

	/**
	 * Switches the alien's direction to the left.
	 */
	private void switchDirectionL() {
		MyWorld world = (MyWorld) getWorld();
		setLocation(getX(), getY() + 5);
		direction = 1;
		if (getY() > 70) {
			((MyWorld) getWorld()).gameOver();
		}
	}

	/**
	 * Switches the direction for all of the other aliens to the right.
	 */
	private void switchOthersRight() {
		List<Octopus> allies = getWorld().getObjects(Octopus.class);
		Iterator<Octopus> iter = allies.iterator();
		while (iter.hasNext()) {
			Octopus oct = (Octopus) iter.next();
			if (oct != this) {
				oct.switchDirectionR();
				oct.time = 0;
				oct.setLocation(oct.getX(), oct.getY());

				oct.shouldMove = 0;
				if (getImage() != oct.getImage()) {
					setImage(oct.getImage());
				}
			}
		}
	}

	/**
	 * Switches the direction for all of the other aliens to the left.
	 */
	private void switchOthersLeft() {
		List<Octopus> allies = getWorld().getObjects(Octopus.class);
		Iterator<Octopus> iter = allies.iterator();
		while (iter.hasNext()) {
			Octopus oct = (Octopus) iter.next();
			if (oct != this) {
				oct.switchDirectionL();
				oct.time = 0;
				oct.setLocation(oct.getX(), oct.getY());

				oct.shouldMove = 0;
				if (getImage() != oct.getImage()) {
					setImage(oct.getImage());
				}
			}
		}
	}
}
