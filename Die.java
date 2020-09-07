import greenfoot.*;

public class Die extends World {
    
    public Die() {    
        super(500, 500, 1);
        showText("You just died. Press Enter to start again.", 250, 250);
    }
    
    public void act() {
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld(new Level1());
        }
    }
}
