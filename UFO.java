import java.util.List;

import greenfoot.*;

public class UFO extends Actor
{
	public UFO()
    {
        GreenfootImage img1 = new GreenfootImage("ufo.jpeg");
        setImage(img1);
    }
    
    /**
     * Act - do whatever the UFO wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       List<PlayerBullet> bullets = getNeighbours(3, false, PlayerBullet.class); 
       
       if (!bullets.isEmpty()) 
       { 
		   ((Space) getWorld()).SetShoot(1);
		   getWorld().removeObject(bullets.get(0)); 
		   destroy(); 
       } 
       else 
       {
           move();
       }

    }
    
    public void destroy()
    {
        ((Space) getWorld()).addPoints((int)Math.random()*50 + 100); 
        getWorld().removeObject(this);
    }
    
    public void move()
    {
        setLocation(getX() + 5, getY());
        if (getX() > 100)
        {
        	getWorld().removeObject(this);
        }
    }

}
