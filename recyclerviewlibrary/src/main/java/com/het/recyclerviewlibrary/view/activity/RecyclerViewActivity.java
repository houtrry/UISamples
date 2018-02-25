package com.het.recyclerviewlibrary.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.het.basiclibrary.utils.ActivityUtils;
import com.het.recyclerviewlibrary.R;


/**
 * @author: houtrry
 * @date: 2017/12/29
 * @version:
 * @description: ${TODO}
 */
public class RecyclerViewActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = RecyclerViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        setTitle("RecyclerView相关");

        findViewById(R.id.btn_snap_helper).setOnClickListener(this);
        findViewById(R.id.btn_custom_snap_helper).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        final int viewId = v.getId();
        if (viewId == R.id.btn_snap_helper) {
            ActivityUtils.startAty(RecyclerViewActivity.this, SnapHelperActivity.class);
        } else if (viewId == R.id.btn_custom_snap_helper) {
            ActivityUtils.startAty(RecyclerViewActivity.this, CustomSnapHelperActivity.class);


            for (int i = 0; i < 50; i++) {
                Log.i(TAG, "onClick: i: "+i);
            }
        }
    }
}
