package com.synertone.module1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.synertone.routerannotation.Route;

@Route(path = "/module1/second")
public class SecondModule1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_module1);
    }
}
