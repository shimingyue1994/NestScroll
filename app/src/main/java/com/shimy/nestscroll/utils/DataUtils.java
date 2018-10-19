package com.shimy.nestscroll.utils;

import com.shimy.nestscroll.bean.Test;

import java.util.ArrayList;
import java.util.List;

public class DataUtils {


    public static List<Test> getTests(int count) {
        List<Test> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Test test = new Test(i + "A :我只是想做个好人", i + "B :对不起 我是警察");
            list.add(test);
        }
        return list;
    }
}
