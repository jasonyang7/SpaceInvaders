import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Jason Yang
 * @version 5/3/2018
 */
public class MyWorld extends World
{
	
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public void putActors() {
    		for (int i = 0; i < 10; i++) {
    			Squid s = new Squid();
    			squids.add(s);
    			this.addObject(s, i*10+1, 10);
    		}
    		for (int i = 0; i < 10; i++) {
    			Squid s = new Squid();
    			squids.add(s);
    			this.addObject(s, i*10+1, 10);
    		}
    		for (int i = 0; i < 10; i++) {
    			Squid s = new Squid();
    			squids.add(s);
    			this.addObject(s, i*10+1, 10);
    		}
    }
}
