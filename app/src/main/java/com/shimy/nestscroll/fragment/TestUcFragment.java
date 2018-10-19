package com.shimy.nestscroll.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.plus.PlusOneButton;
import com.shimy.nestscroll.R;
import com.shimy.nestscroll.adapter.TestAdapter;
import com.shimy.nestscroll.bean.Test;
import com.shimy.nestscroll.databinding.ActivityTest02Binding;
import com.shimy.nestscroll.databinding.FragmentTestUcBinding;
import com.shimy.nestscroll.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;

public class TestUcFragment extends Fragment {

    private FragmentTestUcBinding mBinding;


    private List<Test> mList = new ArrayList<>();

    private TestAdapter mAdapter = new TestAdapter(getActivity(), mList);

    public TestUcFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_test_uc, container, false);
        initView();
        return mBinding.getRoot();
    }


    private void initView() {
        mBinding.recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.recycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        mList.addAll(DataUtils.getTests(20));
        mBinding.recycler.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        mBinding.swipe.setOnRefreshListener(()->{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mBinding.swipe.setRefreshing(false);
                    Toast.makeText(getContext(), "刷新完成", Toast.LENGTH_SHORT).show();
                }
            }, 2000);
        });

    }
}
