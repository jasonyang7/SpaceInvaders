import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{

	/**
     * Constructor for objects of class Space.
     * 
     */
    public Space()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public void populate()
    {
        addObject(new UFO(), 5, 10);
        
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
        
        
    }
}
