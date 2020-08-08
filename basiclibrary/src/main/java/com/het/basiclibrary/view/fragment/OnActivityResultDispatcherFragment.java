package com.het.basiclibrary.view.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.SparseArray;

import com.het.basiclibrary.callback.OnActivityResultCallback;

/**
 * @author: houtrry
 * @time: 2018/4/15
 * @desc: ${TODO}
 */
public class OnActivityResultDispatcherFragment extends Fragment {

    private SparseArray<OnActivityResultCallback> mCallbacks = new SparseArray<>();

    public static OnActivityResultDispatcherFragment newInstance() {
        return new OnActivityResultDispatcherFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        OnActivityResultCallback callback = mCallbacks.get(requestCode);
        mCallbacks.remove(requestCode);
        if (callback != null) {
            callback.onActivityResult(resultCode, data);
        }
    }

    public void startActivityForResult(Intent intent, OnActivityResultCallback callback) {
        mCallbacks.put(callback.hashCode(), callback);
        this.startActivityForResult(intent, callback.hashCode());
    }
}
