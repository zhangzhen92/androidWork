package com.example.lzc.workframedemo.httputils;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 类描述：Rxjava线程切换
 * 创建人：zz
 * 创建时间： 2017/2/7 14:36
 */
public class RxSchedulers {

    /**
     * {@link rx.Observable.Transformer} that transforms the source observable to subscribe in the
     * io thread and observe on the Android's UI thread.
     */
    private static Observable.Transformer ioToMainThreadSchedulerTransformer;


    static {
        ioToMainThreadSchedulerTransformer = createIOToMainThreadScheduler();
    }


    /**
     * Get {@link rx.Observable.Transformer} that transforms the source observable
     * to subscribe in
     * the io thread and observe on the Android's UI thread.
     * <p>
     * Because it doesn't interact with
     * the emitted items it's safe ignore the unchecked casts.
     *
     * @return {@link rx.Observable.Transformer}
     */
    @SuppressWarnings("unchecked")
    private static <T> Observable.Transformer<T, T> createIOToMainThreadScheduler() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }


    @SuppressWarnings("unchecked")
    public static <T> Observable.Transformer<T, T> applyIOToMainThreadSchedulers() {
        return ioToMainThreadSchedulerTransformer;
    }
}
