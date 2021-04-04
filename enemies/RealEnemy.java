package enemies;

import greenfoot.*;
import levels.Level1;
import levels.Level2;
import levels.Level3;
import players.Player;
import players.Turtle;

public class RealEnemy extends Player {
    public RealEnemy() {
        
    }
    
    public int count = 0;
    public void act() {
        move(Greenfoot.getRandomNumber(2));
        if (count == 500) {
            turn(Greenfoot.getRandomNumber(181));
            count = 0;
        }
        count++;
        catchTurtle();
    }
    
    boolean firstTime = true;
    public void catchTurtle() {
        Actor turtle = getOneObjectAtOffset(0, 0, Turtle.class);
        if (turtle != null && firstTime) {
            if (getWorld() instanceof Level1) {
                Level1 myWorld = (Level1) getWorld();
                Counter count = myWorld.getCounter();
                count.removeScore();
                Turtle turtl = myWorld.getTurtle();
                turtl.stunTimer = 200;
            } else if (getWorld() instanceof Level2) {
                Level2 myWorld = (Level2) getWorld();
                Counter count = myWorld.getCounter();
                count.removeScore();
                Turtle turtl = myWorld.getTurtle();
                turtl.stunTimer = 200;
            } else if(getWorld() instanceof Level3) {
                Level3 myWorld = (Level3) getWorld();
                Counter count = myWorld.getCounter();
                count.removeScore();
                Turtle turtl = myWorld.getTurtle();
                turtl.stunTimer = 200;
            }
            firstTime = false;
        }
        if (turtle == null) {
            firstTime = true;
        }
    }
}
