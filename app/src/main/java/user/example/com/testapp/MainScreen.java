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
    }

    @Override
    public void loaded() {
        setIntent(new IntentShowHide(game));
        getIntent().create(this, null, 255, 10).start(false);

        systemLines = new SystemLines(game);
        systemLines.setMax(50);

        initializeComponents();
    }

    private void initializeComponents() {
        addComponent(ButtonCircle.create(game, "ИГРАТЬ", 200, 200, 50, Color.BLACK, Color.WHITE, 20)
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
        game.graphics.drawText("particles: " + systemLines.getParticles().size(), 100, 40, 32, Color.BLUE);

        if (game.input.IsTouch()) {
            systemLines.add(game.input.getX(), game.input.getY(), Color.argb(255, 0, 0, 0));
        }
     //   Log.d("screen", "menu");

        systemLines.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
