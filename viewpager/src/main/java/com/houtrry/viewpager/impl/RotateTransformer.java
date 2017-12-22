package com.houtrry.viewpager.impl;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * @author: houtrry
 * @date: 2017/12/22 16:27
 * @version: $Rev$
 * @description: ${TODO}
 */

public class RotateTransformer implements ViewPager.PageTransformer {

    @Override
    public void transformPage(View page, float position) {
        if (position <= -1) {
            rotate(page, 0);
        } else if (position >= 1) {
            rotate(page, 0);
        } else {
            System.out.println("---->"+60*position);
            rotate(page, 60*position);
        }
    }

    private void rotate(View view, float degree) {
        view.setRotation(degree);
    }
}
