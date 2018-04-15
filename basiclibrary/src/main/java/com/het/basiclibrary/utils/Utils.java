package com.het.basiclibrary.utils;

import android.os.Looper;

/**
 * @author: houtrry
 * @time: 2018/4/15
 * @desc: ${TODO}
 */
public class Utils {

    /**
     * 判断是否是在主线程
     * @return
     */
    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /**
     * 判断是否是在子线程
     * @return
     */
    public static boolean isBackgroundThread() {
        return !isMainThread();
    }
}
