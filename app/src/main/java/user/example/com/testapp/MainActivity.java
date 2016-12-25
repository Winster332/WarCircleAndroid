package user.example.com.testapp;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import user.example.com.testapp.Core.FileManager;
import user.example.com.testapp.Core.Game;
import user.example.com.testapp.Core.Screens.Intent;
import user.example.com.testapp.Core.Screens.Screen;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDirectory();

        Game game = new Game(this);
      //  game.getFileManager().setRecord(5);
        game.setScreen(new MainScreen(this, game));
        game.hideActionBar();
        setContentView(game.getScreen());
    }

    private void initDirectory() {
        if (!FileManager.exist(FileManager.FILE_PATH)) {
            FileManager.createFile(FileManager.FILE_PATH);
            FileManager.write(FileManager.FILE_PATH, "0");
        }
    }
}
