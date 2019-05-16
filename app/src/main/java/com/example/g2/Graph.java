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

import java.util.List;

import static android.os.Build.ID;

public class Graph extends View {

    private List<Schedule> scheduleList;

    float layheight, laywidth, columnno = 7, columnwidth, rowno = 25, rowwidth;
    float startx, endx, dayx;

    int b = 0; //day number eg:SUN=0, MON=1, SAT=6;
    float starttime = 0;
    float endtime = 0;

    int defaultWidth =  200, defaultHeight = 200;
    String[] a;

    {
        a = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    }

    String hour, day;
    Paint gridPaint, fillPaint, textPaint;


    void init(){
        gridPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        gridPaint.setColor(Color.BLACK);
        fillPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        fillPaint.setColor(Color.DKGRAY);
        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(20);
    }
    public Graph(Context context ) {
        super(context);
        init();
    }

    public Graph(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Graph(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();

    }

    public Graph(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        laywidth = MeasureSpec.getSize(widthMeasureSpec);
        layheight = MeasureSpec.getSize(heightMeasureSpec);

        switch (MeasureSpec.getMode(widthMeasureSpec)) {
            case MeasureSpec.UNSPECIFIED:
                laywidth = defaultWidth;
                break;
            case MeasureSpec.AT_MOST:
                if (defaultWidth < laywidth) laywidth = defaultWidth;
                break;
        }

        switch (MeasureSpec.getMode(heightMeasureSpec)) {
            case MeasureSpec.UNSPECIFIED:
                layheight = defaultHeight;
                break;
            case MeasureSpec.AT_MOST:
                if (defaultHeight < layheight) layheight = defaultHeight;
                break;

        }
        Log.d("hashim", "layheight: "+layheight+" laywidth:"+laywidth);

        startx = (float) ((3.0/100)*laywidth);
        dayx = (float) ((1.5/100)*laywidth);
        endx = laywidth - startx;
        columnwidth = (endx-startx)/columnno;

        rowwidth = layheight/rowno;
        
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //drawing horizontal lines
        for(float i=endx; i>=startx; i-=columnwidth){
            canvas.drawLine(i,0, i, layheight,gridPaint);
        }

        //setting days on top of every column
        for(int i=0; i<columnno; i++){
            day = a[i];
            canvas.drawText(day,startx+columnwidth*i+(columnwidth/3),rowwidth-10,textPaint);
        }

        //drawing vertical lines
        for(float i=0; i<=layheight; i+=rowwidth){
            canvas.drawLine(0, i, endx, i, gridPaint);
        }

        //setting hours at starting of every row
        for(int i=0; i<=rowno; i++){
            if(i>1){
                hour = String.valueOf(i-1);
                canvas.drawText(hour, dayx-8,rowwidth*i-5, textPaint);
            }
        }

        if (scheduleList!=null) {
            for (int i = 0; i < scheduleList.size(); i++) {

                int d = scheduleList.get(i).getDay();
                float s = scheduleList.get(i).getStarttime();
                float e = scheduleList.get(i).getEndtime();

                canvas.drawRect(startx+(columnwidth*d),rowwidth+s*rowwidth,
                        startx+(columnwidth*(d+1)),rowwidth+e*rowwidth,fillPaint);
            }

            invalidate();

        } else {
            canvas.drawRect(startx+(columnwidth*b),rowwidth+starttime*rowwidth,
                    startx+(columnwidth*(b+1)),rowwidth+endtime*rowwidth,fillPaint);

        }



    }

    /**
     * Give list of days
     * @param list list days
     */
    public void setSchedule(List<Schedule> list){
        this.scheduleList = list;
    }
}
