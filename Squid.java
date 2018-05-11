import greenfoot.*;

public class Squid extends Octopus{
	
	public Squid()
    {
        img1 = new GreenfootImage("squidnormal.jpeg");
        img2 = new GreenfootImage("squidhit.jpeg");
    }
    
    public void destroy() 
    {
        Space world = ((Space) getWorld());
        world.addPoints(30); 
        world.invaders--;
        if (world.invaders == 0) {
            ((Space) getWorld()).populate();
        }
        getWorld().removeObject(this); 
    }

}
