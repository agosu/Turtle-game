import greenfoot.*;

public class Level3 extends ScrollingWorld {
    int food = 70, rock = 100, bigFood = 30, realEnemy = 150;
    public Counter counter = new Counter();
    Turtle turtle = new Turtle();

    public Level3() {
        super(500, 500, 1, 2000, 2000);
        setScrollingBackground(new GreenfootImage("granite-light.jpg"));
        createLevel3();
    }

    public Counter getCounter() {
        return counter;
    }
    
    public Turtle getTurtle() {
        return turtle;
    }
    
    public int getRandomNumber(int start, int end)
    {
       int normal = Greenfoot.getRandomNumber(end - start + 1);
       return normal + start;
    }

    public void createLevel3() {
        int x;
        int y;

        for (int i = 0; i < rock; i++) {
            x = getRandomNumber(-1000, 1000);
            y = getRandomNumber(-1000, 1000);

            if ((x < 230 || x > 270) && (y < 230 || y > 270)) {
                addObject(new Rock(), x, y);
            } else while ((x < 230 || x > 270) && (y < 230 || y > 270)) {
                x = getRandomNumber(-1000, 1000);
                y = getRandomNumber(-1000, 1000);
            }
        }
        
        for (int i = 0; i < food; i++) {
            x = getRandomNumber(-1000, 1000);
            y = getRandomNumber(-1000, 1000);

            if ((x < 230 || x > 270) && (y < 230 || y > 270)) {
                addObject(new Food(), x, y);
            } else while ((x < 230 || x > 270) && (y < 230 || y > 270)) {
                x = getRandomNumber(-1000, 1000);
                y = getRandomNumber(-1000, 1000);
            }
        }
        
        addObject(turtle, 250, 250);
        
        for (int i = 0; i < bigFood; i++) {
            x = getRandomNumber(-1000, 1000);
            y = getRandomNumber(-1000, 1000);

            if ((x < 230 || x > 270) && (y < 230 || y > 270)) {
                addObject(new BigFood(), x, y);
            } else while ((x < 230 || x > 270) && (y < 230 || y > 270)) {
                x = getRandomNumber(-1000, 1000);
                y = getRandomNumber(-1000, 1000);
            }
        }
        
        for (int i = 0; i < realEnemy; i++) {
            x = getRandomNumber(-1000, 1000);
            y = getRandomNumber(-1000, 1000);

            if ((x < 230 || x > 270) && (y < 230 || y > 270)) {
                addObject(new RealEnemy(), x, y);
            } else while ((x < 230 || x > 270) && (y < 230 || y > 270)) {
                x = getRandomNumber(-1000, 1000);
                y = getRandomNumber(-1000, 1000);
            }
        }
        
        addObject(new TrackingEnemy(), 150, 150);
        
        addObject(new Wall(), 0, 1000);
        addObject(new Wall(), 0, -1000);
        Wall wall1 = new Wall();
        wall1.turn(90);
        addObject(wall1, -1000, 0);
        Wall wall2 = new Wall();
        wall2.turn(90);
        addObject(wall2, 1500, 0);

        addObject(counter, 250, 470);
    }
}
