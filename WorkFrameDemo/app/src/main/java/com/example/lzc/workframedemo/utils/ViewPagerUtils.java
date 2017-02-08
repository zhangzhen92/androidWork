package com.example.lzc.workframedemo.utils;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lzc.workframedemo.R;
import com.example.lzc.workframedemo.adapter.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：ViewPager放置图片
 * 创建人：zz
 * 创建时间： 2017/2/8 12:09
 */


public class ViewPagerUtils {
    private static int perPosition = 0;
    private static int dotTotal = 0;
    private static List<View> views = new ArrayList<>();
    public static void setViewPager(Context context, ViewPager viewPager, LinearLayout linearDot, ImageView imageViewSingle, RelativeLayout relativeViewPager, ViewPagerAdapter viewPagerAdapter, List<Integer> res){
       if(1 == res.size()){
           //只有一张图片资源时显示
           imageViewSingle.setVisibility(View.VISIBLE);
           relativeViewPager.setVisibility(View.GONE);
           imageViewSingle.setImageResource(res.get(0));
       }else {
           dotTotal = res.size();
           imageViewSingle.setVisibility(View.GONE);
           relativeViewPager.setVisibility(View.VISIBLE);
           if(2 == res.size() || 3 == res.size()){                         //当资源为两张或者三张时，自动扩充一倍，否则异常
               res.addAll(res);
           }
           for (int i = 0; i < res.size(); i++) {
             ImageView imageView = new ImageView(context);
             imageView.setImageResource(res.get(i));
             views.add(imageView);
           }
           for (int i = 0; i < dotTotal; i++) {
               TextView dot = new TextView(context);
               int width = DensityUtils.dip2px(context,6);
               int marginLeft = DensityUtils.dip2px(context,8);
               LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(width,width);
               lp.setMargins(marginLeft,0,0,0);
               dot.setBackgroundResource(R.drawable.dot_selector);
               dot.setEnabled(false);
               dot.setLayoutParams(lp);
               dot.setEnabled(false);
               linearDot.addView(dot);
           }
           viewPagerAdapter.addAll(views);
           viewPager.setCurrentItem(0+res.size()*10000);   //将ViewPager当前位置放置在第一张，并且足够大
           linearDot.getChildAt(0).setEnabled(true);

       }


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                linearDot.getChildAt(perPosition).setEnabled(false);
                linearDot.getChildAt(position % dotTotal).setEnabled(true);
                perPosition = position %dotTotal;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
