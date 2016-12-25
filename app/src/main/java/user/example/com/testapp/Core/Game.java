package user.example.com.testapp.Core;

import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import user.example.com.testapp.Core.Drawing.CanvasGraphics;
import user.example.com.testapp.Core.Drawing.Graphics;
import user.example.com.testapp.Core.Screens.Screen;
import user.example.com.testapp.Core.UserInput.Input;

/**
 * Created by User on 12/24/2016.
 */
public class Game {
    public Graphics graphics;
    public Input input;
    private AppCompatActivity activity;
    private float width;
    private float height;
    private Screen screen;

    public Game(AppCompatActivity appCompatActivity) {
        this.activity = appCompatActivity;

        initializeSizeScreen();

        graphics = new CanvasGraphics();
        input = new Input(this);
    }

    private void initializeSizeScreen() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;
    }

    public void hideActionBar() {
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void setScreen(Screen newScreen) {
        if (this.screen != null)
            this.screen.dispose();

        newScreen.setOnTouchListener(input);
        this.screen = newScreen;
        getActivity().setContentView(getScreen());
        getScreen().loaded();
    }

    public Screen getScreen() {
        return screen;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public AppCompatActivity getActivity() {
        return activity;
    }
}
