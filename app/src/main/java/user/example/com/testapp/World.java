package user.example.com.testapp;

import user.example.com.testapp.Core.Game;
import user.example.com.testapp.Models.Circle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/25/2016.
 */
public class World {
    public List<Circle> circleList;
    private int balls;
    private Game game;

    public World(Game game) {
        this.game = game;
        circleList = new ArrayList<Circle>();
        balls = 0;
    }

    public void addCircle(float x, float y) {

    }

    public int getBalls() {
        return balls;
    }

    public void render(float delta) {

    }

    public void addBullet(float x, float y, float vx, float vy, float radius) {
        Circle circle = new Circle(game);
        circle.setX(x);
        circle.setY(y);
        circle.setRadius(radius);
        circle.setVelocityX(-vx * 250);
        circle.setVelocityY(-vy * 250);
        circle.setUserData("bullet");

        circleList.add(circle);
    }
}
