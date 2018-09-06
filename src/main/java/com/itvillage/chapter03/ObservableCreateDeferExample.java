package com.itvillage.chapter03;

import io.reactivex.Observable;

public class ObservableCreateDeferExample {
    public static void main(String[] args) throws InterruptedException {
        // 실제 구독이 발생할 때 Observable이 새로 생성됨.
        Observable<Long> observable = Observable.defer(() -> {
            long time = System.currentTimeMillis();
            return Observable.just(time);
        });

        observable.subscribe(time -> System.out.println(time));

        Thread.sleep(3000);

        observable.subscribe(time -> System.out.println(time));
    }
}