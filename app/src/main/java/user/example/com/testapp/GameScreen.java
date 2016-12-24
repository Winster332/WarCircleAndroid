package user.example.com.testapp;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import user.example.com.testapp.Core.Game;
import user.example.com.testapp.Core.Screens.Screen;

/**
 * Created by User on 12/24/2016.
 */
public class GameScreen extends Screen {
    public GameScreen(Context context, Game game) {
        super(context, game);
        setIntent(new IntentShowHide(game));
    }

    @Override
    public void loaded() {
        getIntent().create(this, null, 255, 10).start(false);
    }

    @Override
    public void render(float delta) {
        game.graphics.fillRect(game.getWidth()/2, game.getHeight()/2, game.getWidth(), game.getHeight(), Color.argb(255, 50, 50, 50));
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
