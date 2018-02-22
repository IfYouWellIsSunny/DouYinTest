package com.lj.douyin.douyintest.model;

import com.lj.douyin.douyintest.bean.FoundBanner;
import com.lj.douyin.douyintest.bean.FoundList;
import com.lj.douyin.douyintest.bean.SearchBean;
import com.lj.douyin.douyintest.presenter.IPre;
import com.lj.douyin.douyintest.utils.RetiofitApi;
import com.lj.douyin.douyintest.utils.RetrofitHelper;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2018/2/22.
 */

public class FoundModel {

       public void getLunbo(final IPre iPre){
        RetiofitApi retiofitApi = RetrofitHelper.getRetrofit("http://api.amemv.com/").create(RetiofitApi.class);
        retiofitApi.getlun("1128","no_retry","23028350734","42386607829")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FoundBanner>() {
                    @Override
                    public void accept(FoundBanner bunner) throws Exception {
                        if (bunner != null) {
                            iPre.onSuccess(bunner);
                        } else {
                            iPre.onFailed("数据错误");
                        }
                    }
                });
    }

    public void getUser(int cursor, int count,final IPre iPre){
        RetiofitApi retiofitApi = RetrofitHelper.getRetrofit("http://api.amemv.com/").create(RetiofitApi.class);
        retiofitApi.getuser(cursor,count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FoundList>() {
                    @Override
                    public void accept(FoundList userBean) throws Exception {
                        if (userBean != null) {
                            iPre.onUserSuccess(userBean);
                        } else {
                            iPre.onUserFailed("数据错误");
                        }
                    }
                });
    }

    public void getsearch(final IPre iPre){

        RetiofitApi retiofitApi = RetrofitHelper.getRetrofit("http://api.amemv.com/").create(RetiofitApi.class);
        retiofitApi.getsearch()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<SearchBean>() {
                    @Override
                    public void accept(SearchBean searchBean) throws Exception {
                        if (searchBean != null) {
                            iPre.onSearchSuccess(searchBean);
                        } else {
                            iPre.onSearchFailed("数据错误");
                        }

                    }
                });


    }


}
