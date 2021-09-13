package com.wyc.sample.custom.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * author : Michael Wang
 * e-mail : 1396794927@qq.com
 * date   : 2020/4/13/22:25
 * desc   :
 * version: 1.0
 */
public class CustomView extends View {

    private Paint mPaint = new Paint();
    // 容器高度
    private int viewHeight;
    // 容器宽度
    private int viewWidth;
    RectF mRectF;

    private int mLeft = 10;
    private int mTop = 10;
    private int mRight = 10;
    private int mBottom = 10;

    public CustomView(Context context) {
        super(context);
//        mPaint = new Paint();
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        viewHeight = getSize(200,heightMeasureSpec);
        viewWidth = getSize(200, widthMeasureSpec);
        mRectF = new RectF(mLeft,mRight , viewHeight-10, viewWidth-10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int r = (getMeasuredWidth()-mLeft-mRight)/2;
        int mX = getMeasuredWidth()/2;
        int mY = getMeasuredHeight()/2;
        mPaint.setColor(Color.GREEN);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
        canvas.drawCircle(mX, mY, r, mPaint);

        int pY = getMeasuredHeight()/2;
        int pX = getMeasuredWidth()/2;
        mPaint.setColor(Color.BLACK);
        mPaint.setStrokeWidth(2);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(40);
        canvas.drawText("50%", pX, pY, mPaint);



        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.RED);
        canvas.drawArc(mRectF, -90, 270,false, mPaint);


    }

    private int getSize(int def, int specSize){
        int mode = MeasureSpec.getMode(specSize);
        int size = MeasureSpec.getSize(specSize);
        int mySize = 0;
        switch (mode){
            case MeasureSpec.UNSPECIFIED:
                mySize=def;
                break;
            //如果测量模式是最大取值size
            //我们将大小取最大值，你也可以取其他值
            case MeasureSpec.AT_MOST:
            //如果是固定的大小，那就不要去改变它
            case MeasureSpec.EXACTLY:
                mySize=size;
                break;
            default:
                break;
        }

        return mySize;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
