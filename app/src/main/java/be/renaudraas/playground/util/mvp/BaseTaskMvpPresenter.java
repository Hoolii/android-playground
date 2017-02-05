package be.renaudraas.playground.util.mvp;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BaseTaskMvpPresenter<V extends MvpView> extends MvpNullObjectBasePresenter<V> {


    protected Executor getExecutor() {
        int numCores = Runtime.getRuntime().availableProcessors();
        return new ThreadPoolExecutor(numCores * 2, numCores * 2,
                60L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
    }

}