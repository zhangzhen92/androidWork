package com.example.lzc.workframedemo.httputils;


import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * 类描述：Glide加载图片
 * 创建人：zz
 * 创建时间：2017/2/7 15:28
 */
public class ImageLoader {
    
    private static boolean checkContext(Context context){
        if(context != null){
            if(context instanceof Activity){
                Activity  a = (Activity) context;
                if(!a.isFinishing()){
                    return true;
                }
            }else {
                return true;
            }
        }
        return false;
    }

    public static void show(Context context,String path,int placeholderId,int errorId,ImageView view,boolean isGif){
        if(checkContext(context) && !TextUtils.isEmpty(path) ) {
            if (isGif) {
                Glide.with(context).load(path).asGif().placeholder(placeholderId).error(errorId).centerCrop().fitCenter().dontAnimate().into(view);
            } else {
                Glide.with(context).load(path).placeholder(placeholderId).error(errorId).centerCrop().dontAnimate().into(view);
            }
        }
    }


    public static void show(Context context, Uri uri, int placeholderId, int errorId, ImageView view,boolean isGif){
        if(checkContext(context) && uri!=null ) {
            if (isGif) {
                Glide.with(context).load(uri).asGif().placeholder(placeholderId).error(errorId).centerCrop().fitCenter().dontAnimate().into(view);
            } else {
                Glide.with(context).load(uri).placeholder(placeholderId).error(errorId).centerCrop().dontAnimate().into(view);
            }
        }
    }


    public static void show(Context context, File file, int placeholderId, int errorId, ImageView view,boolean isGif){
        if(checkContext(context) && file!=null ) {
            if (isGif) {
                Glide.with(context).load(file).asGif().placeholder(placeholderId).error(errorId).centerCrop().fitCenter().dontAnimate().into(view);
            } else {
                Glide.with(context).load(file).placeholder(placeholderId).error(errorId).centerCrop().dontAnimate().into(view);
            }
        }
    }


    public static void show(Context context, int imageId, int placeholderId, int errorId, ImageView view,boolean isGif){
        if(checkContext(context) ) {
            if (isGif) {
                Glide.with(context).load(imageId).asGif().placeholder(placeholderId).error(errorId).centerCrop().fitCenter().dontAnimate().into(view);
            } else {
                Glide.with(context).load(imageId).placeholder(placeholderId).error(errorId).centerCrop().dontAnimate().into(view);
            }
        }
    }



    public static void show(Context context,String path,int placeHolder,boolean isGif,ImageView imageView){
       if(context != null){
          if(isGif){
              Glide.with(context).load(path).into(imageView);
          }
       }
    }

    public static void show(Context context,String path,ImageView view,boolean isGif){
        if(checkContext(context) && !TextUtils.isEmpty(path) ) {
            if (isGif) {
                Glide.with(context).load(path).asGif().centerCrop().fitCenter().dontAnimate().into(view);
            } else {
                Glide.with(context).load(path).centerCrop().dontAnimate().into(view);
            }
        }
    }


    public static void show(Context context, Uri uri,ImageView view,boolean isGif){
        if(checkContext(context) && uri!=null ) {
            if (isGif) {
                Glide.with(context).load(uri).asGif().centerCrop().fitCenter().dontAnimate().into(view);
            } else {
                Glide.with(context).load(uri).centerCrop().dontAnimate().into(view);
            }
        }
    }


    public static void show(Context context, File file, ImageView view,boolean isGif){
        if(checkContext(context) && file!=null ) {
            if (isGif) {
                Glide.with(context).load(file).asGif().centerCrop().fitCenter().dontAnimate().into(view);
            } else {
                Glide.with(context).load(file).centerCrop().dontAnimate().into(view);
            }
        }
    }


    public static void show(Context context, int imageId, ImageView view,boolean isGif){
        if(checkContext(context)) {
            if (isGif) {
                Glide.with(context).load(imageId).asGif().centerCrop().fitCenter().dontAnimate().into(view);
            } else {
                Glide.with(context).load(imageId).centerCrop().dontAnimate().into(view);
            }
        }
    }

}
