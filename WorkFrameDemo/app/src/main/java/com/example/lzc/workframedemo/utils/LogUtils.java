package com.example.lzc.workframedemo.utils;

import android.util.Log;

import com.example.lzc.workframedemo.config.FrameConfig;

/**
 * 类描述：日志打印
 * 创建人：zz
 * 创建时间： 2016/11/24 16:47
 */


public class LogUtils {

    //Log日志的Tag
    private static String TAG = "DEBUG";

    public static void LogE(String msg){
        if(FrameConfig.LOG_ON){
            if(!"".equals(msg)){
                Log.e(TAG,msg==null?"参数为空":msg);
            }else {
                Log.e(TAG,"参数无值");
            }
        }
    }
    public static  void LogE(int in){
        if(FrameConfig.LOG_ON){
            Log.e(TAG,"int"+in);
        }
    }

    public static void LogI(String msg){
        if(FrameConfig.LOG_ON){
            if(!"".equals(msg)){
                Log.i(TAG,msg==null?"参数为空":msg);
            }else {
                Log.i(TAG,"参数无值");
            }
        }
    }
    public static void LogI(int in){
        if (FrameConfig.LOG_ON){
            Log.i(TAG,"int"+in);
        }
    }



}
