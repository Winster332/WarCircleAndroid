package user.example.com.testapp;

import android.content.Context;
import android.graphics.Color;
import user.example.com.testapp.Core.Game;
import user.example.com.testapp.Core.Screens.Screen;
import user.example.com.testapp.Core.SystemParticles.SystemLines;

/**
 * Created by User on 12/24/2016.
 */
public class MainScreen extends Screen {
    private SystemLines systemLines;

    public MainScreen(Context context, Game game) {
        super(context, game);
        setIntent(new IntentShowHide(game));

        systemLines = new SystemLines(game);
        systemLines.setMax(50);
    }

    @Override
    public void render(float delta) {
        game.graphics.drawText("particles: " + systemLines.getParticles().size(), 100, 40, 32, Color.BLUE);

        if (game.input.IsTouch()) {
            systemLines.add(game.input.getX(), game.input.getY(), Color.argb(255, 0, 0, 0));
        }

        game.input.update();
        systemLines.render(delta);
    }
}
