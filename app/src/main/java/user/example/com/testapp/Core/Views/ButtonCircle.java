package user.example.com.testapp.Core.Views;

import android.graphics.Color;
import android.view.MotionEvent;
import user.example.com.testapp.Core.Game;

/**
 * Created by User on 12/24/2016.
 */
public class ButtonCircle extends Button {
    private float radius;

    public ButtonCircle(Game game) {
        super(game);
        setRadius(50);
        getText().setValue("Button circle");
    }

    @Override
    public void step(float dt) {
        getText().step(dt);

        if (game.input.IsTouch()) {
            if (game.input.getAction() == MotionEvent.ACTION_UP) {
                float distance = (float) Math.sqrt(Math.pow(getX() - game.input.getX(), 2) +
                        Math.pow(getY() - game.input.getY(), 2));

                if (distance <= getRadius()) {
                    useAllClick();
                }
            }
        }
    }

    @Override
    public void render() {
        game.graphics.fillCircle(getX(), getY(), getRadius(), getColor());
        getText().setX(getX());
        getText().setY(getY());
        getText().render();
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
