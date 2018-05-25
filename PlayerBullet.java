import greenfoot.*; 
/**
 * The bullet that the player shoots. It is shot when the player hits the up arrow key, and it is dissolved when it either hits the top of 
 * the screen or hits an alien.
 * 
 * @author Jason Yang, Sai Enduri, Krish G
 * @version 5/24/2018
 */
public class PlayerBullet extends Actor
{
    /**
     * The player bullet moves three pixels upward, and it is updated each pixel it moves up. When it reaches the edge of the screen, 
     */
    public void act() 
    {
       int y = getY();
       y = y-1;
       setLocation(getX(), y);
       y = y-1;
       setLocation(getX(), y);
       y = y-1;
       setLocation(getX(), y);
       if (getY() <= 1) 
       {
           ((MyWorld) getWorld()).SetShoot(1);
           destroy();
       }
    }    
    
    /**
     * The bullet is removed from the world.
     */
    private void destroy() 
    {
    	getWorld().removeObject(this);
    }  
}
