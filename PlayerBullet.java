import java.util.*;
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class PlayerBullet extends Actor
{

    private Ship ship;

    public GreenfootImage img1;


    public void PlayerBullet()
    {
        img1 = new GreenfootImage( "PLAYERBULLET" );
    }


    public void act()
    {
        int y = getY();
        y = y - 4;
        setLocation( getX(), y );
        if ( getY() == 0 )
        {
            destroy();
        }

    }


    private void destroy()
    {
        getWorld().removeObject( this );
    }

}
