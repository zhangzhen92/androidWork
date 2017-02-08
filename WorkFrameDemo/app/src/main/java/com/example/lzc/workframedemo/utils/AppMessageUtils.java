package com.example.lzc.workframedemo.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * 类描述：当前应用的信息
 * 创建人：zz
 * 创建时间： 2016/11/24 16:48
 */


public class AppMessageUtils {


    /**
     * 获取版本号
     * @param context
     * @return
     */
    public static String getVersionCode(Context context){
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            String version = info.versionName;
            return  version;
        } catch (Exception e) {
            e.printStackTrace();
            return "获取不到版本";
        }
    }


    /**
     * 获取包名
     * @param context
     * @return
     */
    public String getPackageName(Context context) {
        String packageName = context.getPackageName();
        return packageName;
    }
}
