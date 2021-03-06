package com.houtrry.viewpager.ui;

import android.os.Bundle;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.houtrry.viewpager.R;
import com.houtrry.viewpager.adapter.MultipleItemUpgradesAdapter;
import com.houtrry.viewpager.bean.ViewPagerBean;
import com.houtrry.viewpager.impl.ScaleTransformerUpgrades;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: houtrry
 * @date: ${DATE} ${TIME}
 * @version:
 * @description: 一页显示多个Item
 * <p>
 * !!!注意 ViewPager和ViewPager的父控件都需要添加clipChildren="false"属性
 */
public class MultipleItemUpgradesViewPagerActivity extends AppCompatActivity {


    private ViewPager mViewPager;
    private List<ViewPagerBean> mViewPagerBeans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("一页显示多个Item的ViewPager");

        setContentView(R.layout.activity_multiple_item_view_pager);
        initView();
        initData();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void initData() {
        int[] imageIds = {R.drawable.img0, R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4};
        String[] descs = {"狗狗" + 0, "狗狗" + 1, "狗狗" + 2, "狗狗" + 3, "狗狗" + 4};
        mViewPagerBeans = new ArrayList<>();

        for (int i = 0; i < imageIds.length; i++) {
            mViewPagerBeans.add(new ViewPagerBean(imageIds[i], descs[i]));
        }

        initViewPager();
    }

    private void initViewPager() {
//        CommonViewPagerAdapter viewPagerAdapter = new CommonViewPagerAdapter(mViewPagerBeans);
        MultipleItemUpgradesAdapter viewPagerAdapter = new MultipleItemUpgradesAdapter(mViewPagerBeans);

        //设置Page间间距
        mViewPager.setPageMargin(20);

        //设置缓存的页面数量
        mViewPager.setOffscreenPageLimit(3);

        mViewPager.setAdapter(viewPagerAdapter);
//        mViewPager.setPageTransformer(true, new DepthPageTransformer());
//        mViewPager.setPageTransformer(true, new ZoomOutPageTransformer());
//        mViewPager.setPageTransformer(true, new RotateTransformer());
        mViewPager.setPageTransformer(true, new ScaleTransformerUpgrades());
//        mViewPager.setPageTransformer(true, new ScrollXTransformer());

        //http://blog.csdn.net/lmj623565791/article/details/51339751

    }
}
