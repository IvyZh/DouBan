package com.ivy.douban.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ivy.douban.R;
import com.ivy.douban.base.BaseFragment;


/**
 * Created by Ivy on 2016/10/14.
 *
 * @description:
 */

public class MusicFragment extends BaseFragment {
    @Override
    public View initView(LayoutInflater inflater) {
        TextView view = new TextView(mActivity);
        view.setText("Music");

        return view;
    }

    @Override
    protected void initFindViewById(View view) {

    }

    @Override
    public void initData() {

    }
}
