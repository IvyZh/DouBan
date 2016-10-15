package com.ivy.douban.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ivy.douban.R;
import com.ivy.douban.base.BaseActivity;
import com.ivy.douban.base.BaseFragment;
import com.ivy.douban.fragments.BookFragment;
import com.ivy.douban.fragments.MovieFragment;
import com.ivy.douban.fragments.MusicFragment;
import com.ivy.douban.utils.L;
import com.ivy.douban.utils.UIUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {

    @BindView(R.id.vp_main)
    ViewPager mVpMain;
    @BindView(R.id.iv_book)
    ImageView mIvBook;
    @BindView(R.id.tv_book)
    TextView mTvBook;
    @BindView(R.id.rl_book)
    RelativeLayout mRlBook;
    @BindView(R.id.iv_movie)
    ImageView mIvMovie;
    @BindView(R.id.tv_movie)
    TextView mTvMovie;
    @BindView(R.id.rl_movie)
    RelativeLayout mRlMovie;
    @BindView(R.id.iv_music)
    ImageView mIvMusic;
    @BindView(R.id.tv_music)
    TextView mTvMusic;
    @BindView(R.id.rl_music)
    RelativeLayout mRlMusic;

    private ArrayList<BaseFragment> fragments;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragments = new ArrayList<>();
        fragments.add(new BookFragment());
        fragments.add(new MovieFragment());
        fragments.add(new MusicFragment());

        mVpMain.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragments));

        mVpMain.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                L.v("onPageSelected " + position);
                selectPos(position);
                fragments.get(position).initData();
            }
        });

        selectPos(0);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

//        fragments.get(1).initData();

    }


    @OnClick({R.id.rl_book, R.id.rl_movie, R.id.rl_music})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_book:
                selectPos(0);
                break;
            case R.id.rl_movie:
                selectPos(1);
                break;
            case R.id.rl_music:
                selectPos(2);
                break;
        }
    }

    private void selectPos(int pos) {
        mVpMain.setCurrentItem(pos);

        // 还原所有状态

        mTvBook.setTextColor(UIUtils.getColor(R.color.bottom_text_nor));
        mTvMovie.setTextColor(UIUtils.getColor(R.color.bottom_text_nor));
        mTvMusic.setTextColor(UIUtils.getColor(R.color.bottom_text_nor));
        mIvBook.setImageResource(R.mipmap.icon_book);
        mIvMovie.setImageResource(R.mipmap.icon_movie);
        mIvMusic.setImageResource(R.mipmap.icon_music);

        //设置新数据
        switch (pos) {
            case 0:
                mTvBook.setTextColor(UIUtils.getColor(R.color.bottom_text_pre));
                mIvBook.setImageResource(R.mipmap.icon_book_pre);
                break;
            case 1:
                mTvMovie.setTextColor(UIUtils.getColor(R.color.bottom_text_pre));
                mIvMovie.setImageResource(R.mipmap.icon_movie_pre);
                break;
            case 2:
                mTvMusic.setTextColor(UIUtils.getColor(R.color.bottom_text_pre));
                mIvMusic.setImageResource(R.mipmap.icon_music_pre);
                break;
        }

    }


    class FragmentAdapter extends FragmentPagerAdapter {

        private ArrayList<BaseFragment> fragments;

        public FragmentAdapter(FragmentManager fm, ArrayList<BaseFragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

}
