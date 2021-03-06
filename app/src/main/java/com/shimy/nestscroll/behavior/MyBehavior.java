package com.shimy.nestscroll.behavior;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MyBehavior extends CoordinatorLayout.Behavior<Button> {

    public MyBehavior() {
        super();
    }

    public MyBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams params) {
        super.onAttachedToLayoutParams(params);
    }

    @Override
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
    }

    @Override
    public boolean onInterceptTouchEvent(CoordinatorLayout parent, Button child, MotionEvent ev) {
        return super.onInterceptTouchEvent(parent, child, ev);
    }

    @Override
    public boolean onTouchEvent(CoordinatorLayout parent, Button child, MotionEvent ev) {
        return super.onTouchEvent(parent, child, ev);
    }

    @Override
    public int getScrimColor(CoordinatorLayout parent, Button child) {
        return super.getScrimColor(parent, child);
    }

    @Override
    public float getScrimOpacity(CoordinatorLayout parent, Button child) {
        return super.getScrimOpacity(parent, child);
    }

    @Override
    public boolean blocksInteractionBelow(CoordinatorLayout parent, Button child) {
        return super.blocksInteractionBelow(parent, child);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, Button child, View dependency) {
        return super.layoutDependsOn(parent, child, dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, Button child, View dependency) {
        return super.onDependentViewChanged(parent, child, dependency);
    }

    @Override
    public void onDependentViewRemoved(CoordinatorLayout parent, Button child, View dependency) {
        super.onDependentViewRemoved(parent, child, dependency);
    }

    @Override
    public boolean onMeasureChild(CoordinatorLayout parent, Button child, int parentWidthMeasureSpec, int widthUsed, int parentHeightMeasureSpec, int heightUsed) {
        return super.onMeasureChild(parent, child, parentWidthMeasureSpec, widthUsed, parentHeightMeasureSpec, heightUsed);
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, Button child, int layoutDirection) {
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Button child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }


    @Override
    public void onNestedScrollAccepted(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Button child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        super.onNestedScrollAccepted(coordinatorLayout, child, directTargetChild, target, axes, type);
    }


    @Override
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Button child, @NonNull View target, int type) {
        super.onStopNestedScroll(coordinatorLayout, child, target, type);
    }


    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Button child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Button child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
    }

    @Override
    public boolean onNestedFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Button child, @NonNull View target, float velocityX, float velocityY, boolean consumed) {
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

    @Override
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull Button child, @NonNull View target, float velocityX, float velocityY) {
        return super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY);
    }

    @NonNull
    @Override
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, Button child, WindowInsetsCompat insets) {
        return super.onApplyWindowInsets(coordinatorLayout, child, insets);
    }

    @Override
    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, Button child, Rect rectangle, boolean immediate) {
        return super.onRequestChildRectangleOnScreen(coordinatorLayout, child, rectangle, immediate);
    }

    @Override
    public void onRestoreInstanceState(CoordinatorLayout parent, Button child, Parcelable state) {
        super.onRestoreInstanceState(parent, child, state);
    }

    @Override
    public Parcelable onSaveInstanceState(CoordinatorLayout parent, Button child) {
        return super.onSaveInstanceState(parent, child);
    }

    @Override
    public boolean getInsetDodgeRect(@NonNull CoordinatorLayout parent, @NonNull Button child, @NonNull Rect rect) {
        return super.getInsetDodgeRect(parent, child, rect);
    }
}
