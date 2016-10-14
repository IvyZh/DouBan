package com.ivy.douban.fragments;

import android.view.LayoutInflater;
import android.view.View;

import com.ivy.douban.R;
import com.ivy.douban.base.BaseFragment;

/**
 * Created by Ivy on 2016/10/14.
 *
 * @description:
 */

public class BookFragment extends BaseFragment {
    @Override
    public View initView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.fragment_book, null);
    }

    @Override
    protected void initFindViewById(View view) {

    }

    @Override
    public void initData() {

    }
}
