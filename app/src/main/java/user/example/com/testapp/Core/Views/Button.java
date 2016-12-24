package user.example.com.testapp.Core.Views;

import android.graphics.Color;
import user.example.com.testapp.Core.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12/24/2016.
 */
public abstract class Button extends BaseView {
    private List<EventClick> clicks;
    private Text text;
    private int color;

    public Button(Game game) {
        super(game);
        setText(new Text(game));
        setColor(Color.CYAN);
        clicks = new ArrayList<EventClick>();
    }

    public Button addListenerClick(EventClick eventClick) {
        clicks.add(eventClick);
        return this;
    }

    public void removeListenerClick(EventClick eventClick) {
        clicks.remove(eventClick);
    }

    public void removeListenerClick(int index) {
        clicks.remove(index);
    }

    protected void useAllClick(int action) {
        for (int i = 0; i < clicks.size(); i++) {
            clicks.get(i).Click(this, action);
        }
    }

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }
}
