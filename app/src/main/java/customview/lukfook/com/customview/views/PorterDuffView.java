package customview.lukfook.com.customview.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import customview.lukfook.com.customview.bo.PorterDuffBO;

/**
 * Created by Administrator on 2016/1/25.
 */
public class PorterDuffView extends View {

    /**
     * PorterDuff模式常量
     * 可以在次更改不同的测试模式
     */
    private static final PorterDuff.Mode MODE = PorterDuff.Mode.ADD;

    //左右上方示例渐变正方形的尺寸大小
    private static final int RECT_SIZE_SMALL = 400;
    //中间测试渐变正方形的尺寸大小
    private static final int RECT_SIZE_BIG = 800;

    //画笔
    private Paint mPaint;

    //PorterDuffView类的业务对象
    private PorterDuffBO porterDuffBO;
    //图形混合模式
    private PorterDuffXfermode porterDuffXfermode;

    //屏幕尺寸
    private int screenW, screenH;
    //左上方正方形的原点坐标
    private int s_l, s_t;
    //右上方正方形的原点坐标
    private int d_l, d_t;
    //中间正方形的原点坐标
    private int rectX, rectY;

    public PorterDuffView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //实例化画笔并设置抗锯齿
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        //实例化业务对象
        porterDuffBO = new PorterDuffBO();

        //实例化混合模式
        porterDuffXfermode = new PorterDuffXfermode(MODE);

        //计算坐标
        calu(context);
    }

    private void calu(Context context) {
        //获取包含屏幕尺寸的数组
        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        //获取屏幕尺寸
        screenW = screenSize[0];
        screenH = screenSize[1];

        //计算左上方正方形原点坐标
        s_l = 0;
        s_t = 0;

        //计算右上方正方形原点坐标
        d_l = screenW - RECT_SIZE_SMALL;
        d_t = 0;

        //计算中间正方形的原点坐标
        rectX = screenW / 2 - RECT_SIZE_BIG / 2;
        rectY = RECT_SIZE_SMALL + (screenH - RECT_SIZE_SMALL) / 2 - RECT_SIZE_BIG / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置画布颜色为黑色以便我们更好地观察
        canvas.drawColor(Color.BLACK);
    }
}
