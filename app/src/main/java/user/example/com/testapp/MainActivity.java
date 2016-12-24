package user.example.com.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import user.example.com.testapp.Core.Game;
import user.example.com.testapp.Core.Screens.Screen;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Game game = new Game();
        Screen screen = new MainScreen(this, game);
        screen.setOnTouchListener(game.input);
        setContentView(screen);
    }
}
