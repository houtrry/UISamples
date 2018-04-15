package com.het.basiclibrary.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * @author: houtrry
 * @time: 2018/4/15
 * @desc: ${TODO}
 */
public class ToastUtils {

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
