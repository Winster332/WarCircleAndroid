package user.example.com.testapp.Core;

import user.example.com.testapp.Core.Drawing.CanvasGraphics;
import user.example.com.testapp.Core.Drawing.Graphics;
import user.example.com.testapp.Core.UserInput.Input;

/**
 * Created by User on 12/24/2016.
 */
public class Game {
    public Graphics graphics;
    public Input input;
    public Game() {
        graphics = new CanvasGraphics();
        input = new Input(this);
    }
}
