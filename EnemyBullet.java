import greenfoot.*;

public class EnemyBullet extends Actor {
	
	private GreenfootImage img;
    private int x, y;
    int speed;
    
    public EnemyBullet() //creation code, sets two variables with the two images
    {
        img = new GreenfootImage("images/enemybullet.png");
        setImage(img);
        setRotation(180);
        speed = 1;
    }
    
    /**
     * The bullet moves forward one step
     */
    
    public void act() 
    {
    	move(speed);
    }    
    
    /**
     * The bullet hits the bottom
     * The bullet hits the barrier
     * The bullet hits the player
     */
    private void destroy() {
    	if (getOneIntersectingObject(EnemyBullet.class) != null) {
    		getWorld().removeObject(this);
    	}
    }
    
    public void changeSpeed(int i) {
    	speed = i;
    }
}
