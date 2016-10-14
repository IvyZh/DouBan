package com.ivy.douban.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.ivy.douban.R;
import com.ivy.douban.base.BaseFragment;
import com.ivy.douban.domain.MoviesBean;
import com.ivy.douban.holder.impl.ComingSoonHolder;
import com.ivy.douban.holder.impl.TheatersHolder;
import com.ivy.douban.net.Retrofit2Utils;
import com.ivy.douban.utils.L;
import com.ivy.douban.utils.UIUtils;

import java.util.List;

import butterknife.BindView;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Ivy on 2016/10/14.
 *
 * @description:
 */

public class MovieFragment extends BaseFragment {
    @BindView(R.id.fr_in_theater)
    FrameLayout mFrInTheater;
    @BindView(R.id.fr_coming_soon)
    FrameLayout mFrComingSoon;

    private TheatersHolder theatersHolder;
    private ComingSoonHolder comingSoonHolder;
    private Observer mObserver;

    @Override
    public View initView(LayoutInflater inflater) {
        L.v("initView MovieFragment");
        View view = UIUtils.inflate(R.layout.fragment_movie);

        return view;
    }

    @Override
    protected void initFindViewById(View view) {

        theatersHolder = new TheatersHolder();
        comingSoonHolder = new ComingSoonHolder();

        mFrInTheater.addView(theatersHolder.getContentView());
        mFrComingSoon.addView(comingSoonHolder.getContentView());

        L.v("initFindViewById init mObserver");

        mObserver = new Observer<MoviesBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MoviesBean bean) {
                List<MoviesBean.SubjectsBean> subjects = bean.getSubjects();
                theatersHolder.setData(subjects);
            }

        };


    }

    @Override
    public void initData() {
        L.v("init initData..");
        Observable<MoviesBean> observable = Retrofit2Utils.getServiceApi().getTheatersMoviesObservable("上海");

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mObserver);
    }


}
