package com.het.basiclibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author: houtrry
 * @date: 2017/12/29 11:16
 * @version: $Rev$
 * @description: ${TODO}
 */

public class ActivityUtils {

    private ActivityUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void startAty(@NonNull Context context, @NonNull Class<? extends Activity> cls) {
        startAty(context, cls, null);
    }

    public static void startAty(@NonNull Context context, @NonNull Class<? extends Activity> cls, @Nullable Bundle bundle) {
        final Intent intent = new Intent(context, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }
}
