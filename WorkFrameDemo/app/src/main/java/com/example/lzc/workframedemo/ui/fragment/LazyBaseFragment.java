package com.example.lzc.workframedemo.ui.fragment;

/**
 * 类描述：Fragment懒加载
 * 创建人：zz
 * 创建时间： 2016/11/24 16:23
 */


public abstract class LazyBaseFragment extends BaseFragment{
    protected boolean isVisiable;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()){
            isVisiable = true;
            onVisiable();
        }else {
            isVisiable = false;
            onInVisiable();

        }
    }


    protected void onVisiable(){
        lazyLoad();
    }

    protected abstract void lazyLoad();

    protected void onInVisiable(){

    }
}
