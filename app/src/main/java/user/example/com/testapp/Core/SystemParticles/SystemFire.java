package user.example.com.testapp.Core.SystemParticles;

import user.example.com.testapp.Core.Game;

import java.util.Random;

/**
 * Created by User on 12/25/2016.
 */
public class SystemFire extends Particles {
    private Random random;
    public SystemFire(Game game) {
        super(game);

        random = new Random();
    }
    public void add(float x, float y, int color, float radius) {
        CircleParticle p = new CircleParticle(game);
        p.setDead(false);
        p.setAlpha(255);
        p.setVelocityX(generateRandomV2(random.nextFloat() * 50 * -1, random.nextFloat() * 3));
        p.setVelocityY(generateRandomV2(random.nextFloat() * 50 * -1, random.nextFloat() * 3));
        p.setColor(color);
        p.setX(x);
        p.setY(y);
        p.setRadius(radius);
        p.setVelocityAlpha(3);
        p.setVelocityRadius(0.5f);

        add(p, 1);
    }
}
