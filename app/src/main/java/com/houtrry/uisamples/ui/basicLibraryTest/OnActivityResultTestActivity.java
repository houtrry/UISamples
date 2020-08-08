package com.houtrry.uisamples.ui.basicLibraryTest;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.houtrry.uisamples.R;

public class OnActivityResultTestActivity extends AppCompatActivity {

    public static final String RESULT_TAG = "request_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_result_test);

        findViewById(R.id.btn_result_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backClick();
            }
        });
    }

    private void backClick() {
        Intent intent = new Intent();
        intent.putExtra(RESULT_TAG, "this is request result");
        OnActivityResultTestActivity.this.setResult(0x9527, intent);
        OnActivityResultTestActivity.this.finish();
    }
}
