package customview.lukfook.com.customview.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import customview.lukfook.com.customview.views.CustomView;
import customview.lukfook.com.customview.R;

public class MainActivity extends AppCompatActivity {

    //我们自定义的View
    private CustomView mCustomView;
    //半径值
    private int radiu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取控件
        mCustomView = (CustomView) findViewById(R.id.main_cv);

        /**
         * 开线程
         */
//        new Thread(mCustomView).start();

    }


}
