package user.example.com.testapp;

import android.graphics.Color;
import user.example.com.testapp.Core.Game;
import user.example.com.testapp.Core.Screens.Intent;

/**
 * Created by User on 12/24/2016.
 */
public class IntentShowHide extends Intent {
    private int color;
    public IntentShowHide(Game game) {
        super(game);
        setColor(Color.BLACK);
    }

    @Override
    public void step() {
        if (isStep()) {
            if (getCurrentValue() > getVelocity()) {
                setCurrentValue(getCurrentValue() - getVelocity());
            } else {
                setStep(false);
                if (isIntent()) {
                    game.setScreen(getScreenTo());
                    game.input.setLock(false);
                }
            }
        }
    }

    @Override
    public void render() {
        game.graphics.fillRect(game.getWidth()/2, game.getHeight()/2, game.getWidth(), game.getHeight(),
                Color.argb((int)getCurrentValue(), Color.red(getColor()), Color.red(getColor()), Color.red(getColor())));
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
