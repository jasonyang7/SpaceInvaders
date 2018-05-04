import java.util.Iterator;
import java.util.List;

import greenfoot.*;

public class Octopus extends Actor{
	
	/**
	 * new comment here
     * Act - do whatever the Enemy1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int dir = 1; //1 = left 2 = right
    
    public int movetimer = 0; //timer value to move at cetain intervals
    
    public int shouldMove = 0; //weather or not they should move
    
    public int shouldCar = 0;
    
    public GreenfootImage img1; //1st animation
    
    public GreenfootImage img2; //2nd animation
    
    public int shoot; //variable to determine if wea should shoot or not. starting chance is 2%
    
    public int chance = 1; //chance to shoot, starts at 2%
    
    public Octopus() //creation code, sets two variables with the two images
    {
        img1 = getImage(); //current image
        img2 = new GreenfootImage("enemy1-2.gif"); //second image
    }
    
    public void act() //main loop event, inherited from Actor class
    {
       List bullets = getNeighbours(3, false, PlayerBullet.class); //new list with all Pbullets within 2 uinits adjacent to the enemy
       if (!bullets.isEmpty()) { //is there is one (there will only be one, since only one bullet on screen at a time)
       Actor pBullet = (Actor) bullets.get(0); //gets the first object in the list
       if (pBullet instanceof PlayerBullet) { //just an extra check to make sure its a player bullet
           ((Space) getWorld()).ShootSet(1); //allow us to fire again
           getWorld().removeObject(pBullet); //remobe the bullet
           destroy(); //call the destroy funcrtion
       }
       } else {
           shoot();
           move();    //if we are still alive move
       }
    }
    
    public void destroy() //desttroy functon
    {
        Greenfoot.playSound("invaderkilled.wav"); //sound
        ((Space) getWorld()).addPoints(10); //add points
        ((Space) getWorld()).invaders--;
        if (((Space)getWorld()).invaders <= 0) {
            ((Space) getWorld()).populate();
            ((Space)getWorld()).invaders = 50;
        }
        getWorld().removeObject(this); //remove the instance
    }
    
    public void shoot()
    {
        if (shouldMove == 1) {
            shoot = Greenfoot.getRandomNumber(100);
            if (shoot <= chance) {
                getWorld().addObject(new EnemyBullet(), getX(), getY()+5);
            }
        }
    }
        
        
    
    public void move() //move function, called in step
    {
        if (dir == 1 && shouldCar == 1) {
            if (getX() + 5 >= getWorld().getWidth()) { //if the next move would put us out of the map
                moveRight(); //call the carride function
                moveAlliesRight(); //bring our buddies
                movetimer = 0; //reset timer
                shouldMove = 0; //dont move
            }
        } else if (dir == 2 && shouldCar == 1) {
            if (getX() - 5 <= 0) {
                moveLeft();
                moveAlliesLeft();
                movetimer = 0;
                shouldMove = 0;
            }
        }
        if (dir == 1 && shouldMove == 1) { //if we are moving left and we can move
            if (getImage() == img1) { //change animation
                setImage(img2); 
            } else {
                setImage(img1);
            }
            setLocation(getX()+5, getY()); //move
            shouldMove = 0; //we cant move again yet
        } else if (dir == 2 && shouldMove == 1) { //same stuff as before
            if (getImage() == img1) {
                setImage(img2);
            } else {
                setImage(img1);
            }
            setLocation(getX()-5, getY()); //move
            shouldMove = 0;
        } else if (shouldMove == 0) { //if we cant move
            movetimer++; //add one to the timer
            if (movetimer == 24) {//if its at 24 steps
                shouldCar = 1; //check for caridge returns
            } else if (movetimer == 25) {
                shouldMove = 1; //we can move again
                shouldCar = 0; //dont want to caridge return now.
                movetimer = 0;
            }
        }
    }
    
    private void moveRight() //moving down and switching direction function
    {
        setLocation(getX(), getY() + 5); //move down
        dir = 2;//change direction
        chance = chance+1; //increases our chance to fire
        if (getY() > 60) {
            ((Space) getWorld()).gameOver();
        }
    }
    
    private void moveLeft()//same as above
    {
        setLocation(getX(), getY() + 5);
        dir = 1;
        chance = chance+1;
    }
    
    private void moveAlliesRight()//executes the preceding function on the other enemies
    {
        List allies = getWorld().getObjects(Octopus.class);//list of all the other enemies
        Iterator iter = allies.iterator();//create an iterator in that list
        while(iter.hasNext()) {//if theres more enemies to move
            Octopus oct = (Octopus) iter.next();//put the enemy into a variable
            if ( oct != this) {//if they arent us (cuz we all ready moved)
                oct.moveRight();//move them down
                oct.setLocation(oct.getX(), oct.getY());
                oct.shouldMove = 0;
                oct.movetimer = 0;
                if (getImage() != oct.getImage()) {
                    setImage(oct.getImage());
                }
            }
        }
    }
    
    private void moveAlliesLeft()//same as above
    {
        List allies = getWorld().getObjects(Octopus.class);
        Iterator iter = allies.iterator();
        while(iter.hasNext()) {
            Octopus oct = (Octopus) iter.next();
            if ( oct != this) {
                oct.moveLeft();
                oct.setLocation(oct.getX(), oct.getY());
                oct.shouldMove = 0;
                oct.movetimer = 0;
                if (getImage() != oct.getImage()) {
                    setImage(oct.getImage());
                }
            }
        }
    } 

}
