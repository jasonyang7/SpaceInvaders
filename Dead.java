import greenfoot.*;

public class Dead extends Actor
{
	private int time = 0;
    
    private GreenfootImage img1;
    
    private GreenfootImage img2;
    
    public Dead()
    {
        img1 = getImage();
        img2 = new GreenfootImage("images/spaceshipdeath.png"); 
    }

    public void act() 
    {
        time++;
        if (time > 22) {
            Space world = ((Space) getWorld());
            world.die();
            getWorld().removeObject(this);
        } 
        else 
        {
            if (getImage() == img1) 
            {
                setImage(img2);
            } 
            else 
            {
                setImage(img1);
            }
        }
            
    }  
}
