package customview.lukfook.com.customview.views;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * 测绘工具类
 * Created by sky on 2016/1/23.
 */
public final class MeasureUtil {

    public static int[] getScreenSize(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return new int[] {metrics.widthPixels, metrics.heightPixels};
    }
}
