import greenfoot.*;

public class Counter extends Player {
	
    int score = 0;
    
    public Counter() {
        update();
    }
    
    public void update() {
        setImage(new GreenfootImage("Score: " + score + " Goal: 25", 24, Color.GREEN, Color.BLACK));
    }
    
    public void addScore() {
        score++;
        update();
    }
    
    public void addScore5() {
        score += 5;
        update();
    }
    
    public int getScore() {
        return score;
    }
    
    public void removeScore() {
        score -= 2;
        update();
    }
    
    public void act() {
        if(getWorld() instanceof Level1) {
            Level1 myWorld = (Level1) getWorld();
            Turtle turtl = myWorld.getTurtle();
            setLocation(turtl.getX(), turtl.getY() + 220);
        }
        else if(getWorld() instanceof Level2) {
            Level2 myWorld = (Level2) getWorld();
            Turtle turtl = myWorld.getTurtle();
            setLocation(turtl.getX(), turtl.getY() + 220);
        }
        else if(getWorld() instanceof Level3) {
            Level3 myWorld = (Level3) getWorld();
            Turtle turtl = myWorld.getTurtle();
            setLocation(turtl.getX(), turtl.getY() + 220);
        }
    }
}
