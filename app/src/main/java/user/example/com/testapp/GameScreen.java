package user.example.com.testapp;

import android.content.Context;
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

    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
