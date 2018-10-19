package com.shimy.nestscroll.behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.TreeMap;

public class SampleHeaderBehavior extends CoordinatorLayout.Behavior<View> {


    public SampleHeaderBehavior() {
    }

    public SampleHeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @param coordinatorLayout
     * @param child
     * @param directTargetChild
     * @param target
     * @param axes
     * @param type
     * @return true : 表示接受子view的移动距离，在onNestedPreScroll等方法里决定消耗 及消耗多少
     */
    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        /*只处理触摸事件引起的滑动，非触摸事件如fling不处理*/
        if (type == ViewCompat.TYPE_TOUCH) {
            return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
        } else if (type == ViewCompat.TYPE_NON_TOUCH) {
            return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
        }
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        RecyclerView recyclerView = (RecyclerView) target;
        int pos = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();

        float finalY = child.getTranslationY() - dy;

        if (dy > 0) {
            if (finalY < -child.getHeight()) {
                finalY = -child.getHeight();
                child.setTranslationY(finalY);
                return;
            }
            child.setTranslationY(finalY);
            consumed[1] = dy;
        } else {
            /*向下滑动*/
            if (finalY > 0)
                finalY = 0;
            if (pos == 0 && finalY <= 0) {
                child.setTranslationY(finalY);
            }
        }
    }
}
