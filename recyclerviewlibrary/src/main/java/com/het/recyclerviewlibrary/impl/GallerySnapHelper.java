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
        //这个方法会计算第二个参数对应的ItemView当前的坐标与需要对齐的坐标之间的距离。
        // 该方法返回一个大小为2的int数组，分别对应x轴和y轴方向上的距离。
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
        //该方法会找到当前layoutManager上最接近对齐位置的那个view，
        // 该view称为SanpView，对应的position称为SnapPosition。
        // 如果返回null，就表示没有需要对齐的View，也就不会做滚动对齐调整。
        return null;
    }

    @Override
    public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
        //该方法会根据触发Fling操作的速率（参数velocityX和参数velocityY）来找到RecyclerView需要滚动到哪个位置，
        // 该位置对应的ItemView就是那个需要进行对齐的列表项。
        // 我们把这个位置称为targetSnapPosition，对应的View称为targetSnapView。
        // 如果找不到targetSnapPosition，就返回RecyclerView.NO_POSITION。

        return 0;
    }
}
