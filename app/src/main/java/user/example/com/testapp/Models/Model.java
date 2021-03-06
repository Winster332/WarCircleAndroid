package user.example.com.testapp.Models;

import android.graphics.Color;
import user.example.com.testapp.Core.Game;
import user.example.com.testapp.Core.Views.BaseView;

/**
 * Created by User on 12/25/2016.
 */
public abstract class Model extends BaseView {
    private float radius;
    private float velocityX;
    private float velocityY;
    private String userData;
    public int color;

    public Model(Game game) {
        super(game);
        setRadius(50);
        setColor(Color.CYAN);
    }

    public String getUserData() {
        return userData;
    }

    public void setUserData(String userData) {
        this.userData = userData;
    }

    public boolean intersect(Model model) {
        float distance = (float) Math.sqrt(Math.pow(getX() - model.getX(), 2) +
                Math.pow(getY() - model.getY(), 2));
        if (distance <= getRadius()*2 + model.getRadius()*2) {
            return true;
        }
        return false;
    }

    @Override
    public void step(float dt) {
        setX(getX() + getVelocityX() * dt);
        setY(getY() + getVelocityY() * dt);
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }
}
