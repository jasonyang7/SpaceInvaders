import java.util.List;

import greenfoot.*;

public class Ship extends Actor
{ 
	GreenfootImage img1;
	
	public Ship() 
    {
        img1 = new GreenfootImage("loadingspaceship.jpeg");
        setImage(img1);
    }
    
    public void act() 
    {
       List<EnemyBullet> bullets = getNeighbours(3, false, EnemyBullet.class); 
       if (!bullets.isEmpty()) 
       { 
           getWorld().removeObject(bullets.get(0)); 
           destroy(); 
       }
       else 
       {
    	   perform();
       }
    }    
    
    private void perform() {
        int x = getX();
        
        if(Greenfoot.isKeyDown("right")) {
            x = x+1;
            setLocation(x, getY());
        }
        
        if(Greenfoot.isKeyDown("left")) {
            x = x-1;
            setLocation(x, getY());
        }
        
        if (Greenfoot.isKeyDown("up") && ((Space) getWorld()).CanShoot()) 
        {
            getWorld().addObject(new PlayerBullet(), getX(), getY()-2);
            Space world = ((Space) getWorld());
            world.SetShoot(0);
        }   
    }

    private void destroy() 
    {
        getWorld().addObject(new Dead(), getX(), getY());
        Space world = ((Space) getWorld());
        world.SetShoot(0);
        world.removeObject(this);
    }
}

