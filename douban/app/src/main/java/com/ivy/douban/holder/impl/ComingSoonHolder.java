package com.ivy.douban.holder.impl;

import android.view.View;

import com.ivy.douban.R;
import com.ivy.douban.holder.BaseHolder;
import com.ivy.douban.utils.UIUtils;

/**
 * Created by Ivy on 2016/10/14.
 *
 * @description:
 */

public class ComingSoonHolder extends BaseHolder {
    @Override
    public View setContentView() {
        return UIUtils.inflate(R.layout.layout_coming_soon_holder);
    }
}
