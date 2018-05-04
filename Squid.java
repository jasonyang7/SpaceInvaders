
public class Squid extends Octopus{
	
	public Squid()
    {
        img1 = getImage();
        img2 = new GreenfootImage("enemy3-2.gif");
    }
    
    public void destroy() //desttroy functon
    {
        Greenfoot.playSound("invaderkilled.wav"); //sound
        ((Space) getWorld()).addPoints(30); //add points
        ((Space) getWorld()).invaders--;
        if (((Space)getWorld()).invaders <= 0) {
            ((Space) getWorld()).populate();
            ((Space)getWorld()).invaders = 50;
        }
        getWorld().removeObject(this); //remove the instance
    }

}
