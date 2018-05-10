import greenfoot.*;

public class Barrier extends Actor {
	
	//4 images used based on the amount of times its hit
    public int num =4;
    
    private GreenfootImage img1;
    
    private GreenfootImage img2;
    
    private GreenfootImage img3;
    
    private GreenfootImage img4;
    
    public Barrier()
    {
        img1 = getImage();
        img2 = new GreenfootImage("barrier-2.gif");
        img3 = new GreenfootImage("barrier-3.gif");
        img4 = new GreenfootImage("barrier-4.gif");
    }
        
    public void act() 
    {
       
    }

}
