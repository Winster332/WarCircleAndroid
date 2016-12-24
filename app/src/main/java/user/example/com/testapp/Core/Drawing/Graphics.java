package user.example.com.testapp.Core.Drawing;

import android.graphics.Canvas;
import android.graphics.Color;

/**
 * Created by User on 12/24/2016.
 */
public interface Graphics {
    void set(Canvas canvas);
    Canvas get();
    void drawRect(float x, float y, float width, float height, int color, float lineSize);
    void fillRect(float x, float y, float width, float height, int color);
    void drawCircle(float x, float y, float radius, int color, float lineSize);
    void fillCircle(float x, float y, float radius, int color);
    void drawLine(float x1, float y1, float x2, float y2, int color, float lineSize);
    void drawText(String text, float x, float y, float size, int color);
}
