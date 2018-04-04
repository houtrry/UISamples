package com.het.nestedscorlllibrary.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.support.v4.view.NestedScrollingChild;

/**
 * @author: houtrry
 * @date: 2018/4/4 16:42
 * @version: $Rev$
 * @description: ${TODO}
 */

public class CustomNestedScrollingChild extends LinearLayout implements NestedScrollingChild {

    public CustomNestedScrollingChild(Context context) {
        this(context, null);
    }

    public CustomNestedScrollingChild(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomNestedScrollingChild(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }
}
