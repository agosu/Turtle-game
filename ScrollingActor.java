import greenfoot.*;
import java.util.List;

public abstract class ScrollingActor extends Player {
    private boolean scrollingCenter;
    
    public ScrollingActor() {
        scrollingCenter = true;
    }

    public ScrollingActor(boolean scrollingCenter) {
        this.scrollingCenter = scrollingCenter;
    }
    
    public final void setLocation(int x, int y) {
        super.setLocation(x, y);
        if (scrollingCenter) {
            getWorld().resetPlayersPosition(this);
        }
    }
    
    public final void setLocation(double x, double y, boolean resetPosition) {
        super.setLocation(x, y);
        if (scrollingCenter && resetPosition) {
            getWorld().resetPlayersPosition(this);
        }
    }
    
    public final boolean isScrollingCenter() {
        return scrollingCenter;
    }
    
    public final void setScrollingCenter(boolean scrollingCenter) {
        this.scrollingCenter = scrollingCenter;
    }
}