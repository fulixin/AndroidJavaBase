package com.fu.rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fulixin on 2017/8/29.
 */

public class Test {
    public void main() {
        System.out.println("==================");
        DisposableObserver<String> disposa=new DisposableObserver<String>() {
            @Override
            public void onNext(String value) {
                System.out.println(value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("结束");
            }
        };
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                System.out.println("==++++++++====");
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500); //模拟下载的操作。
                    } catch (InterruptedException exception) {
                        if (!e.isDisposed()) {
                            e.onError(exception);
                        }
                    }
                    e.onNext(i + "");
                }
                e.onComplete();
            }
        }).subscribeOn(Schedulers.newThread()).observeOn(Schedulers.io()).subscribe(disposa);
        new CompositeDisposable().add(disposa);
    }
}
