
public class EnemyBullet extends Actor{
	
	private GreenfootImage img1; //1st animation
    
    private GreenfootImage img2; //2nd animation
    
    public Ebullet() //creation code, sets two variables with the two images
    {
        img1 = getImage(); //current image
        img2 = new GreenfootImage("ebullet-2.gif"); //second image
    }
    
    public void act() 
    {
      int y = getY();
      y = y+1;
      setLocation(getX(), y);
       
      if (getY() + 5 == getWorld().getHeight()) {
          destroy();
      }
      if (getImage() == img1) {
          setImage(img2);
      } else {
          setImage(img1);
      }
    }    
    
    private void destroy() {
        getWorld().removeObject(this);
    }

}
