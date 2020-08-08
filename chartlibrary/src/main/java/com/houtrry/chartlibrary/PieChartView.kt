package com.houtrry.chartlibrary

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.abs

/**
 * @author: houtrry
 * @time: 2020/8/8
 * @desc:
 */
class PieChartView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val pieItemList = mutableListOf<PieItemDataBean>()

    init {
        pieItemList.add(PieItemDataBean(Color.RED, "第一", 0.26f))
        pieItemList.add(PieItemDataBean(Color.BLUE, "第二", 0.05f))
        pieItemList.add(PieItemDataBean(Color.GREEN, "第三", 0.06f))
        pieItemList.add(PieItemDataBean(getContext().resources.getColor(android.R.color.holo_blue_light), "第四", 0.07f))
        pieItemList.add(PieItemDataBean(getContext().resources.getColor(android.R.color.holo_red_light), "第五", 0.25f))
        pieItemList.add(PieItemDataBean(getContext().resources.getColor(android.R.color.holo_green_dark), "第六", 0.31f))


    }

    private var centerText: String = "鱼米之乡"
    private var centerTextSize = 14.sp
    private var centerTextColor = "#000000".color

    private var centerSolidRadius = 36.dp
    private var centerSolidColor = Color.WHITE

    private var extraTextSize = 12.sp

    private var arcLineWidth = 10.dp

    private var extraLineWidth = 1.dp

    private var viewWidth = 0
    private var viewHeight = 0

    private val centerPointF = PointF()

    private val centerSolidPaint: Paint by lazy {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = centerSolidColor
        paint.style = Paint.Style.FILL
        paint
    }
    private val centerTextPaint: Paint by lazy {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.color = centerTextColor
        paint.textSize = centerTextSize
        paint
    }
    private val arcPaint: Paint by lazy {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.strokeWidth = arcLineWidth
        paint.style = Paint.Style.STROKE
        paint
    }
    private val extraLinePaint: Paint by lazy {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.strokeWidth = extraLineWidth
        paint.style = Paint.Style.STROKE
        paint
    }
    private val extraTextPaint: Paint by lazy {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.textSize = extraTextSize
        paint
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        viewWidth = w
        viewHeight = h
        centerPointF.x = w * 0.5f
        centerPointF.y = h * 0.5f
        rectF.left = centerPointF.x - centerSolidRadius - arcLineWidth * 0.5f
        rectF.top = centerPointF.y - centerSolidRadius - arcLineWidth * 0.5f
        rectF.right = centerPointF.x + centerSolidRadius + arcLineWidth * 0.5f
        rectF.bottom = centerPointF.y + centerSolidRadius + arcLineWidth * 0.5f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            canvas.drawColor(Color.GRAY)
            drawCenterSolid(it)
            drawCenterText(it)
            drawPieItem(it)
        }
    }

    private fun drawCenterSolid(canvas: Canvas) {
        canvas.drawCircle(centerPointF.x, centerPointF.y, centerSolidRadius, centerSolidPaint)
    }

    private fun drawCenterText(canvas: Canvas) {
        canvas.drawText(centerText, centerPointF.x - centerTextPaint.getTextWidth(centerText) * 0.5f, centerPointF.y + centerTextPaint.getTextHeight(centerText) * 0.5f, centerTextPaint)
    }

    private val rectF = RectF()
    private var startArc = -90f
    private var sweepArc = 0f


    private var extraLineMarginWithCircle = 10.dp
    private var extraLine1Length = 20.dp
    private var extraLine2Length = 30.dp
    private var extraLineMarginWithText = 6.dp


    private var arcCenterRadian: Double = 0.0

    private val startExtraLinePointF = PointF()
    private val centerExtraLinePointF = PointF()
    private val endExtraLinePointF = PointF()

    private val textExtraPointF = PointF()
    private fun drawPieItem(canvas: Canvas) {
        pieItemList.forEach {
            arcPaint.color = it.color
            sweepArc = 360 * it.percent
            canvas.drawArc(rectF, startArc, sweepArc, false, arcPaint)


            arcCenterRadian = -(startArc + sweepArc * 0.5f) * 2 * Math.PI / 360

            extraLinePaint.color = it.color

            startExtraLinePointF.x = (centerPointF.x + (centerSolidRadius + arcLineWidth + extraLineMarginWithCircle) * Math.cos(arcCenterRadian)).toFloat()
            startExtraLinePointF.y = (centerPointF.y - (centerSolidRadius + arcLineWidth + extraLineMarginWithCircle) * Math.sin(arcCenterRadian)).toFloat()

            centerExtraLinePointF.x = (centerPointF.x + (centerSolidRadius + arcLineWidth + extraLineMarginWithCircle + extraLine1Length) * Math.cos(arcCenterRadian)).toFloat()
            centerExtraLinePointF.y = (centerPointF.y - (centerSolidRadius + arcLineWidth + extraLineMarginWithCircle + extraLine1Length) * Math.sin(arcCenterRadian)).toFloat()

            canvas.drawLine(startExtraLinePointF.x, startExtraLinePointF.y, centerExtraLinePointF.x, centerExtraLinePointF.y, extraLinePaint)

            endExtraLinePointF.y = centerExtraLinePointF.y
            textExtraPointF.y = endExtraLinePointF.y + extraTextPaint.getTextHeight(it.text) * 0.5f
            if (abs(startArc + sweepArc * 0.5f) < 90) {
                endExtraLinePointF.x = centerExtraLinePointF.x + extraLine2Length
                textExtraPointF.x = endExtraLinePointF.x + extraLineMarginWithText
            } else {
                endExtraLinePointF.x = centerExtraLinePointF.x - extraLine2Length
                textExtraPointF.x = endExtraLinePointF.x - extraLineMarginWithText - extraTextPaint.getTextWidth(it.text)
            }
            canvas.drawLine(centerExtraLinePointF.x, centerExtraLinePointF.y, endExtraLinePointF.x, endExtraLinePointF.y, extraLinePaint)

            extraTextPaint.color = it.color
            canvas.drawText(it.text, textExtraPointF.x, textExtraPointF.y, extraTextPaint)

            startArc += sweepArc
        }
    }
}