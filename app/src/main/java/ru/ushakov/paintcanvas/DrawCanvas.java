package ru.ushakov.paintcanvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class DrawCanvas extends View {

    private Paint pain;
    private Path path;
    private float x, y;
    private Map<Path, Paint> store;

    public DrawCanvas(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        path = new Path();
        pain = new Paint();
        pain.setStyle(Paint.Style.STROKE);
        pain.setStrokeWidth(10f);
        pain.setColor(Color.BLACK);
        pain.setStrokeJoin(Paint.Join.ROUND);

        store = new LinkedHashMap<>();

        store.put(path, pain);

    }

    public void setColor(int color){
        path = new Path();
        pain = new Paint();
        pain.setStyle(Paint.Style.STROKE);
        pain.setStrokeWidth(10f);
        pain.setStrokeJoin(Paint.Join.ROUND);

        pain.setColor(color);
        store.put(path, pain);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (Map.Entry<Path, Paint> entry : store.entrySet()) {
            canvas.drawPath(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(x, y);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(x,y);
                break;
        }
        invalidate();
        return true;
    }

    public void clear(){
        store.clear();
        invalidate();
    }

    public void back(){
        if(!store.isEmpty()){
            Iterator<Map.Entry<Path, Paint>> iterator = store.entrySet().iterator();
            while (iterator.hasNext()) {
                iterator.next();
            }
            iterator.remove();
            invalidate();
        }
    }
}
