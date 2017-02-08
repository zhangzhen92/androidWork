package com.example.lzc.workframedemo.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.lzc.workframedemo.R;
import com.example.lzc.workframedemo.ui.fragment.BaseFragment;
import com.example.lzc.workframedemo.ui.fragment.HomeFragment;
import com.example.lzc.workframedemo.ui.fragment.SecondFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：首页界面
 * 创建人：zz
 * 创建时间：2017/2/8 11:17
 */
public class MainActivity extends BaseActivity {

    private FrameLayout frameContainer;
    private List<BaseFragment> fragments = new ArrayList<>();
    private RadioButton[]  navigationBars;                      //导航菜单
    private RadioGroup radioGroupMenu;
    private int currentPosition = 0;                      //当前Fragment的记录

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();

    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        fragments.add(HomeFragment.newInstance());
        fragments.add(SecondFragment.newInstance());
        fragments.add(SecondFragment.newInstance());
        fragments.add(SecondFragment.newInstance());
        getSupportFragmentManager().beginTransaction().add(R.id.frame_container,fragments.get(0)).commit();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        frameContainer = ((FrameLayout) findViewById(R.id.frame_container));         //Fragment占位
        radioGroupMenu = ((RadioGroup) findViewById(R.id.radiogroup_menu));
        navigationBars = new RadioButton[radioGroupMenu.getChildCount()];
        for (int i = 0; i < radioGroupMenu.getChildCount(); i++) {
            navigationBars[i] = (RadioButton) radioGroupMenu.getChildAt(i);
        }
        navigationBars[0].setTextColor(Color.parseColor("#F12E24"));
        navigationBars[0].setChecked(true);
        radioGroupMenu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                for (int i = 0; i < navigationBars.length; i++) {
                    if (navigationBars[i].getId() == checkedId) {
                        //  拿到是第几个Button后   执行替换操作
                        replaceFragment(i);

                    }
                }
            }
        });


    }

    /**
     * 点击导航替换Fragment
     * @param targetPosition
     */
    private void replaceFragment(int targetPosition) {
        for (int i = 0; i < navigationBars.length; i++) {
            navigationBars[i].setTextColor(Color.parseColor("#505966"));
        }
        navigationBars[targetPosition].setTextColor(Color.parseColor("#F12E24"));
        navigationBars[targetPosition].setChecked(true);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        BaseFragment currentFramgnet = fragments.get(currentPosition);
        BaseFragment targetFragment  = fragments.get(targetPosition);
        if(!targetFragment.isAdded()){
            transaction.add(R.id.frame_container,targetFragment).hide(currentFramgnet).commit();
        }else {
            transaction.show(targetFragment).hide(currentFramgnet).commit();
        }
        currentPosition = targetPosition;
    }


    @Override
    protected boolean isSlideBack() {
        return false;
    }
}
