package user.example.com.testapp;

import android.graphics.Color;
import android.util.Log;
import user.example.com.testapp.Core.Game;
import user.example.com.testapp.Models.Circle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by User on 12/25/2016.
 */
public class World {
    public List<Circle> circleList;
    private int balls;
    private Game game;
    private float currentHZ;
    private final float hzConst;
    private Random random;

    public World(Game game) {
        hzConst = 2;
        currentHZ = 0;
        this.game = game;
        circleList = new ArrayList<Circle>();
        balls = 0;
        random = new Random();
    }

    public void addCircle() {
        float radius = 20+random.nextFloat() * 30;
        float x = 100+radius+random.nextFloat()*(game.getWidth()-radius-100);
        float y = -50;

        Circle circle = new Circle(game);
        circle.setX(x);
        circle.setY(y);
        circle.setRadius(radius);
        circle.setVelocityX(random.nextFloat()*250*-1);
        circle.setVelocityY(random.nextFloat()*250);
        circle.setColor(Color.argb(255, 180, 200, 220));
        circle.setUserData("foe");

        circleList.add(circle);
    }

    public int getBalls() {
        return balls;
    }

    public void render(float delta) {
        if (currentHZ > 0) {
            currentHZ-=1*delta;
        } else {
            currentHZ = hzConst;
            addCircle();
        }

        for (int i = 0; i < circleList.size(); i++) {
            circleList.get(i).step(delta);
            circleList.get(i).render();

            if (circleList.get(i).getUserData().equals("foe")) {
                ((GameScreen)game.getScreen()).getSystemFire().add(circleList.get(i).getX(),
                        circleList.get(i).getY(),
                        Color.argb(255, 150, 150, 150), circleList.get(i).getRadius());

                if (circleList.get(i).getX() - circleList.get(i).getRadius() < circleList.get(i).getRadius() * 2)
                    circleList.get(i).setVelocityX(circleList.get(i).getVelocityX() * -1);
                if (circleList.get(i).getX() > game.getWidth() - circleList.get(i).getRadius()) {
                    circleList.get(i).setVelocityX(circleList.get(i).getVelocityX() * -1);
                }
            }

            if (circleList.get(i).getUserData().equals("bullet")) {
                ((GameScreen)game.getScreen()).getSystemFire().add(circleList.get(i).getX(),
                        circleList.get(i).getY(),
                        Color.argb(255, 150, 150, 200), circleList.get(i).getRadius());
            }

            if (circleList.get(i).getY() > game.getHeight()) {
                endGame();
            }
            if (circleList.get(i).getX() < -100 || circleList.get(i).getX() > game.getWidth() + 100 ||
                    circleList.get(i).getY() < -100 || circleList.get(i).getY() > game.getHeight() + 100) {
                circleList.remove(i);
                continue;
            }
            checkIntersect(circleList.get(i));
        }
    }

    private void endGame() {
        game.getScreen().getIntent().create(null, new MainScreen(game.getScreen().getContext(), game),
                0, 20).start(true);

    }

    public boolean checkIntersect(Circle circle) {
        boolean result = false;
        for (int i = 0; i < circleList.size(); i++) {
            if (!circleList.get(i).equals(circle)) {
                if (!circle.getUserData().equals(circleList.get(i).getUserData()))
                    if (circleList.get(i).intersect(circle)) {
                        circleList.remove(circleList.get(i));
                        circleList.remove(circle);
                        balls++;
                        result = true;
                        break;
                    }
            }
        }
        return result;
    }

    public void addBullet(float x, float y, float vx, float vy, float radius) {
        Circle circle = new Circle(game);
        circle.setX(x);
        circle.setY(y);
        circle.setRadius(radius);
        circle.setVelocityX(vx);
        circle.setVelocityY(vy);
        circle.setUserData("bullet");

        circleList.add(circle);
    }
}
