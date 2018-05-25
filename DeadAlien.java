import greenfoot.*;
import java.util.*;
/**
 * The animation that plays when an alien dies.
 * 
 * @author Jason Yang, Sai Enduri, Krish G
 * @version 5/24/2018
 */
public class DeadAlien extends Actor
{
    private int time;
    private GreenfootImage img1;
    private Octopus octo;
    private int direction;
    private int shouldMove;
    private int shouldSwitch;
    
    /**
     * Constructs the DeadAlien to be in the place of the dead alien, with the direction and movement set to be the same as the alien.
     * 
     * @param oct the dead Alien that is passed in
     */
    public DeadAlien(Octopus oct)
    {
        time = 0;
        img1 = getImage(); 
        octo = oct;
        direction = octo.direction;
        shouldMove = octo.shouldMove;
        shouldSwitch = octo.shouldSwitch;
    }
    
    /**
     * Makes the DeadAlien move for ten act calls, then removes itself from the world.
     */
    public void act() 
    {
        time++;
        if (time > 10 && this != null) {
            MyWorld world = ((MyWorld) getWorld());
        } 
        else {
            move();
        }   
        getWorld().removeObject(this);
        return;
    }
    
    /**
     * The DeadAlien moves exactly the same as the octopus class.
     */
    public void move()
    {
        if (direction == 1 && shouldSwitch == 1) 
        {
            if (getX() + 10 > getWorld().getWidth())
            {
                switchDirectionR(); 
                time = 0;
                shouldMove = 0;
            }
        } 
        
        else if (direction == 2 && shouldSwitch == 1) 
        {
            if (getX() - 10 < 0)
            {
                switchDirectionL();
                time = 0;
                shouldMove = 0; 
            }
            
        }
        
        if (direction == 1 && shouldMove == 1) 
        { 
            setLocation(getX()+4, getY()); 
            shouldMove = 0; 
        } 
        
        else if (direction == 2 && shouldMove == 1) 
        { 
            setLocation(getX()-4, getY()); 
            shouldMove = 0;
        } 
        
        else if (shouldMove == 0) 
        { 
            time++;
            if (time == 24) 
            {
                shouldSwitch = 1; 
            } 
            else if (time == 25) 
            {
                shouldMove = 1; 
                shouldSwitch = 0; 
                time = 0;
            }
        }
    }
    
    /**
     * Switches the DeadAlien's direction to the right.
     */
    private void switchDirectionR()
    {
        setLocation(getX(), getY() + 5);
        direction = 2;
        
        if (getY() > 70) 
        {
            ((MyWorld) getWorld()).gameOver();
        }
    }
    
    /**
     * Switches the DeadAlien's direction to the left.
     */
    private void switchDirectionL()
    {
        setLocation(getX(), getY() + 5);
        direction = 1;
        
        if (getY() > 70) 
        {
            ((MyWorld) getWorld()).gameOver();
        }
    }
}
