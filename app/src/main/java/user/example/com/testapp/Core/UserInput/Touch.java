package user.example.com.testapp.Core.UserInput;

import android.view.MotionEvent;

/**
 * Created by User on 12/24/2016.
 */
public class Touch {
    private float x;
    private float y;
    private int action;

    public Touch(float x, float y, int action) {
        setX(x);
        setY(y);
        setAction(action);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }
}
