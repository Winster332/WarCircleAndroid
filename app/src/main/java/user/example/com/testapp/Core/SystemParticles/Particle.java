package user.example.com.testapp.Core.SystemParticles;

import android.graphics.Color;
import user.example.com.testapp.Core.Game;
import user.example.com.testapp.Core.Views.BaseView;

/**
 * Created by User on 12/24/2016.
 */
public abstract class Particle extends BaseView {
    private float radius;
    private float velocityRadius;
    private int color;
    private int alpha;
    private int velocityAlpha;
    private float velocityX;
    private float velocityY;
    private boolean isDead;

    public Particle(Game game) {
        super(game);
        setX(0);
        setY(0);
        setColor(Color.BLACK);
        setAlpha(255);
        setDead(false);
        setVelocityX(0);
        setVelocityY(0);
    }

    public void step(float dt) {
        setX(getX() + getVelocityX() * dt);
        setY(getY() + getVelocityY() * dt);

        if (radius > velocityRadius)
            radius -= velocityRadius;
        else setDead(true);

        if (alpha > velocityAlpha)
            alpha -= velocityAlpha;
        else setDead(true);
    }
    public abstract void render();

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public int getColor() {
        return color;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }

    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getVelocityAlpha() {
        return velocityAlpha;
    }

    public void setVelocityAlpha(int velocityAlpha) {
        this.velocityAlpha = velocityAlpha;
    }

    public float getVelocityRadius() {
        return velocityRadius;
    }

    public void setVelocityRadius(float velocityRadius) {
        this.velocityRadius = velocityRadius;
    }
}
