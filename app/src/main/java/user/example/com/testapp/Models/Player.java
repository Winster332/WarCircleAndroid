package user.example.com.testapp.Models;

import android.graphics.Color;
import user.example.com.testapp.Core.Game;
import user.example.com.testapp.World;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/25/2016.
 */
public class Player extends Model {
    private List<Circle> bullets;
    private Circle circleSmall;
    private Circle circleBig;
    private float timeLoad = 50;
    private float currentTimeLoad;
    private World world;

    public Player(Game game, World world) {
        super(game);
        this.world = world;

        bullets = new ArrayList<Circle>();

        setCurrentTimeLoad(0);
        setTimeLoad(2);
        setColor(Color.argb(255, 150, 150, 150));

        setX(game.getWidth() / 2);
        setY(game.getHeight());
        circleSmall = new Circle(game);
        circleBig = new Circle(game);

        circleSmall.setX(getX());
        circleSmall.setY(getY()-getRadius()*2-circleSmall.getRadius());
        circleSmall.setColor(Color.argb(255, 150, 150, 150));
    }

    public List<Circle> getBullets() {
        return bullets;
    }

    public float getTimeLoad() {
        return timeLoad;
    }

    public void setTimeLoad(float timeLoad) {
        this.timeLoad = timeLoad;
    }

    public void setCurrentTimeLoad(float currentTimeLoad) {
        this.currentTimeLoad = currentTimeLoad;
    }

    public float getCurrentTimeLoad() {
        return currentTimeLoad;
    }

    @Override
    public void step(float dt) {
        updateCircle(dt);

        if (getCurrentTimeLoad() > 0) {
            setCurrentTimeLoad(getCurrentTimeLoad()-1.0f*dt);
            circleSmall.setColor(Color.argb(255, 180, 120, 120));
        } else circleSmall.setColor(Color.argb(255, 80, 180, 120));

        if (game.input.IsTouch()) {
            float angle = (float) Math.atan2(getY() - game.input.getY(), getX() - game.input.getX());
            circleSmall.setX(getX() + circleSmall.getRadius() + (float) Math.cos(angle) * -(getRadius() * 2 + circleSmall.getRadius()));
            circleSmall.setY(getY() - (getRadius() + circleSmall.getRadius()) + (float) Math.sin(angle) * -getRadius() * 2 + (circleSmall.getRadius()));

            attack((float) Math.cos(angle), (float) Math.sin(angle));
        }
    }

    public void attack(float vx, float vy) {
        if (getCurrentTimeLoad() <= 0) {
            world.addBullet(circleSmall.getX(), circleSmall.getY(), -vx*250, -vy*250);
            setCurrentTimeLoad(getTimeLoad());
        }
    }

    private void updateCircle(float dt) {
        circleSmall.step(dt);
        circleBig.step(dt);

        circleBig.setColor(getColor());

        circleSmall.setRadius(getRadius()/2);
        circleBig.setRadius(getRadius());

        circleBig.setX(getX()+getRadius());
        circleBig.setY(getY());

        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).step(dt);
            bullets.get(i).render();

            if (bullets.get(i).getX() < -100 || bullets.get(i).getX() > game.getWidth() + 100 ||
                bullets.get(i).getY() < -100 || bullets.get(i).getY() > game.getHeight() + 100) {
                bullets.remove(i);
            }
        }
    }

    @Override
    public void render() {
        circleSmall.render();
        circleBig.render();
    }
}
