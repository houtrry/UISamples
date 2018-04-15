package com.het.basiclibrary.utils;

import android.util.Log;

/**
 * @author: houtrry
 * @time: 2018/4/15
 * @desc: ${TODO}
 */
public class LogUtils {

    private static boolean sShowLog = true;
    public static void d(String message) {
        if (sShowLog) {
            Log.d(Thread.currentThread().getName(), message);
        }
    }
}
