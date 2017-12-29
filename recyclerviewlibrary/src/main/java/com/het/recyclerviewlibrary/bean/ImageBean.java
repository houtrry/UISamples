package com.het.recyclerviewlibrary.bean;

import android.support.annotation.IdRes;

/**
 * @author: houtrry
 * @date: 2017/12/29 13:28
 * @version: $Rev$
 * @description: ${TODO}
 */

public class ImageBean {

    @IdRes int imageId;
    String desc;

    public ImageBean() {
    }

    public ImageBean(int imageId, String desc) {
        this.imageId = imageId;
        this.desc = desc;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "ImageBean{" +
                "imageId=" + imageId +
                ", desc='" + desc + '\'' +
                '}';
    }
}
