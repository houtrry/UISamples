package com.houtrry.viewpager.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.graphics.Palette;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.houtrry.viewpager.R;
import com.houtrry.viewpager.bean.ViewPagerBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: houtrry
 * @date: 2017/12/22 11:00
 * @version: $Rev$
 * @description: ${TODO}
 */

public class CarouselViewPagerAdapter extends PagerAdapter {

    private static final String TAG = CarouselViewPagerAdapter.class.getSimpleName();

    private List<ViewPagerBean> mViewPagerBeans = new ArrayList<>();

    public CarouselViewPagerAdapter(List<ViewPagerBean> viewPagerBeans) {
        mViewPagerBeans = viewPagerBeans;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        position = position % mViewPagerBeans.size();
        final View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_view_pager, null);
        final ImageView imageView = view.findViewById(R.id.iv_content);
        final TextView textView = view.findViewById(R.id.tv_desc);
        final ViewPagerBean viewPagerBean = mViewPagerBeans.get(position);
        imageView.setImageResource(viewPagerBean.getImageId());
        textView.setText(viewPagerBean.getDesc());
        container.addView(view);
        handlePalette(container.getContext(), viewPagerBean.getImageId(), textView);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
        if (container != null) {
            container.removeView((View) object);
        }
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    private void handlePalette(@NonNull Context context, @IdRes final int resId, @NonNull final TextView textView) {
        Palette.from(BitmapFactory.decodeResource(context.getResources(), resId)).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
//                /**
//                 * 有活力的
//                 */
//                Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
//                if (vibrantSwatch == null) {
//                    Log.e(TAG, "onGenerated: vibrantSwatch is null");
//                } else {
//                    textView.setBackgroundColor(getArgb(vibrantSwatch.getRgb()));
//                    textView.setTextColor(vibrantSwatch.getBodyTextColor());
//                }
//                /**
//                 * 有活力的，暗色
//                 */
//                Palette.Swatch darkVibrantSwatch = palette.getDarkVibrantSwatch();
//                if (darkVibrantSwatch == null) {
//                    Log.e(TAG, "onGenerated: darkVibrantSwatch is null");
//                } else {
//                    textView.setBackgroundColor(getArgb(darkVibrantSwatch.getRgb()));
//                    textView.setTextColor(darkVibrantSwatch.getBodyTextColor());
//                }
//                /**
//                 //                 * 有活力的，亮色
//                 //                 */
//                Palette.Swatch lightVibrantSwatch = palette.getLightVibrantSwatch();
//                if (lightVibrantSwatch == null) {
//                    Log.e(TAG, "onGenerated: lightVibrantSwatch is null");
//                } else {
//                    textView.setBackgroundColor(getArgb(lightVibrantSwatch.getRgb()));
//                    textView.setTextColor(lightVibrantSwatch.getBodyTextColor());
//                }
                /**
                 * 柔和的
                 */
                Palette.Swatch mutedSwatch = palette.getMutedSwatch();
                if (mutedSwatch == null) {
                    Log.e(TAG, "onGenerated: mutedSwatch is null");
                } else {
                    textView.setBackgroundColor(getArgb(mutedSwatch.getRgb()));
                    textView.setTextColor(mutedSwatch.getBodyTextColor());
                }
//                /**
//                 * 柔和的，暗色
//                 */
//                Palette.Swatch darkMutedSwatch = palette.getDarkMutedSwatch();
//                if (darkMutedSwatch == null) {
//                    Log.e(TAG, "onGenerated: darkMutedSwatch is null");
//                } else {
//                    textView.setBackgroundColor(getArgb(darkMutedSwatch.getRgb()));
//                    textView.setTextColor(darkMutedSwatch.getBodyTextColor());
//                }
//                /**
//                 * 柔和的,亮色
//                 */
//                Palette.Swatch lightMutedSwatch = palette.getLightMutedSwatch();
//                if (lightMutedSwatch == null) {
//                    Log.e(TAG, "onGenerated: lightMutedSwatch is null");
//                } else {
//                    textView.setBackgroundColor(getArgb(lightMutedSwatch.getRgb()));
//                    textView.setTextColor(lightMutedSwatch.getBodyTextColor());
//                }
//
//                Palette.Swatch dominantSwatch = palette.getDominantSwatch();
//                if (dominantSwatch == null) {
//                    Log.e(TAG, "onGenerated: dominantSwatch is null");
//                } else {
//                    textView.setBackgroundColor(getArgb(dominantSwatch.getRgb()));
//                    textView.setTextColor(dominantSwatch.getBodyTextColor());
//                }


            }
        });
    }

    private static final int DEFAULT_ALPHA = 103;

    private int getArgb(int rgb) {
        return getArgb(DEFAULT_ALPHA, rgb);
    }

    private int getArgb(int alpha, int rgb) {
        return Color.argb(alpha, Color.red(rgb), Color.green(rgb), Color.blue(rgb));
    }
}
