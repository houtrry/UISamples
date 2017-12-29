package com.het.recyclerviewlibrary.view.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;

import com.het.basiclibrary.view.activity.BaseActivity;
import com.het.recyclerviewlibrary.R;
import com.het.recyclerviewlibrary.adapter.SampleSnapHelperAdapter;
import com.het.recyclerviewlibrary.bean.ImageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: houtrry
 * @date: 2017/12/29
 * @version:
 * @description: ${TODO}
 */
public class SnapHelperActivity extends BaseActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_snap_helper;
    }

    @Override
    protected String getTitleString() {
        return "SnapHelper的简单使用";
    }

    @Override
    protected void initView() {
        super.initView();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private int[] mImageIds = new int[]{R.drawable.beauty1, R.drawable.beauty2, R.drawable.beauty3,
            R.drawable.beauty4, R.drawable.beauty5, R.drawable.beauty6,
            R.drawable.beauty7, R.drawable.beauty8, R.drawable.beauty9,
            R.drawable.beauty10, R.drawable.beauty11, R.drawable.beauty12, R.drawable.beauty13};

    private List<ImageBean> mImageBeanList = new ArrayList<>();

    @Override
    protected void initData() {
        super.initData();

        mImageBeanList.clear();
        for (int i = 0; i < mImageIds.length; i++) {
            mImageBeanList.add(new ImageBean(mImageIds[i], "当前是第" + i + "个图片"));
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        linearSnapHelper.attachToRecyclerView(mRecyclerView);

        SampleSnapHelperAdapter sampleSnapHelperAdapter = new SampleSnapHelperAdapter(mImageBeanList);
        mRecyclerView.setAdapter(sampleSnapHelperAdapter);
    }
}
