package com.lj.douyin.douyintest.presenter;


import com.lj.douyin.douyintest.bean.FoundBanner;
import com.lj.douyin.douyintest.bean.FoundList;
import com.lj.douyin.douyintest.bean.SearchBean;
import com.lj.douyin.douyintest.model.FoundModel;
import com.lj.douyin.douyintest.view.FoundView;

/**
 * Created by lenovo on 2018/2/22.
 */

public class FoundPresenter implements IPre {
    private FoundView iView;
    private FoundModel model;

    public FoundPresenter(FoundView iView) {
        this.iView = iView;
        model=new FoundModel();
    }

    public void getLunbo(){
        model.getLunbo(this);
    }


    public void  getUser(int cursor, int count){
        model.getUser(cursor,count,this);
    }

    public  void  getsearch(){
        model.getsearch(this);

    }


    @Override
    public void onSuccess(FoundBanner bunner) {
        iView.onSuccess(bunner);
    }

    @Override
    public void onFailed(String 数据错误) {
        iView.onFailed(数据错误);
    }

    @Override
    public void onUserSuccess(FoundList userBean) {
        iView.onUserSuccess(userBean);
    }

    @Override
    public void onUserFailed(String 数据错误) {
        iView.onUserFailed(数据错误);
    }

    @Override
    public void onSearchSuccess(SearchBean searchBean) {

           iView.onSearchSuccess(searchBean);
        System.out.println("searchBean = " + searchBean);
    }

    @Override
    public void onSearchFailed(String 数据错误) {

        iView.onSearchFailed(数据错误);
    }

}
