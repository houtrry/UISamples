package com.houtrry.viewpager.bean;

/**
 * @author: houtrry
 * @date: 2017/12/22 11:02
 * @version: $Rev$
 * @description: ${TODO}
 */

public class ViewPagerBean {

    private int imageId;

    private String desc;

    public ViewPagerBean() {
    }

    public ViewPagerBean(int imageId, String desc) {
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
        return "ViewPagerBean{" +
                "imageId=" + imageId +
                ", desc='" + desc + '\'' +
                '}';
    }
}
