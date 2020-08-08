package com.houtrry.viewpager.impl;

import androidx.viewpager.widget.ViewPager;
import android.view.View;

import com.houtrry.viewpager.utils.LogUtils;

/**
 * @author: houtrry
 * @date: 2017/12/22 17:23
 * @version: $Rev$
 * @description: 这个有问题
 */

public class ScaleTransformer implements ViewPager.PageTransformer {

    private static final float MAX_SCALE  = 0.75f;

    @Override
    public void transformPage(View page, float position) {


        LogUtils.e("===>>>page.getClass:  "+page.getClass());

        float scaleX = 0;
        if (position >= 1 || position <= -1) {
            scaleX = MAX_SCALE;
        } else {
            scaleX = 1 - (1 - MAX_SCALE) * Math.abs(position);
        }
        page.setScaleX(scaleX);
        page.setScaleY(scaleX);
        page.setAlpha(scaleX);
    }
}
