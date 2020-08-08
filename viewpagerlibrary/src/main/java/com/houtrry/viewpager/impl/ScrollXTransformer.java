package com.houtrry.viewpager.impl;

import androidx.viewpager.widget.ViewPager;
import android.view.View;

/**
 * @author: houtrry
 * @date: 2017/12/22 17:36
 * @version: $Rev$
 * @description: ${TODO}
 */

public class ScrollXTransformer implements ViewPager.PageTransformer {

    /**
     * MAX_SCROLL_X == 0 没有任何效果, ViewPager的默认切换
     * MAX_SCROLL_X == 1 一个移动, 另外一个完全不动的效果
     * MAX_SCROLL_X == 0 视差滑动
     */
    private float maxScrollX = 0.75f;

    public ScrollXTransformer() {
    }

    public ScrollXTransformer(float maxScrollX) {
        this.maxScrollX = maxScrollX;
    }

    @Override
    public void transformPage(View page, float position) {
        if (position < -1) {
            position = -1;
        } else if (position > 1) {
            position = 1;
        }
        page.setScrollX((int) (page.getWidth() * maxScrollX * position));

//        int width = page.getWidth();
//        //我们给不同状态的页面设置不同的效果
//        //通过position的值来分辨页面所处于的状态
//        if (position < -1) {//滑出的页面
//            page.setScrollX((int) (width * maxScrollX * -1));
//        } else if (position <= 1) {//[-1,1]
//            if (position < 0) {//[-1,0]
//                page.setScrollX((int) (width * maxScrollX * position));
//            } else {//[0,1]
//                page.setScrollX((int) (width * maxScrollX * position));
//            }
//        } else {//即将滑入的页面
//            page.setScrollX((int) (width * maxScrollX));
//        }
    }
}
