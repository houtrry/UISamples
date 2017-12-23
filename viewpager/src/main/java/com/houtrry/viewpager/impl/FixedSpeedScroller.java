package com.houtrry.viewpager.impl;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * @author: houtrry
 * @date: 2017/12/23 15:11
 * @version: $Rev$
 * @description: ${TODO}
 */

public class FixedSpeedScroller extends Scroller {

    private int mSlideDuration = 1500;

    public FixedSpeedScroller(Context context) {
        super(context);
    }

    public FixedSpeedScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        // Ignore received duration, use fixed one instead
        //关键点在这里, 通过写死startScroll的duration参数, 达到修改动画时长的目的
        System.out.println("------->mSlideDuration: "+mSlideDuration+", duration: "+duration);
        //------->mSlideDuration: 500, duration: 200
        super.startScroll(startX, startY, dx, dy, mSlideDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mSlideDuration);
    }

    public void setSlideDuration(int time) {
        mSlideDuration = time;
    }

    public int getSlideDuration() {
        return mSlideDuration;
    }
}