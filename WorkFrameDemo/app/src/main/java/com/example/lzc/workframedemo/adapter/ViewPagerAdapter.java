package com.example.lzc.workframedemo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * 类描述：ViewPager无限滚动适配器
 * 创建人：zz
 * 创建时间： 2017/2/8 12:03
 */


public class ViewPagerAdapter extends PagerAdapter{
    private List<View> views;
    private Context context;

    public ViewPagerAdapter(List<View> views, Context context) {
        this.views = views;
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(views.get(position % views.size()));
        return views.get(position % views.size());
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       // super.destroyItem(container, position, object);
        container.removeView(views.get(position % views.size()));
    }


    public void addAll(List<View> datas){
        views.addAll(datas);
        notifyDataSetChanged();
    }

    public void clear(){
        views.clear();
        notifyDataSetChanged();
    }

    public void deleteAll(){
        views.clear();
    }
}
