package user.example.com.testapp.Core.Screens;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import user.example.com.testapp.Core.Drawing.CanvasGraphics;
import user.example.com.testapp.Core.Drawing.Graphics;
import user.example.com.testapp.Core.Game;
import user.example.com.testapp.Core.Views.BaseView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/24/2016.
 */
public abstract class Screen extends View {
    private List<BaseView> views;
    private Intent intent;
    protected Game game;
    private long prevTime;

    public Screen(Context context, Game game) {
        super(context);
        this.game = game;
        this.views = new ArrayList<BaseView>();
        prevTime = System.nanoTime();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        game.graphics.set(canvas);

        float deltaTime = getDeltaTime();
        render(deltaTime);
        drawView(deltaTime);

        if (intent != null) {
            intent.step();
            intent.render();
        }
        game.input.update();
        this.invalidate();
    }

    private void drawView(float delta) {
        for (int i = 0; i < views.size(); i++) {
            views.get(i).step(delta);
            views.get(i).render();
        }
    }

    public BaseView addComponent(BaseView view) {
        views.add(view);
        return view;
    }

    public void removeComponent(BaseView view) {
        views.remove(view);
    }

    public void removeComponent(int index) {
        views.remove(index);
    }

    public List<BaseView> getViews() {
        return views;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    private float getDeltaTime() {
        float deltaTime = (System.nanoTime() - prevTime)/1000000000.0f;
        prevTime = System.nanoTime();
        return deltaTime;
    }

    public abstract void render(float delta);
}
