package com.synertone.myrouter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.synertone.routerannotation.Route;

@Route( path = "/a/b")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
