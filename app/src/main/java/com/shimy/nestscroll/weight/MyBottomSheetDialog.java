package com.shimy.nestscroll.weight;

import android.content.Context;
import android.support.v7.app.AppCompatDialog;

/**
 * @Auther shimy
 * @Create 2018/10/19 13:49
 * bottomsheet 的n段斩
 */
public class MyBottomSheetDialog extends AppCompatDialog {

    public MyBottomSheetDialog(Context context) {
        super(context);
    }

    public MyBottomSheetDialog(Context context, int theme) {
        super(context, theme);
    }

    protected MyBottomSheetDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


}
