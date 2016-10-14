package com.ivy.douban.adapter;

import android.content.Context;

import com.ivy.douban.R;
import com.ivy.douban.adapter.common.CommonAdapter;
import com.ivy.douban.adapter.common.ViewHolder;
import com.ivy.douban.domain.Person;

import java.util.List;

/**
 * Created by Ivy on 2016/10/12.
 *
 * @description:
 */

public class PersonAdapter extends CommonAdapter<Person> {
    public PersonAdapter(Context context, List<Person> mDatas, int itemLayoutId) {
        super(context, mDatas, itemLayoutId);
    }

    @Override
    public void convert(ViewHolder holder, Person item) {

        holder.setText(R.id.tv_name, item.toString());
    }
}
