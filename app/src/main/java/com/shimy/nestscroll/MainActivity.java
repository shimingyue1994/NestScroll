package com.shimy.nestscroll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.shimy.nestscroll.adapter.MainAdapter;
import com.shimy.nestscroll.bean.MainBean;
import com.shimy.nestscroll.ui.Test01Activity;
import com.shimy.nestscroll.ui.Test02Activity;
import com.shimy.nestscroll.ui.Test03Activity;
import com.shimy.nestscroll.ui.Test04Activity;
import com.shimy.nestscroll.ui.Test05Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther shimy
 * @Create 2018/10/16 9:36
 * <p>
 * <a href='https://www.jianshu.com/p/cd2c1c9f68d4'>https://www.jianshu.com/p/cd2c1c9f68d4</a>
 */
public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private MainAdapter adapter;
    private List<MainBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initData();
    }

    private void init() {
        recyclerView = findViewById(R.id.recycler_main);
        list = new ArrayList<>();
        adapter = new MainAdapter(this, list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener((view, position) -> {
            startActivity(new Intent(MainActivity.this, list.get(position).getActivity()));
        });
    }

    private void initData() {
        list.add(new MainBean(Test01Activity.class, "test01_基本使用1", "test01_基本使用1"));
        list.add(new MainBean(Test02Activity.class, "test02_自定义", "test01_layoutDependsOn"));
        list.add(new MainBean(Test03Activity.class, "test03_自定义", "layoutDependsOn+onStartNestedScroll"));
        list.add(new MainBean(Test04Activity.class, "test04_自定义", "uc"));
        list.add(new MainBean(Test05Activity.class, "test05_BottomDialog", "test05_BottomDialog"));
        adapter.notifyDataSetChanged();
    }
}
