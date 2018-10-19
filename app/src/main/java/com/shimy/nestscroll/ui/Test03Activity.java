package com.shimy.nestscroll.ui;

import android.databinding.DataBindingUtil;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.shimy.nestscroll.R;
import com.shimy.nestscroll.adapter.TestAdapter;
import com.shimy.nestscroll.bean.Test;
import com.shimy.nestscroll.databinding.ActivityTest02Binding;
import com.shimy.nestscroll.databinding.ActivityTest03Binding;
import com.shimy.nestscroll.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Auther shimy
 * @Create 2018/10/19 10:30
 *
 */
public class Test03Activity extends AppCompatActivity {
    private ActivityTest03Binding mBinding;

    private List<Test> mList = new ArrayList<>();
    private TestAdapter mAdapter = new TestAdapter(this, mList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test03);
        init();
    }

    private void init() {
        mBinding.recycler.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mList.addAll(DataUtils.getTests(20));
        mBinding.recycler.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
