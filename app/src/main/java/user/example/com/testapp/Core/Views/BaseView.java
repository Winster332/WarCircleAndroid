package user.example.com.testapp.Core.Views;

import user.example.com.testapp.Core.Game;

/**
 * Created by User on 12/24/2016.
 */
public abstract class BaseView {
    private float x;
    private float y;
    protected Game game;

    public BaseView(Game game) {
        this.game = game;
    }

    public abstract void step(float dt);
    public abstract void render();

    public void setY(float y) {
        this.y = y;
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
}
