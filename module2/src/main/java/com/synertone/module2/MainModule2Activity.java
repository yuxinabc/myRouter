package com.synertone.module2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.synertone.routerannotation.Extra;
import com.synertone.routerannotation.Route;
import com.synertone.routercore.DNRouter;

@Route( path = "/module2/test")
public class MainModule2Activity extends AppCompatActivity{
    @Extra
    String msg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2_main);
        DNRouter.getInstance().inject(this);
        Log.i("module2", "我是模块2:" + msg);
    }
    public void mainJump(View view) {
        if (BuildConfig.isModule){
            DNRouter.getInstance().build("/main/test").withString("a",
                    "从Module2").navigation(this);
        }else{
            Toast.makeText(this,"当前处于组件模式,无法使用此功能",0).show();
        }
    }

    public void module1Jump(View view) {
        DNRouter.getInstance().build("/module1/test").withString("msg",
                "从Module2").navigation(this);
    }
}
