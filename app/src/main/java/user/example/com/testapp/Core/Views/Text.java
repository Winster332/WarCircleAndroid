package user.example.com.testapp.Core.Views;

import android.graphics.Color;
import user.example.com.testapp.Core.Game;
import user.example.com.testapp.Core.Views.BaseView;

/**
 * Created by User on 12/24/2016.
 */
public class Text extends BaseView {
    private String value;
    private int color;
    private float size;
    public Text(Game game) {
        super(game);

        setValue("Text");
        setColor(Color.BLACK);
        setSize(20);
    }

    @Override
    public void step(float dt) {}

    @Override
    public void render() {
        game.graphics.drawText(getValue(), getX(), getY(), getSize(), getColor());
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
