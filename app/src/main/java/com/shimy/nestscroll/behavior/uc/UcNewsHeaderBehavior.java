package com.shimy.nestscroll.behavior.uc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 *
 * @Auther shimy
 * @Create 2018/10/19 9:29
 * <p>
 *     uc header 的beahvior(头部)
 * </p>
 */
import com.shimy.nestscroll.AppApplication;
import com.shimy.nestscroll.behavior.uc.help.ViewOffsetBehavior;
import com.shimy.nestscroll.utils.AppUtils;

public class UcNewsHeaderBehavior extends ViewOffsetBehavior {

    public UcNewsHeaderBehavior() {
    }

    public UcNewsHeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
//        return super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        float finalY = child.getTranslationY() - dy;
        if (finalY <= (-child.getHeight() + AppUtils.dp2px(child.getContext(), 90))) {
            finalY = -child.getHeight() + AppUtils.dp2px(child.getContext(), 90);
            child.setTranslationY(finalY);
            return;
        }
        child.setTranslationY(finalY);
        consumed[1] = dy;
    }
}
