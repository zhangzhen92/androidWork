package com.example.lzc.workframedemo.ui.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.lzc.workframedemo.R;
import com.example.lzc.workframedemo.adapter.ViewPagerAdapter;
import com.example.lzc.workframedemo.utils.ViewPagerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 类描述：首页Fragment
 * 创建人：zz
 * 创建时间： 2017/2/8 11:22
 */


public class HomeFragment extends BaseFragment{
    private ViewPager viewPager;
    private LinearLayout linearDot;
    private ImageView imageSingle;
    private RelativeLayout relativeViewPager;
    private ViewPagerAdapter adapter;
    private Timer timer;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        timer = new Timer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_layout,null);
       initView(view);
        return view;
    }

    /**
     * 初始化View
     * @param view
     */
    private void initView(View view) {
        viewPager = ((ViewPager) view.findViewById(R.id.viewpager_id));
        linearDot = ((LinearLayout) view.findViewById(R.id.linear_dot));
        imageSingle = ((ImageView) view.findViewById(R.id.imageview_single));       //只有一张图片
        relativeViewPager = ((RelativeLayout) view.findViewById(R.id.relative_viewpager));
        adapter = new ViewPagerAdapter(new ArrayList<View>(),getActivity());
        viewPager.setAdapter(adapter);
        List<Integer> res = new ArrayList<>();
        res.add(R.drawable.ic_launcher);
        res.add(R.drawable.ic_launcher);
        res.add(R.drawable.ic_launcher);
        ViewPagerUtils.setViewPager(getActivity(),viewPager,linearDot,imageSingle,relativeViewPager,adapter,res);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
             getActivity().runOnUiThread(new Runnable() {
                 @Override
                 public void run() {
                     viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                 }
             });
            }
        };
        timer.schedule(task,2000,2000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }
}
