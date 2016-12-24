package user.example.com.testapp.Models;

import user.example.com.testapp.Core.Game;

/**
 * Created by User on 12/25/2016.
 */
public class Circle extends Model {
    public Circle(Game game) {
        super(game);
    }

    @Override
    public void render() {
        game.graphics.fillCircle(getX(), getY(), getRadius(), getColor());
    }
}
