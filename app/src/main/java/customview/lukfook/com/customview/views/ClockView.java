package customview.lukfook.com.customview.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/1/25.
 */
public class ClockView extends View {

    private Paint mPaint;
    private Bitmap bitmapSrc, bitmapDis;
    private PorterDuffXfermode porterDuffXfermode;
    private static final float CIRCLE_RADIUS = 60;
    private static final float CIRCLE_BIG_RADIUS = 100;

    //左右2圆原点坐标
    private int l_x, l_y, r_x, r_y;
    //屏幕尺寸
    private int screenW, screenH;

    public ClockView(Context context) {
        this(context, null);
    }

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);

        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OVER);

        initPaint();

        initRes(context);
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setColor(Color.WHITE);
    }

    private void initRes(Context context) {

        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        screenW = screenSize[0];
        screenH = screenSize[1];

        l_x = screenW / 3;
        l_y = screenH / 4;
        r_x = 2 * screenW / 3;
        r_y = screenH / 4;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0xfff69175);

        canvas.drawCircle(l_x, l_y, CIRCLE_RADIUS, mPaint);
        canvas.drawCircle(r_x, r_y, CIRCLE_RADIUS, mPaint);

        mPaint.setColor(0xfff69175);

        canvas.drawCircle(screenW/2,screenH/2,CIRCLE_BIG_RADIUS,mPaint);

    }
}
