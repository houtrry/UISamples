package com.het.nestedscorlllibrary.component.widget;

import android.content.Context;
import android.support.v4.view.NestedScrollingParent;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @author: houtrry
 * @date: 2018/4/4 16:34
 * @version: $Rev$
 * @description: ${TODO}
 */

public class CustomNestedScrollingParent extends LinearLayout implements NestedScrollingParent {

    public CustomNestedScrollingParent(Context context) {
        this(context, null);
    }

    public CustomNestedScrollingParent(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomNestedScrollingParent(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }
}
