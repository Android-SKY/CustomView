package customview.lukfook.com.customview.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import customview.lukfook.com.customview.R;
import customview.lukfook.com.customview.views.EraserView;

public class MainActivity extends AppCompatActivity {

    //我们自定义的View
//    private CustomView mCustomView;
//    private PorterDuffView mPorterDuffView;
//    private DisInView mDisInView;
//    private DisOutView mDisOutView;
//    private ScreenView mScreenView;
//    private ClockView mClockView;
    private EraserView mEraserView;
    //半径值
//    private int radiu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取控件
//        mCustomView = (CustomView) findViewById(R.id.main_cv);
//        mPorterDuffView = (PorterDuffView) findViewById(R.id.main_pdv);
//        mDisInView = (DisInView) findViewById(R.id.main_div);
//        mDisOutView = (DisOutView) findViewById(R.id.main_dov);
//        mScreenView = (ScreenView) findViewById(R.id.main_sv);
//        mClockView = (ClockView) findViewById(R.id.main_cvo);
        mEraserView = (EraserView) findViewById(R.id.main_ev);
        /**
         * 开线程
         */
//        new Thread(mCustomView).start();

    }


}
