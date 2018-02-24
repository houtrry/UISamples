package com.het.recyclerviewlibrary.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;

/**
 * @author: houtrry
 * @date: 2018/2/24 20:20
 * @version: $Rev$
 * @description: https://www.jianshu.com/p/e54db232df62
 */

public class GallerySnapHelper extends SnapHelper {

    @Nullable
    @Override
    public int[] calculateDistanceToFinalSnap(@NonNull RecyclerView.LayoutManager layoutManager, @NonNull View targetView) {
        int[] out = new int[2];
        if (layoutManager.canScrollHorizontally()) {
        } else {
            out[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {

        } else {
            out[1] = 0;
        }
        return out;
    }

    @Nullable
    @Override
    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        return null;
    }

    @Override
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        return 0;
    }
}
