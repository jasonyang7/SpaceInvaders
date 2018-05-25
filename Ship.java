import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    
    public void act() 
    {
       List<EnemyBullet> bullets = getNeighbours(3, false, EnemyBullet.class); 
       if (!bullets.isEmpty()) 
       { 
           Actor bullet = (Actor) bullets.get(0); 
           if (bullet instanceof EnemyBullet) 
           { 
               getWorld().removeObject(bullet);
               destroy(); 
           }
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
        
        if (Greenfoot.isKeyDown("up") && ((MyWorld) getWorld()).CanShoot()) 
        {
            getWorld().addObject(new PlayerBullet(), getX(), getY()-2);
            MyWorld world = ((MyWorld) getWorld());
            world.SetShoot(0);
        }   
    }

    private void destroy() 
    {
        getWorld().addObject(new Dead(), getX(), getY());
        MyWorld world = ((MyWorld) getWorld());
        world.SetShoot(0);
        world.removeObject(this);
    }   
}
