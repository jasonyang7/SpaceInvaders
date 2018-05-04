
public class Crab extends Octopus{
	
	public Crab() //creation code, sets two variables with the two images
    {
        img1 = getImage(); //current image
        img2 = new GreenfootImage("enemy2-2.gif"); //second image
    } 
    
    public void destroy() //desttroy functon
    {
        Greenfoot.playSound("invaderkilled.wav"); //sound
        ((Space) getWorld()).addPoints(20); //add points
        ((Space) getWorld()).invaders--;
        if (((Space)getWorld()).invaders <= 0) {
            ((Space) getWorld()).populate();
            ((Space)getWorld()).invaders = 50;
        }
        getWorld().removeObject(this); //remove the instance
    }

}
