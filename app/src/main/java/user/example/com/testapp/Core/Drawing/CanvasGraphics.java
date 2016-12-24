package user.example.com.testapp.Core.Drawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by User on 12/24/2016.
 */
public class CanvasGraphics implements Graphics {
    private Canvas canvas;
    private Paint paint;
    public CanvasGraphics() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.argb(255, 100, 100, 100));
    }
    @Override
    public void set(Canvas canvas) {
        this.canvas = canvas;
    }

    @Override
    public Canvas get() {
        return canvas;
    }

    @Override
    public void drawRect(float x, float y, float width, float height, int color, float lineSize) {
        paint.setColor(color);
        paint.setStrokeWidth(lineSize);
        paint.setStyle(Paint.Style.STROKE);
        canvas.save();
        canvas.translate(x, y);
        canvas.drawRect(-width/2, -height/2, width/2, height/2, paint);
        canvas.restore();
    }

    @Override
    public void fillRect(float x, float y, float width, float height, int color) {
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        canvas.translate(x, y);
        canvas.drawRect(-width/2, -height/2, width/2, height/2, paint);
        canvas.restore();
    }

    @Override
    public void drawCircle(float x, float y, float radius, int color, float lineSize) {
        paint.setColor(color);
        paint.setStrokeWidth(lineSize);
        paint.setStyle(Paint.Style.STROKE);
        canvas.save();
        canvas.translate(x, y);
        canvas.drawCircle(-radius, -radius, radius*2, paint);
        canvas.restore();
    }

    @Override
    public void fillCircle(float x, float y, float radius, int color) {
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        canvas.translate(x, y);
        canvas.drawCircle(-radius, -radius, radius*2, paint);
        canvas.restore();
    }

    @Override
    public void drawLine(float x1, float y1, float x2, float y2, int color, float lineSize) {
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawLine(x1, y1, x2, y2, paint);
    }

    @Override
    public void drawText(String text, float x, float y, float size, int color) {
        paint.setColor(color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setTextSize(size);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text, x, y, paint);
    }
}
