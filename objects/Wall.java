package objects;

import greenfoot.*;
import players.Player;

public class Wall extends Player {
    public Wall() {
        GreenfootImage wall = new GreenfootImage(3000, 250);
        wall.setColor(Color.BLACK);
        wall.fill();
        setImage(wall);
    }
}
