package com.ivy.douban.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.ivy.douban.R;

/**
 * Created by Ivy on 2016/10/12.
 *
 * @description:
 */

public class MyListView extends ListView {
    public MyListView(Context context) {
        super(context);
        initView(context);

    }


    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    private void initView(Context context) {
        View footerView = LayoutInflater.from(context).inflate(R.layout.footer_view, null);
        addFooterView(footerView);
    }


}
