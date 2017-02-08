package com.example.lzc.workframedemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 类描述：适配器基类
 * 创建人：zz
 * 创建时间： 2016/11/24 16:40
 */


public abstract class MyBaseAdapter<T> extends BaseAdapter{
    private List<T> datas;
    private LayoutInflater inflater;

    public MyBaseAdapter(List<T> datas, Context context) {
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }

    public LayoutInflater getInflater() {
        return inflater;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public T getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItemView(position,convertView,parent);
    }

    /**
     * 添加数据源
     * @param dd
     */
    public void addAll(List<T> dd){
        datas.addAll(dd);
        notifyDataSetChanged();
    }

    /**
     * 清空数据源
     */
    public void clear(){
        datas.clear();
        notifyDataSetChanged();
    }

    /**
     * 删除指定位置的条目
     * @param position
     */
    public void deleteItem(int position){
        datas.remove(position);
        notifyDataSetChanged();
    }

    /**
     * 指定位置添加条目
     * @param position
     * @param dd
     */
    public void addItem(int position,T dd){
        datas.add(position,dd);
        notifyDataSetChanged();
    }



    public abstract View getItemView(int position, View convertView, ViewGroup parent);
}
