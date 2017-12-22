package com.houtrry.uisamples.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.houtrry.uisamples.R;
import com.houtrry.viewpager.ui.ViewPagerActivity;

/**
 * @author: houtrry
 * @time: 2017/12/22
 * @version:
 * @description: ${TODO}
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_viewPager).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_viewPager:{
                startAty(ViewPagerActivity.class);
                break;
            }
            default:
                break;
        }
    }


    private void startAty(Class<? extends Activity> cls) {
        startAty(MainActivity.this, cls);
    }

    public void startAty(@NonNull Context context, @NonNull Class<? extends Activity> cls) {
        final Intent intent = new Intent(context, cls);
        context.startActivity(intent);
    }
}
