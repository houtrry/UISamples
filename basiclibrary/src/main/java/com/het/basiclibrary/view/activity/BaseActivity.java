package com.het.basiclibrary.view.activity;

import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author: houtrry
 * @date: 2017/12/29
 * @version:
 * @description: ${TODO}
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        init();
        super.onCreate(savedInstanceState);
        setContentView(getContentLayoutId());

        initView();
        initData();
        initEvent();
    }

    protected void init() {

    }

    /**
     * 初始化布局信息
     */
    protected void initView() {
        final String titleString = getTitleString();
        if (titleString != null) {
            setTitle(titleString);
        }
    }

    protected void initData() {

    }

    protected void initEvent() {

    }

    protected String getTitleString() {
        return null;
    }

    /**
     * 获取页面布局id
     *
     * @return
     */

    @LayoutRes
    protected abstract int getContentLayoutId();


}
