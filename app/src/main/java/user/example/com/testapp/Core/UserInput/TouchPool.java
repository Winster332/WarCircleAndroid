package user.example.com.testapp.Core.UserInput;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/24/2016.
 */
public class TouchPool {
    private List<Touch> touches;
    private int sizePool;
    public TouchPool() {
        touches = new ArrayList<Touch>();
        setSizePool(1);
    }
    public void add(float x, float y, int action) {
        touches.add(new Touch(x, y, action));

        if (touches.size() > getSizePool()) {
            touches.remove(0);
        }
    }

    public List<Touch> getTouches() {
        return touches;
    }

    public void setTouches(List<Touch> touches) {
        this.touches = touches;
    }

    public Touch getLast() {
        return touches.get(touches.size()-1);
    }

    public int getSizePool() {
        return sizePool;
    }

    public void setSizePool(int sizePool) {
        this.sizePool = sizePool;
    }
}
