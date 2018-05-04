import greenfoot.Actor;

public class PlayerBullet extends Actor{
	
	/**
     * Act - do whatever the pbullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Ship ship;
    
    public void act() 
    {
       int y = getY();
       y = y-3;
       setLocation(getX(), y);
       
       if (getY() == 0) {
           destroy();
        }
    }    
    
    private void destroy() {
        ((Space) getWorld()).ShootSet(1);
        getWorld().removeObject(this);
    }

}
