package objects;

import greenfoot.*;
import players.Player;

public class BigFood extends Player {
	
    public BigFood() {
        
    }
    
    public int count = 0;
    
    public void act() {
        move(Greenfoot.getRandomNumber(3));
        if(count == 500) {
            turn(Greenfoot.getRandomNumber(181));
            count = 0;
        }
        
        count++;
    }
}