import java.util.Iterator;
import java.util.List;

import greenfoot.*;

public class Octopus extends Actor{
	
	/**
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public int time = 0; 
    
    public int shouldMove = 0; 
    
    public int shouldSwitch = 0;
    
    public int direction = 1; // 1 is left and 2 is right
    
    public GreenfootImage img1; 
    
    public GreenfootImage img2;  
    
    public int chance = 10; 
    
    public int ufoTimer = 0;
    
    public int shoot; 

    public Octopus() 
    {
        img1 = new GreenfootImage("images/octopusnormal.jpeg");
        img2 = new GreenfootImage("images/octopushit.jpeg");
    }
    
    public void act() 
    {
       List<PlayerBullet> bullets = getNeighbours(3, false, PlayerBullet.class); 
       ufoTimer++;
       if (ufoTimer > 50)
       {
    	   ((Space) getWorld()).addUFO();
    	   ufoTimer = 0;
       }
       if (!bullets.isEmpty()) 
       {
    	   Space world = (Space) getWorld();
    	   world.removeObject(bullets.get(0)); 
		   world.SetShoot(1); 
		   destroy(); 
       } 
       else 
       {
           shoot();
           move();    
       }
    }
    
    public void destroy()
    {
        Space world = (Space) getWorld();
        world.removeObject(this);
        world.invaders--;
        world.addPoints(10);
        
        if (world.invaders == 0) 
        {
            world.populate();
        }
    }
    
    public void shoot()
    {
        if (shouldMove == 1) 
        {
            if (Greenfoot.getRandomNumber(100) <= chance) 
            {
                getWorld().addObject(new EnemyBullet(), getX(), getY()+2);
            }
        }
    }
        
        
    
    public void move()
    {
        if (direction == 1 && shouldSwitch == 1) 
        {
	        switchDirectionR(); 
	        switchOthersRight(); 
	        time = 0;
	        shouldMove = 0;
        } 
        
        else if (direction == 2 && shouldSwitch == 1) 
        {
	        switchDirectionL();
	        switchOthersLeft();
	        time = 0;
	        shouldMove = 0;
        }
        
        if (direction == 1 && shouldMove == 1) 
        { 
            if (getImage() == img1) 
            {
                setImage(img2); 
            } 
            else 
            {
                setImage(img1);
            }
            setLocation(getX()+5, getY()); 
            shouldMove = 0; 
        } 
        
        else if (direction == 2 && shouldMove == 1) 
        { 
            if (getImage() == img1) 
            {
                setImage(img2);
            } 
            else 
            {
                setImage(img1);
            }
            setLocation(getX()-5, getY()); 
            shouldMove = 0;
        } 
        
        else if (shouldMove == 0) 
        { 
            time++;
            if (time == 24) 
            {
                shouldSwitch = 1; 
            } 
            else if (time == 25) 
            {
                shouldMove = 1; 
                shouldSwitch = 0; 
                time = 0;
            }
        }
    }
    
    private void switchDirectionR()
    {
        setLocation(getX(), getY() + 5);
        chance++;
        direction = 2;
        
        if (getY() > 60) 
        {
            ((Space) getWorld()).gameOver();
        }
    }
    
    private void switchDirectionL()
    {
        setLocation(getX(), getY() + 5);
        chance++;
        direction = 1;
        
        if (getY() > 60) 
        {
            ((Space) getWorld()).gameOver();
        }
    }
    
    private void switchOthersRight()
    {
        List<Octopus> allies = getWorld().getObjects(Octopus.class);
        Iterator<Octopus> iter = allies.iterator();
        while(iter.hasNext()) 
        {
            Octopus oct = (Octopus) iter.next();
            if ( oct != this) 
            {
                oct.switchDirectionR();
                oct.time = 0;
                oct.setLocation(oct.getX(), oct.getY());
                
                oct.shouldMove = 0;
                if (getImage() != oct.getImage()) 
                {
                    setImage(oct.getImage());
                }
            }
        }
    }
    
    private void switchOthersLeft()
    {
        List<Octopus> allies = getWorld().getObjects(Octopus.class);
        Iterator<Octopus> iter = allies.iterator();
        while(iter.hasNext()) 
        {
            Octopus oct = (Octopus) iter.next();
            if ( oct != this) 
            {
                oct.switchDirectionL();
                oct.time = 0;
                oct.setLocation(oct.getX(), oct.getY());
                
                oct.shouldMove = 0;
                if (getImage() != oct.getImage()) 
                {
                    setImage(oct.getImage());
                }
            }
        }
    } 

}
