import greenfoot.*;
import java.util.*;

/**
 * The barrier protects the player from enemy bullets.
 * 
 * @author Jason Yang, Sai Enduri, Krish G
 * @version 5/24/2018
 */
public class Barrier extends Actor {
	public int num = 12;
	private GreenfootImage img1;
	private GreenfootImage img2;
	private GreenfootImage img3;
	private GreenfootImage img4;

	/**
	 * Barrier constructor has the four barrier images and increases their height
	 * and width by 10 pixels.
	 */
	public Barrier() {
		img1 = getImage();
		img2 = new GreenfootImage("barrier-2.gif");
		img3 = new GreenfootImage("barrier-3.gif");
		img4 = new GreenfootImage("barrier-4.gif");
		img1.scale(img1.getWidth() + 10, img1.getHeight() + 10);
		img2.scale(img2.getWidth() + 10, img2.getHeight() + 10);
		img3.scale(img3.getWidth() + 10, img3.getHeight() + 10);
		img4.scale(img4.getWidth() + 10, img4.getHeight() + 10);
	}

	/**
	 * The class takes note whenever an enemy bullet or player bullet hits the
	 * barrier. Every three times that the bullet hits the barrier, the barrier
	 * changes image.
	 */
	public void act() {
		List<EnemyBullet> ebullets = getNeighbours(5, false, EnemyBullet.class);
		if (!ebullets.isEmpty()) {
			Actor bullet = (Actor) ebullets.get(0);
			if (bullet instanceof EnemyBullet) {
				getWorld().removeObject(bullet);
				num--;
				if (num <= 0) {
					getWorld().removeObject(this);
				} else {
					if (num == 9) {
						setImage(img2);
					} else if (num == 6) {
						setImage(img3);
					} else if (num == 3) {
						setImage(img4);
					}
				}
			}
		}
		List<PlayerBullet> pbullets = getNeighbours(5, false, PlayerBullet.class);
		if (!pbullets.isEmpty()) {
			Actor bullet = (Actor) pbullets.get(0);
			if (bullet instanceof PlayerBullet) {
				((MyWorld) getWorld()).setShoot(1);
				getWorld().removeObject(bullet);
				num--;
				if (num <= 0) {
					getWorld().removeObject(this);
				} else {
					if (num == 9) {
						setImage(img2);
					} else if (num == 6) {
						setImage(img3);
					} else if (num == 3) {
						setImage(img4);
					}
				}
			}
		}
	}
}
