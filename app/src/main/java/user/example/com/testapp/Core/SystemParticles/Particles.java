package user.example.com.testapp.Core.SystemParticles;

import user.example.com.testapp.Core.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/24/2016.
 */
public class Particles {
    private List<Particle> particles;
    protected Game game;

    public Particles(Game game) {
        this.game = game;
        particles = new ArrayList<Particle>();
    }

    public void add(Particle particle, int count) {
        for (int i = 0; i < count; i++) {
            particles.add(particle);
        }
    }

    public void render(float delta) {
        for (int i = 0; i < particles.size(); i++) {
            particles.get(i).step(delta);
            particles.get(i).render();

            if (particles.get(i).isDead()) {
                particles.remove(i);
            }
        }
    }

    public List<Particle> getParticles() {
        return particles;
    }

    public void setParticles(List<Particle> particles) {
        this.particles = particles;
    }
}
