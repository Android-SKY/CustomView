package customview.lukfook.com.customview.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.View;

import customview.lukfook.com.customview.R;

/**
 * Created by Administrator on 2016/1/22.
 */
public class CustomView extends View{

    //paint
    private Paint mPaint;
    //上下文环境引用
    private Context mContext;
    //圆环半径
    private int radiu;
    private Bitmap bitmap;
    private int x,y;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        
        //初始化画笔
        initPaint();

        //初始化资源
        initRes(context);
    }

    /**
     * 初始化资源
     * @param context
     */
    private void initRes(Context context) {
        //获取位图
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.a);

        x = MeasureUtil.getScreenSize((Activity) mContext)[0] / 2 - bitmap.getWidth() / 2;
        y = MeasureUtil.getScreenSize((Activity) mContext)[1] / 2 - bitmap.getHeight() / 2;
    }


    /**
     * 初始化画笔
     */
    private void initPaint() {
        //实例化画笔并打开抗锯齿
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setColor(Color.argb(255, 255, 128, 103));
//
//        ColorMatrix colorMatrix=new ColorMatrix(new float[]{
//                0.393f, 0.769f, 0.189f, 0, 0,
//                0.349f, 0.686f, 0.168f, 0, 0,
//                0.272f, 0.534f, 0.131f, 0, 0,
//                0, 0, 0, 1, 0,
//
//        });
//        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));
//        mPaint.setStrokeWidth(10);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制圆环
//        canvas.drawCircle(MeasureUtil.getScreenSize((Activity) mContext)[0] / 2, MeasureUtil.getScreenSize((Activity) mContext)[1] / 2, 200, mPaint);
        canvas.drawBitmap(bitmap, x * 0.8f, y * 0.8f, mPaint);
    }


//    @Override
//    public void run() {
//        while (true) {
//            try {
//                        /*
//                         *如果半径小于200则自加否则大于200后重置以实现往复
//                         */
//                if (radiu <= 200) {
//                    radiu += 10;
//
//                    //刷新view
//                    postInvalidate();
//                } else {
//                    radiu = 0;
//                }
//                //每执行一次暂停40毫秒
//                Thread.sleep(40);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
