package com.lj.douyin.douyintest.view;

import com.lj.douyin.douyintest.bean.FoundBanner;
import com.lj.douyin.douyintest.bean.FoundList;
import com.lj.douyin.douyintest.bean.SearchBean;

/**
 * Created by lenovo on 2018/2/22.
 */

public interface FoundView {

    void onSuccess(FoundBanner bunner);
    void onFailed(String 数据错误);
    void onUserSuccess(FoundList userBean);
    void onUserFailed(String 数据错误);
    void  onSearchSuccess(SearchBean searchBean);
    void  onSearchFailed(String 数据错误);
}
