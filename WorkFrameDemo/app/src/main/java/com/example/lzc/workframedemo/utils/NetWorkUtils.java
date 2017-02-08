package com.example.lzc.workframedemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

/**
 * 类描述：网络状态的判断
 * 创建人：zz
 * 创建时间： 2016/11/24 17:29
 */


public class NetWorkUtils {

    public static boolean isNetworkOk(Context inContext){
        try{
            Context context = inContext.getApplicationContext();
            ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity != null){
                android.net.NetworkInfo wifiNetworkInfo = connectivity.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
                if(wifiNetworkInfo != null){
                    android.net.NetworkInfo.State wifi = wifiNetworkInfo.getState();
                    if (wifi == android.net.NetworkInfo.State.CONNECTED
                            || wifi == android.net.NetworkInfo.State.CONNECTING){
                        return true;
                    }
                }

                android.net.NetworkInfo mobileNetworkInfo =  connectivity.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                if(mobileNetworkInfo != null){
                    android.net.NetworkInfo.State mobile = mobileNetworkInfo.getState();
                    if (mobile == android.net.NetworkInfo.State.CONNECTED
                            || mobile == android.net.NetworkInfo.State.CONNECTING){

                        return true;
                    }
                }
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    /**
     * 判断是否是wifi状态
     * @param mContext
     * @return
     */
    public static boolean isWifi(Context mContext) {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetInfo != null
                && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI) {
            return true;
        }
        return false;
    }

    /**
     * 获得本地的IP
     * @param context
     * @return
     * @throws Exception
     */
    public static String getLocalIpStr(Context context) throws Exception{
        WifiManager wifiManager=(WifiManager)context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        return intToIpAddr(wifiInfo.getIpAddress());
    }

    public static String intToIpAddr(int ip) throws Exception{
        return (ip & 0xff) + "." + ((ip>>8)&0xff) + "." + ((ip>>16)&0xff) + "." + ((ip>>24)&0xff);
    }

}
