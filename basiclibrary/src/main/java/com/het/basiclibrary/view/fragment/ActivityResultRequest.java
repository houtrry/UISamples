package com.het.basiclibrary.view.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.het.basiclibrary.callback.OnActivityResultCallback;

/**
 * @author: houtrry
 * @time: 2018/4/15
 * @desc:  通过一个空的Fragment, 来发送startActivity和接收onActivityResult, 避免在每个Activity或者Fragment中单独处理onActivityResult.
 * 当然,动态获取权限也可以这么处理.
 * Android中,Glide, RxPermission, RxLifeCycle 等都是这么处理的.其中,Glide和RxLifeCycle用这种方式来感知生命周期, RxPermission用这个方法来处理回调
 */
public class ActivityResultRequest {

    public static final String FRAGMENT_TAG = "on_activity_result_dispatcher_fragment";

    private OnActivityResultDispatcherFragment mOnActivityResultDispatcherFragment;

    public ActivityResultRequest() {

    }

    public ActivityResultRequest init(@NonNull Activity activity) {
        mOnActivityResultDispatcherFragment = getOnActivityResultDispatcherFragment(activity.getFragmentManager());
        return this;
    }

    public ActivityResultRequest init(@NonNull Fragment fragment) {
        mOnActivityResultDispatcherFragment = getOnActivityResultDispatcherFragment(fragment.getFragmentManager());
        return this;
    }

    private OnActivityResultDispatcherFragment getOnActivityResultDispatcherFragment(@NonNull FragmentManager fragmentManager) {
        OnActivityResultDispatcherFragment fragment = (OnActivityResultDispatcherFragment)fragmentManager.findFragmentByTag(FRAGMENT_TAG);

        if (fragment == null) {
            fragment = OnActivityResultDispatcherFragment.newInstance();
            fragmentManager.beginTransaction()
                    .add(fragment, FRAGMENT_TAG)
            .commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
        }
        return fragment;
    }

    public ActivityResultRequest startActivityForResult(Intent intent, OnActivityResultCallback callback) {
        mOnActivityResultDispatcherFragment.startActivityForResult(intent, callback);
        return this;
    }
}
