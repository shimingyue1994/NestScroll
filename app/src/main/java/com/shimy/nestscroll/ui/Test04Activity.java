package com.shimy.nestscroll.ui;

import android.databinding.DataBindingUtil;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shimy.nestscroll.R;
import com.shimy.nestscroll.fragment.TestUcFragment;
import com.shimy.nestscroll.adapter.TestFragmentAdapter;
import com.shimy.nestscroll.databinding.ActivityTest04Binding;

import java.util.ArrayList;
import java.util.List;

public class Test04Activity extends AppCompatActivity {

    private ActivityTest04Binding mBinding;

    private List<TestUcFragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test04);
        init();
    }

    private void init() {
        mFragments = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            mFragments.add(new TestUcFragment());
            mBinding.tablayoutUc.addTab(mBinding.tablayoutUc.newTab().setText("Tab" + i));
        }
        mBinding.tablayoutUc.setTabMode(mBinding.tablayoutUc.MODE_FIXED);
        mBinding.tablayoutUc.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mBinding.viewpageUc.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mBinding.viewpageUc.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mBinding.tablayoutUc));
        mBinding.viewpageUc.setAdapter(new TestFragmentAdapter(mFragments, getSupportFragmentManager()));
    }
}
