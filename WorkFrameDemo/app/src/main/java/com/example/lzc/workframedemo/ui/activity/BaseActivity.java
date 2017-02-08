package com.example.lzc.workframedemo.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.example.lzc.workframedemo.R;
import com.example.lzc.workframedemo.utils.AppManager;
import com.jude.swipbackhelper.SwipeBackHelper;

/**
 * 类描述：Activity基类
 * 创建人：zz
 * 创建时间： 2016/11/24 16:21
 */


public abstract class BaseActivity extends FragmentActivity {
    private View view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        if(isSlideBack()){
            slideBackSetting();
        }

    }

  public void slideBackSetting(){
      //TODO  左划销毁Activity，防微信
      SwipeBackHelper.onCreate(this);
      SwipeBackHelper.getCurrentPage(this)//get current instance
              .setSwipeBackEnable(true)//on-off
//             .setSwipeEdge(DensityUtils.dip2px(this, 20))//set the touch area。10 mean only the left 10dp of screen can touch to begin swipe.
              .setSwipeEdgePercent(0.2f)//0.2 mean left 20% of screen can touch to begin swipe.
              .setSwipeSensitivity(0.7f)//sensitiveness of the gesture。0:slow  1:sensitive
//            .setScrimColor(Color.BLUE)//color of Scrim below the activity
              .setClosePercent(0.3f)//close activity when swipe over this
              .setSwipeRelateEnable(true)//if should move together with the following Activity
              .setSwipeRelateOffset(500)//the Offset of following Activity when setSwipeRelateEnable(true)
              .setDisallowInterceptTouchEvent(false);//your view can hand the events first.default false;
  }



    protected boolean isSlideBack(){
        return true;
    }


    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.right_to_left_enter,R.anim.right_to_left_exit);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.left_to_right_enter,R.anim.left_to_right_exit);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if(isSlideBack()){
            SwipeBackHelper.onPostCreate(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isSlideBack()){
            SwipeBackHelper.onDestroy(this);
        }
        AppManager.getAppManager().removeActivity(this.getClass());
    }

}
