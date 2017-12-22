package com.houtrry.viewpager.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.houtrry.viewpager.R;
import com.houtrry.viewpager.adapter.CommonViewPagerAdapter;
import com.houtrry.viewpager.bean.ViewPagerBean;
import com.houtrry.viewpager.impl.ScrollXTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: houtrry
 * @date: ${DATE} ${TIME}
 * @version:
 * @description: 特殊效果的ViewPager
 */
public class TransformViewPagerActivity extends AppCompatActivity {


    private ViewPager mViewPager;
    private List<ViewPagerBean> mViewPagerBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("特殊效果的ViewPager");

        setContentView(R.layout.activity_transform_view_pager);
        initView();
        initData();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void initData() {
        int[] imageIds = {R.drawable.img0, R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
        String[] descs = {"狗狗"+0, "狗狗"+1, "狗狗"+2, "狗狗"+3, "狗狗"+4};
        mViewPagerBeans = new ArrayList<>();

        for (int i = 0; i < imageIds.length; i++) {
            mViewPagerBeans.add(new ViewPagerBean(imageIds[i], descs[i]));
        }

        initViewPager();
    }

    private void initViewPager() {
        CommonViewPagerAdapter viewPagerAdapter = new CommonViewPagerAdapter(mViewPagerBeans);


        mViewPager.setAdapter(viewPagerAdapter);
//        mViewPager.setPageTransformer(true, new DepthPageTransformer());
//        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
//        mViewPager.setPageTransformer(true, new RotateTransformer());
//        mViewPager.setPageTransformer(true, new ScaleTransformer());
        mViewPager.setPageTransformer(true, new ScrollXTransformer());
    }
}
