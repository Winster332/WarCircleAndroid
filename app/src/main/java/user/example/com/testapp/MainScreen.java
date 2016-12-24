package user.example.com.testapp;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import user.example.com.testapp.Core.Game;
import user.example.com.testapp.Core.Screens.Screen;
import user.example.com.testapp.Core.SystemParticles.SystemLines;
import user.example.com.testapp.Core.Views.BaseView;
import user.example.com.testapp.Core.Views.Button;
import user.example.com.testapp.Core.Views.ButtonCircle;
import user.example.com.testapp.Core.Views.EventClick;

/**
 * Created by User on 12/24/2016.
 */
public class MainScreen extends Screen {
    private SystemLines systemLines;


    public MainScreen(Context context, Game game) {
        super(context, game);
        setIntent(new IntentShowHide(game));
    }

    @Override
    public void loaded() {
        getIntent().create(this, null, 255, 10).start(false);

        systemLines = new SystemLines(game);
        systemLines.setMax(50);

        initializeComponents();
    }

    private void initializeComponents() {
        addComponent(ButtonCircle.create(game, "ИГРАТЬ", game.getWidth()/2+80, game.getHeight()/2+60, 80, Color.argb(255, 100, 100, 100), Color.WHITE, 70)
                .addListenerClick(new EventClick() {
                    @Override
                    public void Click(BaseView view, int action) {
                        if (action == MotionEvent.ACTION_UP)
                            getIntent().create(null, new GameScreen(context, game), 0, 15).start(true);
                    }
        }));
    }

    @Override
    public void render(float delta) {
        game.graphics.fillRect(game.getWidth()/2, game.getHeight()/2, game.getWidth(), game.getHeight(), Color.argb(255, 50, 50, 50));
        game.graphics.drawText(String.valueOf(systemLines.getParticles().size()), game.getWidth()/2, 150, 60, Color.WHITE);

        if (game.input.IsTouch()) {
            systemLines.add(game.input.getX(), game.input.getY(), Color.argb(255, 0, 0, 0));
        }

        systemLines.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
