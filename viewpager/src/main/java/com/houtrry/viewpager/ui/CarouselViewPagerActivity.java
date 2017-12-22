package com.houtrry.viewpager.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.houtrry.viewpager.R;
import com.houtrry.viewpager.adapter.CarouselViewPagerAdapter;
import com.houtrry.viewpager.bean.ViewPagerBean;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: houtrry
 * @date: ${DATE} ${TIME}
 * @version:
 * @description: 实现无限轮播的ViewPager
 */
public class CarouselViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<ViewPagerBean> mViewPagerBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carousel_view_pager);
        setTitle("实现无限轮播的ViewPager");
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void initData() {

        mCarouselHandler = new CarouselHandler(this);

        int[] imageIds = {R.drawable.img0, R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
        String[] descs = {"狗狗" + 0, "狗狗" + 1, "狗狗" + 2, "狗狗" + 3, "狗狗" + 4};
        mViewPagerBeans = new ArrayList<>();

        for (int i = 0; i < imageIds.length; i++) {
            mViewPagerBeans.add(new ViewPagerBean(imageIds[i], descs[i]));
        }

        initViewPager();

        startCarousel(DEFAULT_CAROUSEL_CYCLE);
    }

    private void initViewPager() {
        CarouselViewPagerAdapter viewPagerAdapter = new CarouselViewPagerAdapter(mViewPagerBeans);


        mViewPager.setAdapter(viewPagerAdapter);

        mViewPager.setCurrentItem(Integer.MAX_VALUE / 2 - (Integer.MAX_VALUE / 2) % mViewPagerBeans.size());
    }

    private void initEvent() {
        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int eventAction = event.getAction();
                if (eventAction == MotionEvent.ACTION_DOWN) {
                    stopCarousel();
                } else if (eventAction == MotionEvent.ACTION_UP) {
                    startCarousel(DEFAULT_CAROUSEL_CYCLE);
                }
                return false;
            }
        });
    }

    private void startCarousel(long delayTime) {
        if (mCarouselHandler != null) {
            mCarouselHandler.sendEmptyMessageDelayed(CarouselHandler.INFINITE_CAROUSEL, delayTime);
        }
    }

    private void stopCarousel() {
        if (mCarouselHandler != null) {
            mCarouselHandler.removeCallbacksAndMessages(null);
        }
    }

    private void handleCarousel() {
        if (mCarouselHandler != null) {
            int currentItem = mViewPager.getCurrentItem();
            mViewPager.setCurrentItem(currentItem + 1);
            mCarouselHandler.sendEmptyMessageDelayed(CarouselHandler.INFINITE_CAROUSEL, DEFAULT_CAROUSEL_CYCLE);
        }
    }

    private CarouselHandler mCarouselHandler;
    private static final int DEFAULT_CAROUSEL_CYCLE = 2000;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCarouselHandler != null) {
            mCarouselHandler.destroy();
        }
    }

    private static class CarouselHandler extends Handler {

        private static final int INFINITE_CAROUSEL = 0x0010;
        private WeakReference<CarouselViewPagerActivity> mActivityWeakReference;

        public CarouselHandler(CarouselViewPagerActivity activity) {
            mActivityWeakReference = new WeakReference<CarouselViewPagerActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mActivityWeakReference == null) {
                return;
            }
            CarouselViewPagerActivity carouselViewPagerActivity = mActivityWeakReference.get();
            if (carouselViewPagerActivity == null || carouselViewPagerActivity.isFinishing()) {
                return;
            }
            if (msg.what == INFINITE_CAROUSEL) {
                carouselViewPagerActivity.handleCarousel();
            }
        }

        public void destroy() {
            if (mActivityWeakReference != null) {
                this.removeCallbacksAndMessages(null);
                mActivityWeakReference.clear();
                mActivityWeakReference = null;
            }
        }
    }
}
