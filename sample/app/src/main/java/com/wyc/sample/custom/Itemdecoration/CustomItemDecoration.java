package com.wyc.sample.custom.Itemdecoration;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author : Michael Wang
 * e-mail : 1396794927@qq.com
 * date   : 2020/4/10/23:38
 * desc   : item间隔
 * version: 1.0
 */
public class CustomItemDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint;
    private int spacing = 0;
    private int top, bottom, left, right;
    public CustomItemDecoration(int top, int bottom, int left, int right) {
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
    }

    public void setSpacing(int spacing){
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.top = top;
        outRect.bottom = bottom;
        outRect.left = left;
        outRect.right = right;
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        RecyclerView.LayoutManager layoutManager = parent.getLayoutManager();
        for (int i = 0; i < childCount; i++){
            View child = parent.getChildAt(i);
//            int cx = child.getLeft() - left/2;
            //getLeftDecorationWidth:左间距
            int cx = layoutManager.getLeftDecorationWidth(child)/2;
            int cy = child.getTop() + child.getHeight()/2;
            mPaint.setColor(Color.BLACK);
            c.drawCircle(cx, cy, 20, mPaint);
        }
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++){
            View child = parent.getChildAt(i);
            int cl = child.getLeft();
            int cr = child.getRight();
            int ct = child.getBottom();
            int cb = child.getBottom() + 5;
            mPaint.setColor(Color.BLUE);
            c.drawRect(cl,ct,cr,cb,mPaint);
        }
    }
}
