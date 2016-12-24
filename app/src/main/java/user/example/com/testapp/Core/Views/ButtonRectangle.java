package user.example.com.testapp.Core.Views;

import android.view.MotionEvent;
import user.example.com.testapp.Core.Game;

/**
 * Created by User on 12/24/2016.
 */
public class ButtonRectangle extends Button {
    public float width;
    public float height;
    public ButtonRectangle(Game game) {
        super(game);

        setWidth(100);
        setHeight(27);
        getText().setValue("Button rect");
    }

    @Override
    public void step(float dt) {
        getText().step(dt);

        if (game.input.IsTouch()) {
            if (game.input.getAction() == MotionEvent.ACTION_UP) {
                if (isIntersect()) {
                    useAllClick();
                }
            }
        }
    }

    private boolean isIntersect() {
        if (game.input.getX() > getX() - getWidth()/2 && game.input.getX() < getX() + getWidth()/2 &&
                game.input.getY() >= getY() - getHeight() / 2 && game.input.getY() <= getY() + getHeight() / 2)
            return true;
        return false;
    }

    @Override
    public void render() {
        game.graphics.fillRect(getX(), getY(), getWidth(), getHeight(), getColor());
        getText().setX(getX());
        getText().setY(getY());
        getText().render();
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setWidth(float width) {
        this.width = width;
    }
}
