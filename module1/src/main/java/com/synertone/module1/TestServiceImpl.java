package com.synertone.module1;

import android.util.Log;

import com.synertone.base.TestService;
import com.synertone.routerannotation.Route;


/**
 * @author Lance
 * @date 2018/3/6
 */

@Route(path = "/module1/service")
public class TestServiceImpl implements TestService {


    @Override
    public void test() {
        Log.i("Service", "我是Module1模块测试服务通信");
    }

}

