package user.example.com.testapp.Core.SystemParticles;

import android.graphics.Color;
import android.util.Log;
import user.example.com.testapp.Core.Game;

import java.util.Random;

/**
 * Created by User on 12/24/2016.
 */
public class SystemLines extends Particles {
    private Random random;
    private int max;
    public SystemLines(Game game) {
        super(game);

        random = new Random();
        setMax(100);
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void add(float x, float y, int color) {
        if (getParticles().size() < getMax()) {
            CircleParticle p = new CircleParticle(game);
            p.setDead(false);
            p.setAlpha(255);
            p.setVelocityX(generate(random.nextFloat() * 10 * -1, random.nextFloat() * 3));
            p.setVelocityY(generate(random.nextFloat() * 10 * -1, random.nextFloat() * 3));
            p.setColor(color);
            p.setX(generate(110.8f * random.nextFloat(), random.nextFloat()) + x);
            p.setY(generate(110.8f * random.nextFloat(), random.nextFloat()) + y);
            p.setRadius(3);
            p.setVelocityAlpha(3);
            p.setVelocityRadius(0.05f);

            add(p, 1);
        }
    }

    private float generate(float length, float x) {
        return  (float)Math.cos(x) * length;
    }

    public void render(float delta) {
        for (int i = 0; i < getParticles().size(); i++) {
            getParticles().get(i).step(delta);
            getParticles().get(i).render();

            drawLine(getParticles().get(i));

            if (getParticles().get(i).isDead()) {
                getParticles().remove(i);
            }
        }
    }

    private void drawLine(Particle particle1) {
        for (int i = 0; i < getParticles().size(); i++) {
            Particle particle2 = getParticles().get(i);

            if (!particle1.equals(particle2)) {
                float distance = (float)Math.sqrt(Math.pow(particle1.getX()-particle2.getX(), 2) +
                        Math.pow(particle1.getY()-particle2.getY(), 2));

                if (distance <= 100) {
                    game.graphics.drawLine(particle1.getX(), particle1.getY(), particle2.getX(), particle2.getY(),
                            Color.argb(100-(int)distance, 100, 0, 0), distance/10);
                }
            }
        }
    }
}
