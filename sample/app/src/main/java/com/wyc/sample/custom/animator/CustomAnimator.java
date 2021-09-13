package com.wyc.sample.custom.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewPropertyAnimator;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

/**
 * author : Michael Wang
 * e-mail : 1396794927@qq.com
 * date   : 2020/4/11/16:18
 * desc   : 自定义动画
 * version: 1.0
 */
public class CustomAnimator extends SimpleItemAnimator {

    private static final String TAG = CustomAnimator.class.getSimpleName();
    /**
     * 时间插值器
     */
    private static TimeInterpolator mCustTimeInterpolator;

    // 需要移除的item的集合
    private ArrayList<RecyclerView.ViewHolder> mPendingRemovals = new ArrayList<>();
    // 需要添加的item的集合
    private ArrayList<RecyclerView.ViewHolder> mPendingAdditions = new ArrayList<>();
    // 需要移动的item的集合
    private ArrayList<MoveInfo> mPendingMoves = new ArrayList<>();
    // 需要更新的item的集合
    private ArrayList<ChangeInfo> mPendingChanges = new ArrayList<>();

    // 添加集合列表
    ArrayList<ArrayList<RecyclerView.ViewHolder>> mAdditionsList = new ArrayList<>();
    // 移动集合列表
    ArrayList<ArrayList<MoveInfo>> mMovesList = new ArrayList<>();
    // 更新集合列表
    ArrayList<ArrayList<ChangeInfo>> mChangesList = new ArrayList<>();

    // 添加动画ViewHolder列表
    ArrayList<RecyclerView.ViewHolder> mAddAnimations = new ArrayList<>();
    // 移动动画ViewHolder列表
    ArrayList<RecyclerView.ViewHolder> mMoveAnimations = new ArrayList<>();
    // 移动动画ViewHolder列表
    ArrayList<RecyclerView.ViewHolder> mRemoveAnimations = new ArrayList<>();
    // 更新动画ViewHolder列表
    ArrayList<RecyclerView.ViewHolder> mChangeAnimations = new ArrayList<>();

    private static class MoveInfo {
        public RecyclerView.ViewHolder holder;
        public int fromX, fromY, toX, toY;

        public MoveInfo(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
            this.holder = holder;
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }
    }

    private static class ChangeInfo {
        public RecyclerView.ViewHolder oldHolder, newHolder;
        public int fromX, fromY, toX, toY;

        private ChangeInfo(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder) {
            this.oldHolder = oldHolder;
            this.newHolder = newHolder;
        }

        public ChangeInfo(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder,
                          int fromX, int fromY, int toX, int toY) {
            this(oldHolder, newHolder);
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }

        @Override
        public String toString() {
            return "ChangeInfo{" +
                    "oldHolder=" + oldHolder +
                    ", newHolder=" + newHolder +
                    ", fromX=" + fromX +
                    ", fromY=" + fromY +
                    ", toX=" + toX +
                    ", toY=" + toY +
                    '}';
        }
    }

    /**
     * 移除item执行的动画
     *
     * @param holder The item that is being removed.
     * @return true if a later call to {@link #runPendingAnimations()} is requested,
     * false otherwise.
     */
    @Override
    public boolean animateRemove(RecyclerView.ViewHolder holder) {
        //业务控制是否执行该viewHolder的动画  比如通讯录列表，判断只有联
        //系人的ViewHolder执行动画，如果是分组头部ViewHolder则不执行动画
        return false;
    }

    /**
     * 添加item执行的动画
     *
     * @param holder 要添加的item
     * @return true if a later call to {@link #runPendingAnimations()} is requested,
     * false otherwise.
     */
    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        return false;
    }

    @Override
    public boolean animateMove(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        return false;
    }

    @Override
    public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int fromLeft, int fromTop, int toLeft, int toTop) {
        return false;
    }

    @Override
    public void runPendingAnimations() {
        boolean removalsPending = !mPendingRemovals.isEmpty();
        boolean additionsPending = !mPendingAdditions.isEmpty();
        boolean movesPending = !mPendingMoves.isEmpty();
        boolean changesPending = !mPendingChanges.isEmpty();

        if (!removalsPending && !additionsPending && !movesPending && !changesPending) {
            // nothing to animate
            return;
        }

        // 移除模块
        for (RecyclerView.ViewHolder holder : mPendingRemovals) {
            animateRemoveImpl(holder);
        }
        mPendingRemovals.clear();

        // 移动模块
        if (movesPending) {
            final ArrayList<MoveInfo> moves = new ArrayList<>();
            moves.addAll(mPendingMoves);
            mMovesList.add(moves);
            mPendingMoves.clear();
            Runnable mover = new Runnable() {
                @Override
                public void run() {
                    for (MoveInfo moveInfo : moves) {
                        animateMoveImpl(moveInfo.holder, moveInfo.fromX, moveInfo.fromY,
                                moveInfo.toX, moveInfo.toY);
                    }
                    moves.clear();
                    mMovesList.remove(moves);
                }
            };

            if (removalsPending) {
                View view = moves.get(0).holder.itemView;
                ViewCompat.postOnAnimationDelayed(view, mover, getRemoveDuration());
            } else {
                mover.run();
            }

            // 更新变化模块, to run in parallel with move animations
            if(changesPending){
                final ArrayList<ChangeInfo> changes = new ArrayList<>();
                changes.addAll(mPendingChanges);
                mChangesList.add(changes);
                mPendingChanges.clear();
                Runnable changer = new Runnable() {
                    @Override
                    public void run() {
                        for (ChangeInfo changeInfo : changes){
                            animateChangeImpl(changeInfo);
                        }
                    }
                };
                if (removalsPending){
                    View view = changes.get(0).oldHolder.itemView;
                    ViewCompat.postOnAnimationDelayed(view, changer, getRemoveDuration());
                } else {
                    changer.run();
                }
            }

            // 添加item模块
            if(additionsPending){

            }
        }
    }

    @Override
    public void endAnimation(@NonNull RecyclerView.ViewHolder item) {

    }

    @Override
    public void endAnimations() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    //移除动画实现
    private void animateRemoveImpl(final RecyclerView.ViewHolder holder) {
        // 视图
        final View view = holder.itemView;
        final ViewPropertyAnimator animation = view.animate();
        mRemoveAnimations.add(holder);
        animation.setDuration(getRemoveDuration())
                .alpha(0)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animator) {
                        animation.setListener(null);
                        view.setAlpha(1);
                        dispatchRemoveFinished(holder);
                        mRemoveAnimations.remove(holder);
                        dispatchFinishedWhenDone();
                    }

                    @Override
                    public void onAnimationStart(Animator animator) {
                        dispatchRemoveStarting(holder);
                    }
                }).start();
    }

    // 移动动画实现
    private void animateMoveImpl(final RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {

    }

    // 更新变化动画实现
    private void animateChangeImpl(final ChangeInfo changeInfo){

    }

    void dispatchFinishedWhenDone() {
        if (!isRunning()) {
            dispatchAnimationsFinished();
        }
    }
}
