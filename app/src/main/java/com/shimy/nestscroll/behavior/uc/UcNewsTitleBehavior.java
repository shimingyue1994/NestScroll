package com.shimy.nestscroll.behavior.uc;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.shimy.nestscroll.R;
import com.shimy.nestscroll.utils.AppUtils;

/**
 * @Auther shimy
 * @Create 2018/10/19 9:28
 * <p>
 * uc 标题栏的 behavior
 * </p>
 */
public class UcNewsTitleBehavior extends CoordinatorLayout.Behavior<View> {

    public UcNewsTitleBehavior() {
    }

    public UcNewsTitleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        // FIXME: 16/7/27 不知道为啥在XML设置-45dip,解析出来的topMargin少了1个px,所以这里用代码设置一遍
        ((CoordinatorLayout.LayoutParams) child.getLayoutParams()).topMargin = -AppUtils.dp2px(child.getContext(), 45);
        parent.onLayoutChild(child, layoutDirection);
        return true;
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return isDependOn(dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float finalY = -dependency.getTranslationY();
        if (dependency.getTranslationY() <= -AppUtils.dp2px(child.getContext(), 45)) {
            finalY = AppUtils.dp2px(child.getContext(), 45);
        }
        child.setTranslationY(finalY);
        return false;
    }

    private boolean isDependOn(View dependency) {
        return dependency != null && dependency.getId() == R.id.layout_uc_header;
    }
}
