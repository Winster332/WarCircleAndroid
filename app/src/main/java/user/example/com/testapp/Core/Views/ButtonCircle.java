package user.example.com.testapp.Core.Views;

import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import user.example.com.testapp.Core.Game;

/**
 * Created by User on 12/24/2016.
 */
public class ButtonCircle extends Button {
    private float radius;
    private float radiusDown;

    public ButtonCircle(Game game) {
        super(game);
        setRadius(50);
        getText().setValue("Button circle");
        setRadiusDown(0);
    }

    @Override
    public void step(float dt) {
        getText().step(dt);

        if (game.input.IsTouch()) {
            float distance = (float) Math.sqrt(Math.pow(getX() - radius - game.input.getX(), 2) +
                    Math.pow(getY() - radius - game.input.getY(), 2));

            if (distance <= getRadius() * 2) {
                if (game.input.getAction() == MotionEvent.ACTION_DOWN) {
                    setRadiusDown(getRadius()/3);
                }

                useAllClick(game.input.getAction());
            }
        }
    }

    public float getRadiusDown() {
        return radiusDown;
    }

    public void setRadiusDown(float radiusDown) {
        this.radiusDown = radiusDown;
    }

    @Override
    public void render() {
        game.graphics.fillCircle(getX()+getRadiusDown(), getY()+getRadiusDown(), getRadius()+getRadiusDown(), getColor());
        getText().setX(getX()-getRadius());
        getText().setY(getY()-getRadius());
        getText().render();
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public static ButtonCircle create(Game game, String text, float x, float y, float radius, int backColor, int frontColor, float sizeText) {
        ButtonCircle element = new ButtonCircle(game);
        element.setX(x);
        element.setY(y);
        element.getText().setValue(text);
        element.setRadius(radius);
        element.setColor(backColor);
        element.getText().setColor(frontColor);
        element.getText().setSize(sizeText);
        element.getText().setX(x);
        element.getText().setY(y);

        return element;
    }
}
