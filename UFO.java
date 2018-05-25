import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class UFO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UFO extends Actor
{
    private int moveTimer;
    GreenfootImage img1;
    
    public UFO()
    {
        img1 = getImage();
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
           Actor b = (Actor) bullets.get(0); 
           if (b instanceof PlayerBullet) 
           {
               MyWorld world = (MyWorld) getWorld();
               world.removeObject(bullets.get(0)); 
               world.SetShoot(1); 
               destroy(); 
               return;
           }
       } 
       else 
       {
           move();    
       }
    }
    
    public void destroy()
    {
        ((MyWorld) getWorld()).addPoints((int) (Math.random()*50 + 100)); 
        ((MyWorld) getWorld()).addObject(new DeadUFO(this), getX(), getY());
        ((MyWorld) getWorld()).removeObject(this);
    }
    
    public void move()
    {
        setLocation(getX() + 1, getY());
        if (getX() >= 97)
        {
            getWorld().removeObject(this);
        }
    }    
}
