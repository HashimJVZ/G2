package com.example.g2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import static android.os.Build.ID;

public class G2 extends View {
    int height, width;
    int defaultWidth =  200, defaultHeight = 200;
    Paint gridPaint, fillPaint, textPaint;

    void init(){
        gridPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        gridPaint.setColor(Color.BLACK);
        fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fillPaint.setColor(Color.DKGRAY);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.RED);
    }
    public G2(Context context) {
        super(context);
        init();
    }

    public G2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public G2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public G2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);

        switch (MeasureSpec.getMode(widthMeasureSpec)) {
            case MeasureSpec.UNSPECIFIED:
                width = defaultWidth;
                break;
            case MeasureSpec.AT_MOST:
                if (defaultWidth < width) width = defaultWidth;
                break;
        }

        switch (MeasureSpec.getMode(heightMeasureSpec)) {
            case MeasureSpec.UNSPECIFIED:
                height = defaultHeight;
                break;
            case MeasureSpec.AT_MOST:
                if (defaultHeight < height) height = defaultHeight;
                break;

        }
        Log.d("hashim", "height: "+height+" widht:"+width);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(width/2,width/2,width/3,gridPaint);
    }


}
