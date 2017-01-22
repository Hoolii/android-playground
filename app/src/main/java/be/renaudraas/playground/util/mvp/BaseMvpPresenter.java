package be.renaudraas.playground.util.mvp;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import be.renaudraas.playground.util.rx.AndroidSchedulerTransformer;
import be.renaudraas.playground.util.rx.SubscriberAdapter;
import rx.Observable;
import rx.Subscriber;

public abstract class BaseMvpPresenter<V extends MvpView, M> extends MvpNullObjectBasePresenter<V> {

    private Subscriber<M> subscriber;
    private Observable.Transformer<? super M, ? extends M> scheduler;

    public BaseMvpPresenter() {
        this.scheduler = new AndroidSchedulerTransformer<M>();
    }

    protected void unSubscribe() {
        if (subscriber != null && !subscriber.isUnsubscribed()) {
            subscriber.unsubscribe();
        }

        subscriber = null;
    }

    protected boolean isSubscribed() {
        return subscriber != null && !subscriber.isUnsubscribed();
    }

    /**
     * Subscribes the presenter himself as subscriber on the observable
     *
     * @param observable The observable to subscribe
     */
    public void subscribe(Observable<M> observable) {

        unSubscribe();

        subscriber = new SubscriberAdapter<M>() {
            @Override
            public void onCompleted() {
                BaseMvpPresenter.this.onCompleted();
            }

            @Override
            public void onError(Throwable e) {
                BaseMvpPresenter.this.onError(e);
            }

            @Override
            public void onNext(M m) {
                BaseMvpPresenter.this.onNext(m);
            }

            @Override
            public void onTerminated(boolean isSuccess) {
                BaseMvpPresenter.this.onTerminated(isSuccess);
                unsubscribe();
            }
        };

        observable = applyScheduler(observable);
        observable.subscribe(subscriber);
    }

    public void cancel() {
        unSubscribe();
    }

    /**
     * Called in {@link #subscribe(Observable)} to set  <code>subscribeOn()</code> and
     * <code>observeOn()</code>. As default it uses {@link AndroidSchedulerTransformer}. Override
     * this
     * method if you want to provide your own scheduling implementation.
     */
    protected Observable<M> applyScheduler(Observable<M> observable) {
        return observable.compose(this.scheduler);
    }

    protected abstract void onNext(M data);

    protected abstract void onError(Throwable e);

    protected abstract void onCompleted();

    protected void onTerminated(boolean isSuccess) {

    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if (!retainInstance) {
            unSubscribe();
        }
    }
}
