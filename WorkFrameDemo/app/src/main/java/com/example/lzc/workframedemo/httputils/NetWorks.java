package com.example.lzc.workframedemo.httputils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 类描述：Retrofit网络加载
 * 创建人：zz
 * 创建时间： 2017/2/7 14:39
 */


public class NetWorks {
    private static NetWorks netWorks;
    private String BASE_URL = "http://app.vmoiver.com";//接口基地址
    private Retrofit retrofit;
    private static final long TIME_OUT = 30;           //网络超时时间
    private static Api api;

    public static NetWorks getInstance(){
        if(netWorks == null){
            netWorks = new NetWorks();
        }
        return netWorks;
    }

   private <T> T configRetrofit(Class<T> service,String baseUrl){
       retrofit = new Retrofit.Builder()
                                              .baseUrl(baseUrl)
                                              .client(clientConfig())
                                              .addConverterFactory(GsonConverterFactory.create(gsonBuilder()))
                                              .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                                              .build();
       return retrofit.create(service);
   }

    private OkHttpClient clientConfig(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        return builder.build();
    }

    public static Gson gsonBuilder(){
        return new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
                                 .registerTypeAdapter(Integer.class, new IntegerDefaultAdapter())
                                 .registerTypeAdapter(int.class, new IntegerDefaultAdapter())
                                  .create();
    }

    public  Api getApi(){
        return api == null ? configRetrofit(Api.class,BASE_URL):api;
    }

}
