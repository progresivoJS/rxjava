package com.itvillage.chapter07;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class SchedulerSingleExample {
    public static void main(String[] args) {
        Observable<String> observable = Observable.just("1", "2", "3", "4", "5");

        observable.subscribeOn(Schedulers.single())
                .map(data -> "## " + data + " ##")
                .subscribe(Logger::on);

        observable.subscribeOn(Schedulers.single())
                .map(data -> "$$ " + data + " $$")
                .subscribe(Logger::on);

        TimeUtil.sleep(300L);
    }
}