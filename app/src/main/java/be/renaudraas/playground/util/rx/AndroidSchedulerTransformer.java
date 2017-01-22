package be.renaudraas.playground.util.rx;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class AndroidSchedulerTransformer<T> implements Observable.Transformer<T, T> {

    public AndroidSchedulerTransformer() {
    }

    public Observable<T> call(Observable<T> observable) {
        return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}