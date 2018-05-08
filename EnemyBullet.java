import greenfoot.*;

public class EnemyBullet extends Actor {
	
	private GreenfootImage img1, img2;
    private int x, y;
    
    public EnemyBullet(int xcoor, int ycoor) //creation code, sets two variables with the two images
    {
        img1 = new GreenfootImage("images/ebullet.gif");
        img2 = new GreenfootImage("images/ebullet-2.gif");
        setImage(img2);
        x = xcoor;
        y = ycoor;
        setLocation(x, y);
        setRotation(90);
    }
    /**
     * The bullet moves forward one step
     */
    public void act() 
    {
    	move(1);
    }    
    /**
     * The bullet hits the bottom
     * The bullet hits the barrier
     * The bullet hits the player
     */
    private void destroy() {
        if (getOneIntersectingObject(Actor.class).equals(Barrier.class)) {
        	setImage((String) null);
        	
        }
        if (getOneIntersectingObject(Actor.class).equals(Ship.class)) {
        	setImage((String) null);
        }
    }

}
