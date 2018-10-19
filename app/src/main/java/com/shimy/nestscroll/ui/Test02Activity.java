package com.shimy.nestscroll.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;

import com.shimy.nestscroll.R;
import com.shimy.nestscroll.adapter.TestAdapter;
import com.shimy.nestscroll.bean.Test;
import com.shimy.nestscroll.databinding.ActivityTest02Binding;
import com.shimy.nestscroll.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

public class Test02Activity extends AppCompatActivity {

    private ActivityTest02Binding mBinding;

    private List<Test> mList = new ArrayList<>();

    private TestAdapter mAdapter = new TestAdapter(this, mList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test02);
        init();
    }

    private void init() {
        mBinding.recyclerTest02.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerTest02.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mList.addAll(DataUtils.getTests(20));
        mBinding.recyclerTest02.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }
}
