package com.houtrry.viewpager.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.houtrry.viewpager.utils.LogUtils;

/**
 * @author: houtrry
 * @time: 2018/4/2
 * @desc: ${TODO}
 */

public class RotateY3DRelativeLayout extends RelativeLayout {

    private float mCenterX;
    private float mCenterY;

    public RotateY3DRelativeLayout(Context context) {
        this(context, null);
    }

    public RotateY3DRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RotateY3DRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setWillNotDraw(false);
        mCamera.setLocation(0, 0, -30);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mCenterX = w * 0.5f;
        mCenterY = h * 0.5f;
    }

    private Camera mCamera = new Camera();
    private float mProgress = 0;
    private float mMaxRotate = 90;

    @Override
    public void draw(Canvas canvas) {


        canvas.save();

        mCamera.save(); // 保存 Camera 的状态
        mCamera.rotateY( 50* mProgress); // 旋转 Camera 的三维空间
        canvas.translate(mCenterX, mCenterY); // 旋转之后把投影移动回来
        mCamera.applyToCanvas(canvas); // 把旋转投影到 Canvas
        canvas.translate(-mCenterX, -mCenterY); // 旋转之前把绘制内容移动到轴心（原点）
        mCamera.restore(); // 恢复 Camera 的状态

        super.draw(canvas);
        canvas.restore();
    }

    public void setProgress(float progress) {
        LogUtils.e("===>>>progress: "+progress+", mMaxRotate: "+mMaxRotate);
        this.mProgress = progress;
        ViewCompat.postInvalidateOnAnimation(this);
    }
}
