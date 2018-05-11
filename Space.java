import java.util.LinkedList;


import greenfoot.*;
import java.util.*;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
	
	public int shot = 1;
    
    public int invaders = 50;
    
    NumberListener score = new NumberListener("Score: ");
    
    NumberListener lives = new NumberListener("Lives: ");
    
    public Space()
    {    
        
        super(100, 100, 5); 
        addObject(new Ship(), 50, 90);
        addObject(new Barrier(), 75, 70);
        addObject(new Barrier(), 50, 70);
        addObject(new Barrier(), 25, 70);
        addObject(score, 15, 90);
        addObject(lives, 95, 90);
        lives.add(3);
        populate();
    }
    
    public void SetShoot(int num)
    {
        shot = num;
    }
    
    public boolean CanShoot()
    {
        return shot == 1;
    }
    
    public void addPoints(int pts)
    {
        score.add(pts);
    }
    
    public void die()
    {
        lives.subtract(1);
        if (lives.getValue() == 0) {
            gameOver();
        }
         
        addObject(new Ship(), 50, 90);
        shot = 1;
    }
    
    public void gameOver() 
    {
        addObject(new GameOverScore(score.getValue()), getWidth()/2, getHeight()/2);
        Greenfoot.stop();
    }
    
    public void addUFO()
    {
    	addObject(new UFO(), 5, 10);
    }
    
    public void populate()
    {
        
        
        LinkedList<Squid> squids = new LinkedList<Squid>();
        for ( int i = 0; i <10; i++ ) {
            Squid s = new Squid();
            squids.add(s);
            addObject(s, (i*5)+5, 10);
        }
        

        for ( int i = 11; i <21; i++ ) {
            Squid s = new Squid();
            squids.add(s);
            addObject(s, ((i*5)+5) - 55, 15);
        }
        
        LinkedList<Crab> crabs = new LinkedList<Crab>();
        for ( int i = 0; i <10; i++ ) {
            Crab c = new Crab();
            crabs.add(c);
            addObject(c, (i*5)+5, 20);
        }
        

        for ( int i = 11; i <21; i++ ) {
            Crab c = new Crab();
            crabs.add(c);
            addObject(c, ((i*5)+5) - 55, 25);
        } 
        

        LinkedList<Octopus> octopuses = new LinkedList<Octopus>();
        for ( int i = 0; i <10; i++ ) {
            Octopus octo = new Octopus();
            octopuses.add(octo);
            addObject(octo, (i*5)+5, 30);
        }
        
        invaders = 50;
    }
}
