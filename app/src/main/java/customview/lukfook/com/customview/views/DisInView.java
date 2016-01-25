package customview.lukfook.com.customview.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import customview.lukfook.com.customview.R;

/**
 * Created by Administrator on 2016/1/25.
 */
public class DisInView extends View {

    //画笔、位图
    private Paint mPaint;
    private Bitmap bitmapDis,bitmapSrc;
    //图层混合模式
    private PorterDuffXfermode porterDuffXfermode;

    //位图绘制时左上角的起点坐标
    private int x,y;
    //屏幕尺寸
    private int screenW,screenH;

    public DisInView(Context context) {
        this(context, null);
    }

    public DisInView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //实例化混合模式
        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);

        //初始化画笔
        initPaint();

        //初始化资源
        initRes(context);
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    /**
     * 初始化资源
     * @param context
     */
    private void initRes(Context context) {
        //获取位图
        bitmapDis = BitmapFactory.decodeResource(context.getResources(), R.drawable.a3);
        bitmapSrc = BitmapFactory.decodeResource(context.getResources(), R.drawable.a3_mask);

        //获取包含屏幕尺寸的数组
        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        //获取屏幕尺寸
        screenW = screenSize[0];
        screenH = screenSize[1];

        /**
         * 计算位图绘制时左上角的坐标使其位于屏幕中心
         * 屏幕坐标x轴向左偏移位图一半的宽度
         * 屏幕坐标y轴向左偏移位图一半的高度
         */
        x = screenW / 2 - bitmapDis.getWidth() / 2;
        y = screenH / 2 - bitmapDis.getHeight() / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        /**
         * 将绘制操作保存到新的图层
         */
        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);

        //绘制dis目标图
        canvas.drawBitmap(bitmapDis, x, y, mPaint);

        //设置混合模式
        mPaint.setXfermode(porterDuffXfermode);

        //再绘制src图层
        canvas.drawBitmap(bitmapSrc, x, y, mPaint);

        //还原混合模式
        mPaint.setXfermode(null);

        //还原画布
        canvas.restoreToCount(sc);
    }
}
