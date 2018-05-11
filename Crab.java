// need change
import greenfoot.*;


public class Crab extends Octopus{
	
	public Crab() 
    {
        img1 = new GreenfootImage("crabnormal.jpeg"); 
        img2 = new GreenfootImage("crabhit.jpeg"); 
    } 
    
    public void destroy()
    {
        Space world = ((Space) getWorld());
        world.addPoints(20); 
        world.invaders--;
        if (world.invaders == 0) 
        {
            world.populate();
            world.invaders = 50;
        }
        getWorld().removeObject(this); 
    }

}
