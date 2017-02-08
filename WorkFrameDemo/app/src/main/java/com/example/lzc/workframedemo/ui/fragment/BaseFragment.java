package com.example.lzc.workframedemo.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类描述：Fragment 基类
 * 创建人：zz
 * 创建时间： 2016/11/24 16:22
 */


public class BaseFragment extends Fragment{

    @Override
    public void onAttach(Context context) {
        Log.i("123321","====OnAttach=====");
        super.onAttach(context);
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        Log.i("123321","====onCreate=====");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        Log.i("123321","====onCreateView=====");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onResume() {
        Log.i("123321","====onResume=====");
        super.onResume();
    }

    @Override
    public void onStart() {
        Log.i("123321","====onStart=====");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.i("123321","====onStop=====");
        super.onStop();
    }

    @Override
    public void onPause() {
        Log.i("123321","====onPause=====");
        super.onPause();
    }

    @Override
    public void onDestroy() {
        Log.i("123321","====onDestroy=====");
        super.onDestroy();
    }

    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        Log.i("123321","====onActivityCreated=====");
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        Log.i("123321","====onDestroyView=====");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.i("123321","====onDetach=====");
        super.onDetach();
    }
}
