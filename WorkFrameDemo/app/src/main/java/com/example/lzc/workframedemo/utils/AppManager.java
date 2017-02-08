package com.example.lzc.workframedemo.utils;

import android.app.Activity;

import java.util.Stack;
/**
 * 类描述：Activity的管理器
 * 创建人：zz
 * 创建时间：2016/11/24 17:32
 */

public class AppManager {

    private static Stack<Activity> activityStack;
    private static AppManager instance;

    private AppManager() {}

    public static AppManager getAppManager() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }

    public Activity currentActivity() {
        Activity activity = null;
        try {
            if(!activityStack.isEmpty()){
                activity = activityStack.lastElement();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return activity;
    }

    public void finishActivity() {
        Activity activity = null;
        try {
            if(!activityStack.isEmpty()){
                activity = activityStack.lastElement();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        if(activity != null){
            finishActivity(activity);
        }
    }

    public void finishActivity(Activity activity) {
        try {
            if (activity != null && !activity.isFinishing()) {
                activityStack.remove(activity);
                activity.finish();
                activity = null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void removeActivity(Class<?> cls) {
        for (Activity instance : activityStack) {
            if (instance.getClass().equals(cls)) {
                activityStack.remove(instance);
                break;
            }
        }
    }

    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    public void finishAllActivity() {
        try {
            for (int i = 0, size = activityStack.size(); i < size; i++) {
                if (null != activityStack.get(0)) {
                    finishActivity(activityStack.get(0));
                }
            }
            activityStack.clear();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Activity getActivity(Class<?> cls) {
        if (activityStack != null)
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(cls)) {
                    return activity;
                }
            }
        return null;
    }

    public static int getStackSize(){
        return  activityStack.size();
    }

    public void AppExit() {
        try {
            finishAllActivity();
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(0);
        } catch (Exception e) {
        }
    }
}
