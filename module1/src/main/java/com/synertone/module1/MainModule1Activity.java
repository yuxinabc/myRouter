package com.synertone.module1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.synertone.routerannotation.Extra;
import com.synertone.routerannotation.Route;
import com.synertone.routercore.DNRouter;

@Route( path = "/module1/test")
public class MainModule1Activity extends AppCompatActivity {
    @Extra
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // TextView textView = new TextView(this);
        //textView.setText("dddddddddddddd");
        setContentView(R.layout.activity_module1_main);
        DNRouter.getInstance().inject(this);
        Log.i("module1", "我是模块1:" + msg);
    }
    public void mainJump(View view) {
        DNRouter.getInstance().build("/main/test").withString("a",
                "从Module1").navigation(this);
    }

    public void module2Jump(View view) {
        DNRouter.getInstance().build("/module2/test").withString("msg",
                "从Module1").navigation(this);
    }
}
