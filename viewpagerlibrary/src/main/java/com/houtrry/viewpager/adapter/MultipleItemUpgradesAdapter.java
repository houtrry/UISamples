package com.houtrry.viewpager.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.palette.graphics.Palette;
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
 * @time: 2018/4/2
 * @desc: ${TODO}
 */

public class MultipleItemUpgradesAdapter  extends PagerAdapter {

    private static final String TAG = CommonViewPagerAdapter.class.getSimpleName();

    private List<ViewPagerBean> mViewPagerBeans = new ArrayList<>();

    public MultipleItemUpgradesAdapter(List<ViewPagerBean> viewPagerBeans) {
        mViewPagerBeans = viewPagerBeans;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_view_pager_upgrades, null);
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
        return mViewPagerBeans == null ? 0 : mViewPagerBeans.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    private void handlePalette(@NonNull Context context, @IdRes final int resId, @NonNull final TextView textView) {
        Palette.from(BitmapFactory.decodeResource(context.getResources(), resId)).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
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