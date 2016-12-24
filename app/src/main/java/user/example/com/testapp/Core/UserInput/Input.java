package user.example.com.testapp.Core.UserInput;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import user.example.com.testapp.Core.Game;

/**
 * Created by User on 12/24/2016.
 */
public class Input implements View.OnTouchListener {
    private Game game;
    private TouchPool touchPool;
    private boolean isLock;

    public Input(Game game) {
        this.game = game;
        touchPool = new TouchPool();
    }

    public boolean isLock() {
        return isLock;
    }

    public void setLock(boolean lock) {
        isLock = lock;
    }

    public boolean IsTouch() {
        if (touchPool.getTouches().size() == 0) {
            return false;
        }
        return true;
    }

    public float getX() {
        return touchPool.getLast().getX();
    }

    public float getY() {
        return touchPool.getLast().getY();
    }

    public int getAction() {
        return touchPool.getLast().getAction();
    }

    public Touch getTouch() {
        return touchPool.getLast();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (!isLock()) {
            touchPool.add(event.getX(), event.getY(), event.getAction());
        }
        return true;
    }

    public void update() {
        touchPool.getTouches().clear();
    }


}
