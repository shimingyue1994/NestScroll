package com.shimy.nestscroll.behavior.uc;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.shimy.nestscroll.R;
import com.shimy.nestscroll.behavior.uc.help.HeaderScrollingViewBehavior;
import com.shimy.nestscroll.utils.AppUtils;

import java.util.List;

/**
 * @Auther shimy
 * @Create 2018/10/19 9:28
 * <p>
 * uc tablayout的behavior
 * </p>
 */
public class UcNewsTabBehavior extends HeaderScrollingViewBehavior {


    public UcNewsTabBehavior() {
    }

    public UcNewsTabBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return isDependOn(dependency);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
//        int top = child.getTop();
//        Log.i(this.getClass().getSimpleName(), "top" + top);
        float finalY = dependency.getTranslationY() * 2;
        if (finalY <= -dependency.getHeight() + AppUtils.dp2px(child.getContext(), 45)) {
            finalY = -dependency.getHeight() + AppUtils.dp2px(child.getContext(), 45);
        }
        child.setTranslationY(finalY);
        return false;
    }

    /**
     * 供父类使用，作用：将使用此Behavior的布局放在依赖的布局之下
     *
     * @param views
     * @return
     */
    @Override
    protected View findFirstDependency(List<View> views) {
        for (int i = 0, z = views.size(); i < z; i++) {
            View view = views.get(i);
            if (isDependOn(view))
                return view;
        }
        return null;
    }


    private boolean isDependOn(View dependency) {
        return dependency != null && dependency.getId() == R.id.layout_uc_header;
    }
}
