package com.example.lzc.workframedemo.httputils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * 类描述：接口地址
 * 创建人：zz
 * 创建时间： 2017/2/7 15:01
 */


public interface Api {

    /**
     * 测试使用
     */
    //retrofit 获取数据
    @GET(value = "/apiv3/post/getPostByTab")
    Call<ResponseBody> getData();

    @GET(value = "/apiv3/post/getPostByTab")
    Observable<ResponseBody> getRxData();
}
