package com.example.lzc.workframedemo.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * 类描述：Toast工具类
 * 创建人：zz
 * 创建时间： 2016/11/24 16:47
 */


public class ToastUtils {
    private static Toast toast;
    private static long firstTimes = 0;
    private static long secondTimes = 0;
    private static String oldMsg;

    public static void showShortToast(Context context, int resId){
        showShortToast(context,context.getString(resId));
    }
    public static void showShortToast(Context context, String s) {
        if (toast == null) {
            toast = Toast.makeText(context, s, Toast.LENGTH_SHORT);
            toast.show();
            firstTimes = System.currentTimeMillis();
        } else {
            secondTimes = System.currentTimeMillis();
            if (s.equals(oldMsg)) {
                if (secondTimes - firstTimes > Toast.LENGTH_SHORT) {
                    toast.show();
                }
            } else {
                oldMsg = s;
                toast.setText(s);
                toast.show();
            }
        }
        firstTimes = secondTimes;
    }

}
