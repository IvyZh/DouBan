package com.ivy.douban.holder.impl;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ivy.douban.R;
import com.ivy.douban.domain.MoviesBean;
import com.ivy.douban.holder.BaseHolder;
import com.ivy.douban.ui.DividerItemDecoration;
import com.ivy.douban.utils.L;
import com.ivy.douban.utils.UIUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static com.ivy.douban.R.id.recyclerView;

/**
 * Created by Ivy on 2016/10/14.
 *
 * @description:
 */

public class TheatersHolder extends BaseHolder {
    @BindView(R.id.tv_more)
    TextView mTvMore;
    @BindView(recyclerView)
    RecyclerView mRecyclerView;

    @Override
    public View setContentView() {


        return UIUtils.inflate(R.layout.layout_theater_holder);
    }

    public void setData(List<MoviesBean.SubjectsBean> mDatas) {

        LinearLayoutManager layoutManager = new LinearLayoutManager(UIUtils.getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        DividerItemDecoration decoration = new DividerItemDecoration(UIUtils.getContext(), DividerItemDecoration.HORIZONTAL_LIST);
        mRecyclerView.addItemDecoration(decoration);

        mRecyclerView.setLayoutManager(layoutManager);


        MovieAdapter adapter = new MovieAdapter(mDatas);
        mRecyclerView.setAdapter(adapter);

    }

    @OnClick(R.id.tv_more)
    public void onClick() {
    }


    class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
        private List<MoviesBean.SubjectsBean> mDatas;

        MovieAdapter(List<MoviesBean.SubjectsBean> mDatas) {
            L.v("new MovieAdapter");
            this.mDatas = mDatas;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            L.v(" onCreateViewHolder");
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    UIUtils.getContext()).inflate(R.layout.item_movie, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            L.v(" onBindViewHolder");
            MoviesBean.SubjectsBean item = mDatas.get(position);
            holder.tvTitle.setText(item.getTitle());

            String medium = item.getImages().getMedium();
            Glide.with(UIUtils.getContext()).load(medium).into(holder.ivCover);

            MoviesBean.SubjectsBean.RatingBean rating = item.getRating();
            int max = rating.getMax();
            double average = rating.getAverage();
            int rate = (int) (average / 2 + 0.5);
            if (rate > 5) rate = 5;
            holder.rbRating.setMax(max);
            holder.rbRating.setProgress(rate);
        }


        @Override
        public int getItemCount() {
            L.v("getCount:" + mDatas.size());
            return mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tvRating;
            TextView tvTitle;
            ImageView ivCover;
            RatingBar rbRating;

            public MyViewHolder(View view) {
                super(view);
                tvRating = (TextView) view.findViewById(R.id.tv_rating);
                tvTitle = (TextView) view.findViewById(R.id.tv_title);
                ivCover = (ImageView) view.findViewById(R.id.iv_cover);
                rbRating = (RatingBar) view.findViewById(R.id.rb_rating);
            }
        }
    }

}
