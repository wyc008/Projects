package com.wyc.sample.custom.layoutmanager;

import android.graphics.PointF;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/**
 * author : Michael Wang
 * e-mail : 1396794927@qq.com
 * date   : 2020/4/12/13:50
 * desc   :
 * version: 1.0
 */
public class ScrollLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    // 滑动的方向
    private int mOrientation;
    // 无参构造器
    public ScrollLayoutManager() {
        this(RecyclerView.HORIZONTAL);
    }

    public ScrollLayoutManager(int mOrientation) {
        this.mOrientation = mOrientation;
    }

    /**
     * 设置滑动方向
     */
    public void setOrientation(int mOrientation){
        this.mOrientation = mOrientation;
    }

    @Override
    public void assertInLayoutOrScroll(String message) {
        super.assertInLayoutOrScroll(message);
    }

    @Override
    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollHorizontallyBy(dx, recycler, state);
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollVerticallyBy(dy, recycler, state);
    }

    // 布局参数
    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(RecyclerView.LayoutParams.WRAP_CONTENT,
                RecyclerView.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {

    }

    /**
     * 水平滚动
     * @return true 是
     */
    @Override
    public boolean canScrollHorizontally() {
        return this.mOrientation == RecyclerView.HORIZONTAL;
    }

    /**
     * 竖直滚动
     * @return true 是
     */
    @Override
    public boolean canScrollVertically() {
        return this.mOrientation == RecyclerView.VERTICAL;
    }

    @Nullable
    @Override
    public PointF computeScrollVectorForPosition(int targetPosition) {
        return null;
    }
}
