package user.example.com.testapp;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import user.example.com.testapp.Core.Game;
import user.example.com.testapp.Core.Screens.Screen;
import user.example.com.testapp.Core.SystemParticles.SystemFire;
import user.example.com.testapp.Core.Views.BaseView;
import user.example.com.testapp.Core.Views.ButtonCircle;
import user.example.com.testapp.Core.Views.EventClick;
import user.example.com.testapp.Models.Circle;
import user.example.com.testapp.Models.Player;

/**
 * Created by User on 12/24/2016.
 */
public class GameScreen extends Screen {
    private World world;
    private SystemFire systemFire;
    public GameScreen(Context context, Game game) {
        super(context, game);
        setIntent(new IntentShowHide(game));
        setSystemFire(new SystemFire(game));
    }

    @Override
    public void loaded() {
        getIntent().create(this, null, 255, 10).start(false);
        world = new World(game);

        initializeComponents();
    }

    private void initializeComponents() {
        addComponent(new Player(game, world));

        addComponent(ButtonCircle.create(game, "НАЗАД", 100, 100, 30, Color.argb(255, 100, 100, 100), Color.WHITE, 25)
                .addListenerClick(new EventClick() {
                    @Override
                    public void Click(BaseView view, int action) {
                        if (action == MotionEvent.ACTION_UP)
                            getIntent().create(null, new MainScreen(context, game), 0, 15).start(true);
                    }
                }));
    }

    @Override
    public void render(float delta) {
        game.graphics.fillRect(game.getWidth() / 2, game.getHeight() / 2, game.getWidth(), game.getHeight(), Color.argb(255, 50, 50, 50));

        getSystemFire().render(delta);
        world.render(delta);

        game.graphics.drawText(String.valueOf(world.getBalls()), game.getWidth() - 100, 70, 40, Color.WHITE);
    }

    public SystemFire getSystemFire() {
        return systemFire;
    }

    public void setSystemFire(SystemFire systemFire) {
        this.systemFire = systemFire;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
