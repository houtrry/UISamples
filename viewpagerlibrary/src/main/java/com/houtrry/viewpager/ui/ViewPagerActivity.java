package com.houtrry.viewpager.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.houtrry.viewpager.R;

/**
 * @author: houtrry
 * @date: 2017/12/22
 * @version:
 * @description: ${TODO}
 */
public class ViewPagerActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        setTitle("ViewPager相关");
        findViewById(R.id.btn_common_viewPager).setOnClickListener(this);
        findViewById(R.id.btn_carousel_viewPager).setOnClickListener(this);
        findViewById(R.id.btn_transform_viewPager).setOnClickListener(this);
        findViewById(R.id.btn_multiple_item_viewPager).setOnClickListener(this);
        findViewById(R.id.btn_multiple_item_upgrades_viewPager).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final int viewId = v.getId();
        if (viewId == R.id.btn_common_viewPager) {
            startAty(CommonViewPagerActivity.class);
        } else if (viewId == R.id.btn_carousel_viewPager) {
            startAty(CarouselViewPagerActivity.class);
        } else if (viewId == R.id.btn_transform_viewPager) {
            startAty(TransformViewPagerActivity.class);
        } else if (viewId == R.id.btn_multiple_item_viewPager) {
            startAty(MultipleItemViewPagerActivity.class);
        } else if (viewId == R.id.btn_multiple_item_upgrades_viewPager) {
            startAty(MultipleItemUpgradesViewPagerActivity.class);
        }
    }


    private void startAty(Class<? extends Activity> cls) {
        startAty(ViewPagerActivity.this, cls);
    }

    public void startAty(@NonNull Context context, @NonNull Class<? extends Activity> cls) {
        final Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }
}
