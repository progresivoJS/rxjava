package com.itvillage.chapter03.chapter0303;

import com.itvillage.utils.DateUtil;
import com.itvillage.utils.Logger;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.disposables.Disposable;

public class MaybeCreateExample {
    public static void main(String[] args){
        Maybe<String> maybe = Maybe.create(new MaybeOnSubscribe<String>() {
            @Override
            public void subscribe(MaybeEmitter<String> emitter) throws Exception {
                emitter.onSuccess(DateUtil.getNowDate());
                // TODO 데이터를 통지하지 않고, 종료할 때의 설명 필요
//                emitter.onComplete();
            }
        });

        maybe.subscribe(new MaybeObserver<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                // 아무것도 하지 않음.
            }

            @Override
            public void onSuccess(String data) {
                Logger.osc("# 현재 날짜시각: " + data);
            }

            @Override
            public void onError(Throwable error) {
                Logger.oe(error);
            }

            @Override
            public void onComplete() {
                Logger.oc();
            }
        });
    }
}