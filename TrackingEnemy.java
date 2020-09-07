import greenfoot.*;

public class TrackingEnemy extends Player {

    public void act() {
        Player player = (Player)getWorld().getObjects(Turtle.class).get(0);
        move(1);
        turnTowards(player.getX(), player.getY());
    }    
}
