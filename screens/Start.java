package screens;

import greenfoot.*;
import levels.Level1;

public class Start extends World {
    private int count = 1000;

    public Start() {    
        super(500, 500, 1);
    }
    
    public void act() {
        showText("" + count/100, 250, 250);
        
        if (count == 0) {
            Greenfoot.setWorld(new Level1());
        }
        count--;
    }
}
