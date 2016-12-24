package user.example.com.testapp.Core.SystemParticles;

import android.graphics.Color;
import user.example.com.testapp.Core.Game;

/**
 * Created by User on 12/24/2016.
 */
public class CircleParticle extends Particle {
    public CircleParticle(Game game) {
        super(game);
    }

    @Override
    public void render() {
        game.graphics.fillCircle(getX(), getY(), getRadius(),
                Color.argb(getAlpha(), Color.red(getColor()), Color.green(getColor()), Color.blue(getColor())));
    }
}
