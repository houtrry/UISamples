package com.houtrry.uisamples.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.het.nestedscorlllibrary.component.activity.NestedScrollActivity;
import com.het.recyclerviewlibrary.view.activity.RecyclerViewActivity;
import com.houtrry.uisamples.R;
import com.houtrry.uisamples.ui.basicLibraryTest.BasicLibraryTestActivity;
import com.houtrry.viewpager.ui.ViewPagerActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
        findViewById(R.id.btn_recycler).setOnClickListener(this);
        findViewById(R.id.btn_nested_scroll).setOnClickListener(this);
        findViewById(R.id.btn_basic_library_test).setOnClickListener(this);
        findViewById(R.id.btn_chart_view_test).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_viewPager:{
                startAty(ViewPagerActivity.class);
                break;
            }
            case R.id.btn_recycler:{
                startAty(RecyclerViewActivity.class);
                break;
            }
            case R.id.btn_nested_scroll:{
                startAty(NestedScrollActivity.class);
                break;
            }
            case R.id.btn_basic_library_test:{
                startAty(BasicLibraryTestActivity.class);
                break;
            }
            case R.id.btn_chart_view_test:{
                startAty(ChartViewActivity.class);
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
