// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Lobster extends Actor
{

    /**
     * 
     */
    public Lobster()
    {
        turn(Greenfoot.getRandomNumber(359));
    }

    /**
     * Act - do whatever the Lobster wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAround();
        Actor crab = getOneObjectAtOffset(0, 0, Crab.class);
        if (crab != null) {
            getWorld().removeObject(crab);
        }
        if (isGameLost()) {
            transitionToGameOverWorld();
            Greenfoot.playSound("done.mp3");
        }
        Army();
    }

    /**
     * 
     */
    public void moveAround()
    {
        move(4);
        if (Greenfoot.getRandomNumber(10) == 1) {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        if (isAtEdge()) {
            turn(180);
        }
    }

    /**
     * 
     */
    public boolean foundCrab()
    {
        Actor crab = getOneObjectAtOffset(0, 0, Crab.class);
        return crab != null;
    }

    /**
     * 
     */
    public boolean foundWorm()
    {
        Actor worm = getOneObjectAtOffset(0, 0, Worm.class);
        return worm != null;
    }

    /**
     * 
     */
    public boolean isGameLost()
    {
        World world = getWorld();
        if (world.getObjects(Crab.class).isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * 
     */
    public void transitionToGameOverWorld()
    {
        World GameOverWorld =  new GameOverWorld();
        Greenfoot.setWorld(GameOverWorld);
    }

    /**
     * 
     */
    public void eat()
    {
        Actor worm = getOneIntersectingObject(Worm.class);
        if (worm != null) {
            World world = getWorld();
            world.removeObject(worm);
        }
    }

    /**
     * 
     */
    public void Army()
    {
        Actor worm = getOneIntersectingObject(Worm.class);
        if (worm != null) {
            World world = getWorld();
            int xlocation = worm.getX();
            int ylocation = worm.getY();
            world.removeObject(worm);
            Actor lobster =  new Lobster();
            world.addObject(lobster, xlocation, ylocation);
        }
    }
}
