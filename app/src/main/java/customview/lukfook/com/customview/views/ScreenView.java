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
public class ScreenView extends View {

    private Paint mPaint;
    private Bitmap bitmapSrc;
    private PorterDuffXfermode porterDuffXfermode;

    private int x, y;
    private int screenW,screenH;

    public ScreenView(Context context) {
        this(context, null);
    }

    public ScreenView(Context context, AttributeSet attrs) {
        super(context, attrs);

        porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SCREEN);

        initPaint();

        initRes(context);
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    private void initRes(Context context) {
        bitmapSrc = BitmapFactory.decodeResource(context.getResources(), R.drawable.a3);

        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        screenW = screenSize[0];
        screenH = screenSize[1];

        x = screenW / 2 - bitmapSrc.getWidth() / 2;
        y = screenH / 2 - bitmapSrc.getHeight() / 2;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);

        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);

        canvas.drawColor(0xcc1c093e);

        mPaint.setXfermode(porterDuffXfermode);

        canvas.drawBitmap(bitmapSrc, x, y, mPaint);

        mPaint.setXfermode(null);

        canvas.restoreToCount(sc);
    }
}
