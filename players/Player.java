package players;

import greenfoot.*;
import java.awt.Point;
import java.util.List;

public abstract class Player extends Actor {
    protected double exactX;
    protected double exactY;
    protected double velX;
    protected double velY;
    
    public void setLocation(int x, int y) {
        if (ScrollingWorld.WORLD_WIDTH != 0) {
            if (getDistanceToScrollingActor('x') - getWorld().getTotalXMovement() > ScrollingWorld.WORLD_WIDTH/2) {
                x = (int) (getStartingPoint().getX() + ScrollingWorld.WORLD_WIDTH/2);
            }
            else if (getDistanceToScrollingActor('x') - getWorld().getTotalXMovement() < -ScrollingWorld.WORLD_WIDTH/2) {
                x = (int) (getStartingPoint().getX() - ScrollingWorld.WORLD_WIDTH/2);
            }
        }
        if (ScrollingWorld.WORLD_HEIGHT != 0) {
            if(getDistanceToScrollingActor('y') - getWorld().getTotalYMovement() > ScrollingWorld.WORLD_HEIGHT/2) {
                y = (int) (getStartingPoint().getY() + ScrollingWorld.WORLD_HEIGHT/2);
            }
            else if(getDistanceToScrollingActor('y') - getWorld().getTotalYMovement() < -ScrollingWorld.WORLD_HEIGHT/2) {
                y = (int) (getStartingPoint().getY() - ScrollingWorld.WORLD_HEIGHT/2);
            }
        }
        exactX = x;
        exactY = y;
        super.setLocation(x, y);
    }

    public void setLocation(double x, double y) {
        if (ScrollingWorld.WORLD_WIDTH != 0) {
            if (getDistanceToScrollingActor('x') - getWorld().getTotalXMovement() > ScrollingWorld.WORLD_WIDTH/2) {
                x = getStartingPoint().getX() + ScrollingWorld.WORLD_WIDTH/2;
            }
            else if (getDistanceToScrollingActor('x') - getWorld().getTotalXMovement() < -ScrollingWorld.WORLD_WIDTH/2) {
                x = getStartingPoint().getX() - ScrollingWorld.WORLD_WIDTH/2;
            }
        }
        if (ScrollingWorld.WORLD_HEIGHT != 0) {
            if(getDistanceToScrollingActor('y') - getWorld().getTotalYMovement() > ScrollingWorld.WORLD_HEIGHT/2) {
                y = getStartingPoint().getY() + ScrollingWorld.WORLD_HEIGHT/2;
            }
            else if(getDistanceToScrollingActor('y') - getWorld().getTotalYMovement() < -ScrollingWorld.WORLD_HEIGHT/2) {
                y = getStartingPoint().getY() - ScrollingWorld.WORLD_HEIGHT/2;
            }
        }
        exactX = x;
        exactY = y;
        super.setLocation((int) x, (int) y);
    }
    
    public double getDistanceToScrollingActor() {
        List<ScrollingActor> actors = getWorld().getObjects(ScrollingActor.class);
        if (actors != null && !actors.isEmpty()) {
            ScrollingActor actor = null;
            for (ScrollingActor scrollingActor : actors) {
                if (scrollingActor.isScrollingCenter()) {
                    actor = scrollingActor;
                }
            }
            if (actor == null) {
                System.err.println("No scrollingActor in the world.");
                return 0;
            }
            return Math.hypot(getExactX() - actor.getExactX(), getExactY() - actor.getExactY());
        }
        return 0;
    }
    
    public double getDistanceToScrollingActor(char component) throws IllegalArgumentException {
        if (component == 'x') {
            List<ScrollingActor> actors = getWorld().getObjects(ScrollingActor.class);
            if (actors != null && !actors.isEmpty()) {
                ScrollingActor actor = null;
                for (ScrollingActor scrollingActor : actors) {
                    if (scrollingActor.isScrollingCenter()) {
                        actor = scrollingActor;
                    }
                }
                if (actor == null) {
                    System.err.println("No scrollingActor in the world.");
                    return 0;
                }
                return getExactX() - actor.getExactX();
            }
        }
        else if (component == 'y') {
            List<ScrollingActor> actors = getWorld().getObjects(ScrollingActor.class);
            if (actors != null && !actors.isEmpty()) {
                ScrollingActor actor = null;
                for (ScrollingActor scrollingActor : actors) {
                    if (scrollingActor.isScrollingCenter()) {
                        actor = scrollingActor;
                    }
                }
                if (actor == null) {
                    System.err.println("No scrollingActor in the world.");
                    return 0;
                }
                return getExactY() - actor.getExactY();
            }
        }
        else {
            throw new IllegalArgumentException("component (" + component + ") must be either 'x' or 'y'");
        }
        return 0;
    }
    
    public java.awt.Point getStartingPoint() {
        List<ScrollingActor> actors = getWorld().getObjects(ScrollingActor.class);
        if (actors != null && !actors.isEmpty()) {
            ScrollingActor actor = null;
            for (ScrollingActor scrollingActor : actors) {
                if (scrollingActor.isScrollingCenter()) {
                    actor = scrollingActor;
                }
            }
            if (actor == null) {
                System.err.println("No scrollingActor in the world.");
                return null;
            }
            int x = actor.getX() + getWorld().getTotalXMovement();
            int y = actor.getY() + getWorld().getTotalYMovement();
            return new Point(x, y);
        }
        return null;
    }
    
    public double getExactX(){
        return exactX;
    }

    public double getExactY(){
        return exactY;
    }
    
    public double getScrollingX() {
        return getDistanceToScrollingActor('x') - getWorld().getTotalXMovement();
    }

    public double getScrollingY() {
        return getDistanceToScrollingActor('y') - getWorld().getTotalYMovement();
    }
    
    public ScrollingWorld getWorld() {
        return ((ScrollingWorld) super.getWorld());
    }
}