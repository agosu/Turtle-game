package players;

import enemies.TrackingEnemy;
import greenfoot.*;
import levels.Level1;
import levels.Level2;
import levels.Level3;

public class Turtle extends ScrollingActor {
    int speed = 4;

    class Direction {
        public static final int UP = 270;
        public static final int DOWN = 90;
        public static final int LEFT = 180;
        public static final int RIGHT = 0;
    }
    
    public Turtle() {
        
    }
    
    public int stunTimer = 0;
    
    public void act() {
        
        if (Greenfoot.isKeyDown("up") && stunTimer == 0) {
            setRotation(Direction.UP);
            move();
        }

        if (Greenfoot.isKeyDown("down") && stunTimer == 0) {
            setRotation(Direction.DOWN);
            move();
        }

        if (Greenfoot.isKeyDown("left") && stunTimer == 0) {
            setRotation(Direction.LEFT);
            move();
        }

        if (Greenfoot.isKeyDown("right") && stunTimer == 0) {
            setRotation(Direction.RIGHT);
            move();
        }

        if (stunTimer > 0) {
            stunTimer--;
            GreenfootImage i = getImage();
            int t = i.getTransparency();
            i.setTransparency(0);
            Greenfoot.delay(3);
            i.setTransparency(t);
            Greenfoot.delay(3);
        }
        eat();
        die();
        nextLevel();
    }
    
    public void move() {
        int currentX = getX();
        int currentY = getY();
        int direction = getRotation();
        int changeX = getChangeX(direction);
        int changeY = getChangeY(direction);
        int adjustedChangeX = adjustOffset(changeX);
        int adjustedChangeY = adjustOffset(changeY);
        Actor obstacle = getOneObjectAtOffset(adjustedChangeX, adjustedChangeY, Rock.class);
        
        if (obstacle == null){
            setLocation(currentX + changeX, currentY + changeY);
        }
    }
    
    private int getChangeX(int direction) {
        if (direction == Direction.RIGHT) {
              return speed;
        }

        if (direction == Direction.LEFT) {
            return -speed;
        }
        return 0;
    }
    
     private int getChangeY(int direction) {
        if (direction == Direction.DOWN) {
              return speed;
        }

        if (direction == Direction.UP) {
            return -speed;
        }
        return 0;
    }
    
    private int adjustOffset(int offset) {
        int signOfOffset = (int)Math.signum(offset);
        int adjustAmount = 25 * signOfOffset;
        return offset + adjustAmount;
    }
    
    public void eat() {
        Actor food = getOneObjectAtOffset(0, 0, Food.class);
        Actor food_big = getOneObjectAtOffset(0, 0, BigFood.class);
        if (food != null) {
            World world = getWorld();
            world.removeObject(food);
            if (getWorld() instanceof Level1) {
                Level1 myWorld = (Level1) getWorld();
                Counter count = myWorld.getCounter();
                count.addScore();
            } else if (getWorld() instanceof Level2) {
                Level2 myWorld = (Level2) getWorld();
                Counter count = myWorld.getCounter();
                count.addScore();
            } else if (getWorld() instanceof Level3) {
                Level3 myWorld = (Level3) getWorld();
                Counter count = myWorld.getCounter();
                count.addScore();
            }
        } else if (food_big != null) {
            World world = getWorld();
            world.removeObject(food_big);
            if (getWorld() instanceof Level1) {
                Level1 myWorld = (Level1) getWorld();
                Counter count = myWorld.getCounter();
                count.addScore5();
            } else if(getWorld() instanceof Level2) {
                Level2 myWorld = (Level2) getWorld();
                Counter count = myWorld.getCounter();
                count.addScore5();
            } else if(getWorld() instanceof Level3) {
                Level3 myWorld = (Level3) getWorld();
                Counter count = myWorld.getCounter();
                count.addScore5();
            }
        }
    }
    
    public void nextLevel() {
        if (getWorld() instanceof Level1) {
            Level1 myWorld = (Level1) getWorld();
            Counter count = myWorld.getCounter();
            int score = count.getScore();
            if (score >= 25) {
                World newWorld = new Level2();
                Greenfoot.setWorld(newWorld);
            }
        } else if (getWorld() instanceof Level2) {
            Level2 myWorld = (Level2) getWorld();
            Counter count = myWorld.getCounter();
            int score = count.getScore();
            if (score >= 25) {
                World newWorld = new Level3();
                Greenfoot.setWorld(newWorld);
            }
        } else if (getWorld() instanceof Level3) {
            Level3 myWorld = (Level3) getWorld();
            Counter count = myWorld.getCounter();
            int score = count.getScore();
            if (score >= 25) {
                Greenfoot.setWorld(new Win());
            }
        }
    }
    
    public void die() {
        if (getWorld() instanceof Level1) {
            Level1 myWorld = (Level1) getWorld();
            Counter count = myWorld.getCounter();
            int score = count.getScore();
            Actor siena = getOneObjectAtOffset(0, 0, Siena.class);
            if (score < 0 || siena != null) {
                Greenfoot.setWorld(new Die());
            }
        } else if (getWorld() instanceof Level2) {
            Level2 myWorld = (Level2) getWorld();
            Counter count = myWorld.getCounter();
            int score = count.getScore();
            if (score < 0) {
                Greenfoot.setWorld(new Die());
            }
        } else if (getWorld() instanceof Level3) {
            Level3 myWorld = (Level3) getWorld();
            Counter count = myWorld.getCounter();
            int score = count.getScore();
            Actor killed = getOneObjectAtOffset(0, 0, TrackingEnemy.class);
            if (score < 0 || killed != null) {
                Greenfoot.setWorld(new Die());
            }
        }
    }
}
