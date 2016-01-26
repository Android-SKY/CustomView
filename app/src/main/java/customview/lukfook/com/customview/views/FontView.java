package customview.lukfook.com.customview.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Administrator on 2016/1/26.
 */
public class FontView extends View {
    private static final String TEXT = "ap爱哥ξτβбпшㄎㄊěǔぬも┰┠№＠↓";
    private Paint mPaint;
    private Paint.FontMetrics mFontMetrics;

    public FontView(Context context) {
        this(context, null);
    }

    public FontView(Context context, AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(50);
        mPaint.setColor(Color.BLACK);

        mFontMetrics = mPaint.getFontMetrics();

        Log.d("sky", "ascent: " + mFontMetrics.ascent);
        Log.d("sky", "top: " + mFontMetrics.top);
        Log.d("sky", "leading: " + mFontMetrics.leading);
        Log.d("sky", "descent: " + mFontMetrics.descent);
        Log.d("sky", "bottom: " + mFontMetrics.bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(TEXT, 0, Math.abs(mFontMetrics.top), mPaint);
    }
}
