package com.lj.douyin.douyintest.utils;


import com.lj.douyin.douyintest.bean.FoundBanner;
import com.lj.douyin.douyintest.bean.FoundList;
import com.lj.douyin.douyintest.bean.SearchBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetiofitApi {
    @GET("aweme/v1/find/")
    Observable<FoundBanner> getlun(@Query("aid") String aid,
                                   @Query("retry_type") String retry_type,
                                   @Query("iid") String iid,
                                   @Query("device_id") String device_id);

     @GET("aweme/v1/category/list/")
     Observable<FoundList> getuser(@Query("cursor") int cursor, @Query("count") int count);

     @GET("aweme/v1/hot/search/?retry_type=no_retry&iid=23312994638&device_id=42386607829&ac=wifi&channel=update&aid=1128&app_name=aweme&version_code=170&version_name=1.7.0&device_platform=android&ssmix=a&device_type=Redmi+Note+4&device_brand=Xiaomi&language=zh&os_api=23&os_version=6.0&uuid=863411038560129&openudid=87f33cdff2475c29&manifest_version_code=170&resolution=1080*1920&dpi=480&update_version_code=1702&_rticket=1515815703961&ts=1515815705&as=a165e88579a16af3e9&cp=8713a753919b5f3fe1")
     Observable<SearchBean> getsearch();


}
