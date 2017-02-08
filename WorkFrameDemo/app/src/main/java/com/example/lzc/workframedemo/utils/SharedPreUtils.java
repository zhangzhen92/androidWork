package com.example.lzc.workframedemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * 类描述：共享参数工具类
 * 创建人：zz
 * 创建时间： 2016/11/24 16:47
 */


public class SharedPreUtils {

    private static SharedPreUtils instance;

    private static final String APP_SHAREDPRE = "SHARED_APPLICATION";

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    /**
     * 获取单例对象
     * @param context
     * @return
     */
    public synchronized static SharedPreUtils getInstance(Context context){
        if(null == instance){
            instance = new SharedPreUtils(context);
        }
        return instance;
    }


    public SharedPreUtils(Context context) {
        sharedPreferences = context.getSharedPreferences(APP_SHAREDPRE, Activity.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    public static void saveName(String name){
        editor.putString("name",name).commit();
    }

    public static String getName(){
        return sharedPreferences.getString("name",null);
    }


}
