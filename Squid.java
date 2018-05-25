import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Squid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Squid extends Octopus
{
    public Squid()
    {
        img1 = getImage();
        img2 = new GreenfootImage("octopus-2.gif");
    }
    
    public void destroy() 
    {
        MyWorld world = ((MyWorld) getWorld());
        getWorld().addObject(new DeadAlien(this), getX(), getY());
        world.addPoints(40); 
        world.invaders--;
        if (world.invaders == 0) {
            ((MyWorld) getWorld()).populate();
        }
        getWorld().removeObject(this); 
    }   
}
