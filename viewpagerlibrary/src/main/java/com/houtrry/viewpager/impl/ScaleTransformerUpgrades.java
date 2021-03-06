package com.houtrry.viewpager.impl;

import androidx.viewpager.widget.ViewPager;
import android.view.View;

/**
 * @author: houtrry
 * @date: 2017/12/22 17:23
 * @version: $Rev$
 * @description: 这个有问题
 */

public class ScaleTransformerUpgrades implements ViewPager.PageTransformer {

    private static final float MAX_SCALE = 0.75f;

    @Override
    public void transformPage(View page, float position) {

        float scaleX = 0;
        if (position >= 1 || position <= -1) {
            scaleX = MAX_SCALE;
        } else {
            scaleX = 1 - (1 - MAX_SCALE) * Math.abs(position);
        }
        page.setScaleX(scaleX);
        page.setScaleY(scaleX);
        page.setAlpha(scaleX);


        float rotateY = 0;
        if (position < -1) {
            rotateY = -1;
        } else if (position > 1) {
            rotateY = 1;
        } else {
            rotateY = position;
        }
        page.setPivotX(0.5f * page.getMeasuredWidth());
        page.setPivotY(0.5f * page.getMeasuredHeight());
        page.setRotationY(rotateY * 15 * -1);

//
//        if (page instanceof RotateY3DRelativeLayout) {
//            ((RotateY3DRelativeLayout)page).setProgress(rotateY);
//        }
    }
}
