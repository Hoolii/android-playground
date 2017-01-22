package be.renaudraas.playground.util;

import android.util.Log;

import be.renaudraas.playground.BuildConfig;

public class DebugLog {

    private static final String TAG = "PLAYGROUND";
    private static final boolean IS_DEBUG = BuildConfig.DEBUG;

    private DebugLog() {
    }

    public static void d(String message) {
        if (IS_DEBUG) {
            Log.d(TAG, message);
        }
    }

    public static void i(String message) {
        if (IS_DEBUG) {
            Log.i(TAG, message);
        }
    }

    public static void e(String message) {
        if (IS_DEBUG) {
            Log.e(TAG, message);
        }
    }

    public static void w(String message) {
        if (IS_DEBUG) {
            Log.w(TAG, message);
        }
    }
}