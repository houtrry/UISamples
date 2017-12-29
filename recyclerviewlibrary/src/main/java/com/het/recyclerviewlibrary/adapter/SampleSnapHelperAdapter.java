package com.het.recyclerviewlibrary.adapter;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.het.recyclerviewlibrary.R;
import com.het.recyclerviewlibrary.bean.ImageBean;

import java.util.List;
import java.util.Random;

/**
 * @author: houtrry
 * @date: 2017/12/29 11:40
 * @version: $Rev$
 * @description: ${TODO}
 */

public class SampleSnapHelperAdapter extends RecyclerView.Adapter<SampleSnapHelperAdapter.SampleSnapHelperHolder> {

    private List<ImageBean> mImageBeanList;

    public SampleSnapHelperAdapter(List<ImageBean> imageBeanList) {
        mImageBeanList = imageBeanList;
    }

    @Override
    public SampleSnapHelperHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SampleSnapHelperHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_snap_helper, parent, false));
    }

    @Override
    public void onBindViewHolder(SampleSnapHelperHolder holder, int position) {
        holder.imageView.setImageResource(mImageBeanList.get(position).getImageId());
        holder.itemView.setBackgroundColor(getRandomColor());
    }

    @Override
    public int getItemCount() {
        return mImageBeanList == null ? 0 : mImageBeanList.size();
    }

    private int getRandomColor() {
        final Random random = new Random();
        return Color.argb(100, random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    public class SampleSnapHelperHolder extends RecyclerView.ViewHolder {

        public static final int NO_ID = -1;

        private ImageView imageView;

        public SampleSnapHelperHolder(View itemView) {
            super(itemView);
            imageView = findViewById(R.id.imageView);
        }


        @Nullable
        public final <T extends View> T findViewById(@IdRes int id) {
            if (id == NO_ID) {
                return null;
            }
            return itemView.findViewById(id);
        }
    }
}
