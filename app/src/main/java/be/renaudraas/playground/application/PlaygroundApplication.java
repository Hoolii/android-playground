package be.renaudraas.playground.application;


import android.app.Application;
import android.content.Context;

public class PlaygroundApplication extends Application {

    private static PlaygroundApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        //Do some initialization
    }

    public static Context getContext() {
        return sInstance.getApplicationContext();
    }
}
