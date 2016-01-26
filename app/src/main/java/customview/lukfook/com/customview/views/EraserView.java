package customview.lukfook.com.customview.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import customview.lukfook.com.customview.R;

/**
 * Created by Administrator on 2016/1/26.
 */
public class EraserView extends View {

    private static final int MIN_MOVE_DIS = 5;
    private Bitmap fgBitmap,bgBitmap;
    private Canvas mCanvas;
    private Paint mPaint;
    private Path mPath;

    private int screenW,screenH;
    private float preX,preY;

    public EraserView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //计算参数
        cal(context);

        //初始化对象
        init(context);
    }

    private void cal(Context context) {
        int[] screenSize = MeasureUtil.getScreenSize((Activity) context);

        screenW = screenSize[0];
        screenH = screenSize[1];
    }

    private void init(Context context) {
        mPath = new Path();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);

        mPaint.setARGB(128, 255, 0, 0);

        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));

        mPaint.setStyle(Paint.Style.STROKE);

        mPaint.setStrokeJoin(Paint.Join.ROUND);

        mPaint.setStrokeCap(Paint.Cap.ROUND);

        mPaint.setStrokeWidth(100);

        fgBitmap = Bitmap.createBitmap(screenW, screenH, Bitmap.Config.ARGB_8888);

        mCanvas = new Canvas(fgBitmap);

        mCanvas.drawColor(0xff808080);

        bgBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.a4);

        bgBitmap = Bitmap.createScaledBitmap(bgBitmap, screenW, screenH, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //绘制背景
        canvas.drawBitmap(bgBitmap, 0, 0, null);
        //绘制前景
        canvas.drawBitmap(fgBitmap, 0, 0, null);
         /*
         * 这里要注意canvas和mCanvas是两个不同的画布对象
         * 当我们在屏幕上移动手指绘制路径时会把路径通过mCanvas绘制到fgBitmap上
         * 每当我们手指移动一次均会将路径mPath作为目标图像绘制到mCanvas上，而在上面我们先在mCanvas上绘制了中性灰色
         * 两者会因为DST_IN模式的计算只显示中性灰，但是因为mPath的透明，计算生成的混合图像也会是透明的
         * 所以我们会得到“橡皮擦”的效果
         */
        mCanvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(x, y);

                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x - preX);
                float dy = Math.abs(y - preY);

                if(dx>=MIN_MOVE_DIS||dy>=MIN_MOVE_DIS) {
                    mPath.quadTo(preX, preY, (x + preX) / 2, (y + preY) / 2);

                    preX = x;
                    preY = y;
                }
                break;
        }

        invalidate();
        return true;
    }
}
