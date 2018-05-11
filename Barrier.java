import greenfoot.*;

public class Barrier extends Actor {
	
	//4 images used based on the amount of times its hit
    public int damage = 0;
    
    private GreenfootImage img0, img1, img2, img3;
    
    public Barrier()
    {
        img0 = new GreenfootImage("images/barrier0.jpeg");
        img1 = new GreenfootImage("images/barrier1.jpeg");
        img2 = new GreenfootImage("images/barrier2.jpeg");
        img3 = new GreenfootImage("images/barrier3.jpeg");
        setImage(img0);
    }
        
    public void act() 
    {
    	Actor intersect = getOneIntersectingObject(Barrier.class);
    	if (intersect.equals(EnemyBullet.class)) {
    		damage++;
    	}
    	if (damage == 1) {
    		setImage(img1);
    	}
    	else if (damage == 2) {
    		setImage(img2);
    	}
    	else if (damage == 3) {
    		setImage(img3);
    	}
    	else {
    		setImage((String) null);
    	}
    }

}
