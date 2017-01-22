package be.renaudraas.playground.util.rx;

import rx.Subscriber;

/**
 * An {@link Subscriber} that always informs when it's ended.
 */
public abstract class SubscriberAdapter<T> extends Subscriber<T> {

    @Override
    public void onNext(T t) {
    }

    @Override
    public void onCompleted() {
        onTerminated(true);
    }

    @Override
    public void onError(Throwable throwable) {
        onTerminated(false);
    }

    /**
     * Called whenever {@link #onCompleted()} is called or {@link #onError(Throwable)}
     */
    public void onTerminated(boolean isSuccess) {

    }
}
