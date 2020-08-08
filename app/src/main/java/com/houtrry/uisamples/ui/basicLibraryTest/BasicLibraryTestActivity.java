package com.houtrry.uisamples.ui.basicLibraryTest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.het.basiclibrary.callback.OnActivityResultCallback;
import com.het.basiclibrary.utils.LogUtils;
import com.het.basiclibrary.utils.ToastUtils;
import com.het.basiclibrary.view.fragment.ActivityResultRequest;
import com.houtrry.uisamples.R;

import androidx.appcompat.app.AppCompatActivity;

public class BasicLibraryTestActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_library_test);
        findViewById(R.id.btn_test_activity_result).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_test_activity_result:{
                startTestActivityResult();
                break;
            }
            default:
                break;
        }
    }

    private void startTestActivityResult() {
        Intent intent = new Intent(BasicLibraryTestActivity.this, OnActivityResultTestActivity.class);
        ActivityResultRequest activityResultRequest = new ActivityResultRequest();
        activityResultRequest.init(this).startActivityForResult(intent, new OnActivityResultCallback() {
            @Override
            public void onActivityResult(int resultCode, Intent data) {
                LogUtils.d("result: "+resultCode);
                LogUtils.d("data: "+data.getStringExtra(OnActivityResultTestActivity.RESULT_TAG));
                ToastUtils.showToast(BasicLibraryTestActivity.this, "I has got result");
            }
        });
    }
}
