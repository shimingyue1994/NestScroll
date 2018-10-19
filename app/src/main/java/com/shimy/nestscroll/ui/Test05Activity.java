package com.shimy.nestscroll.ui;

import android.databinding.DataBindingUtil;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.shimy.nestscroll.R;
import com.shimy.nestscroll.adapter.TestAdapter;
import com.shimy.nestscroll.bean.Test;
import com.shimy.nestscroll.databinding.ActivityTest05Binding;
import com.shimy.nestscroll.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther shimy
 * @Create 2018/10/19 11:30
 * dialog
 */
public class Test05Activity extends AppCompatActivity {

    private ActivityTest05Binding mBinding;


    private List<Test> mList = new ArrayList<>();

    private TestAdapter mAdapter = new TestAdapter(this, mList);


    private BottomSheetDialog bs01;

    private int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test05);
        WindowManager wm = this.getWindowManager();
        height = wm.getDefaultDisplay().getHeight();
        click();
        initDialog01();
    }

    private void click() {
        mBinding.btnDialog01.setOnClickListener((view) -> {
            bs01.show();
        });
    }


    private void initDialog01() {
        bs01 = new BottomSheetDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_bottom_01, null);
        RecyclerView recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mList.addAll(DataUtils.getTests(5));
        recyclerView.setAdapter(mAdapter);
        bs01.setContentView(view);

//        BottomSheetBehavior mBehavior = BottomSheetBehavior.from((View) view.getParent());
//        //设置默认弹出高度为屏幕的0.4倍
//        mBehavior.setPeekHeight((int) (0.4 * height));
//        mBehavior.setSkipCollapsed(false);

    }
}
