package com.lj.douyin.douyintest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gyf.barlibrary.ImmersionBar;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lj.douyin.douyintest.adapter.FoundAdapter;
import com.lj.douyin.douyintest.bean.FoundBanner;
import com.lj.douyin.douyintest.bean.FoundList;
import com.lj.douyin.douyintest.bean.SearchBean;
import com.lj.douyin.douyintest.presenter.FoundPresenter;
import com.lj.douyin.douyintest.view.FoundView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements FoundView {

    @BindView(R.id.xrecycler)
    XRecyclerView xrc;
    private FoundPresenter presenter;
    private int cursor = 0;
    private int count = 5;
    private List<FoundBanner.BannerBean> ban = new ArrayList<>();
    private List<FoundList.CategoryListBean> list = new ArrayList<>();
    private List<SearchBean.DataBean> search = new ArrayList<>();
    private FoundAdapter myAdapter;
    private ImmersionBar mImmersionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().hide();//代码中  隐藏掉标题栏
        presenter = new FoundPresenter(this);
        presenter.getLunbo();
        presenter.getUser(cursor, count);
        presenter.getsearch();
        //设置可上拉
        xrc.setPullRefreshEnabled(true);
        xrc.setLoadingMoreEnabled(true);
        //设置上拉下拉样式
        xrc.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xrc.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);

        xrc.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                cursor++;
                count = count + 5;
                presenter.getUser(cursor, count);
                myAdapter.notifyDataSetChanged();
                xrc.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                // cursor++;
                count = count + 5;
                presenter.getUser(cursor, count);
                myAdapter.notifyDataSetChanged();
                xrc.loadMoreComplete();
            }
        });

        ImmersionBar.with(this).init();
    }

    @Override
    public void onSuccess(FoundBanner bunner) {
        List<FoundBanner.BannerBean> bannerBeans = bunner.getBanner();
        ban.addAll(bannerBeans);
    }

    @Override
    public void onFailed(String 数据错误) {

    }

    @Override
    public void onUserSuccess(FoundList userBean) {
        List<FoundList.CategoryListBean> category_list = userBean.getCategory_list();
        list.addAll(category_list);
        xrc.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        myAdapter = new FoundAdapter(MainActivity.this, ban, list,search);
        xrc.setAdapter(myAdapter);
    }

    @Override
    public void onUserFailed(String 数据错误) {

    }

    @Override
    public void onSearchSuccess(SearchBean searchBean) {
        List<SearchBean.DataBean> search2 = searchBean.getData();
        search.addAll(search2);

    }

    @Override
    public void onSearchFailed(String 数据错误) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mImmersionBar != null)
            mImmersionBar.destroy();  //必须调用该方法，防止内存泄漏，不调用该方法，如果界面bar发生改变，在不关闭app的情况下，退出此界面再进入将记忆最后一次bar改变的状态
    }

}
