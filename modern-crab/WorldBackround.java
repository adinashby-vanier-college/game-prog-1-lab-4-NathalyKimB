// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class WorldBackround extends World
{

    /**
     * Constructor for objects of class WorldBackround.
     */
    public WorldBackround()
    {
        super(600, 400, 1);
        showText("YouWonTheGame!", 260, 260);
    }

    /**
     * 
     */
    public void showTextWithBigBlackFont(String message, int x, int y)
    {
        GreenfootImage bg = getBackground();
        Font font =  new Font(60);
        bg.setFont(font);
        bg.setColor(Color.BLACK);
        bg.drawString(message, x, y);
    }
}
