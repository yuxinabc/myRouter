package com.synertone.routercore;

import android.app.Application;
import android.content.pm.PackageManager;
import android.util.Log;

import com.synertone.routercore.template.IRouteGroup;
import com.synertone.routercore.template.IRouteRoot;
import com.synertone.routercore.utils.ClassUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;
public class DNRouter {
    private static Application mContext;
    private static final String TAG = "DNRouter";
    private static final String ROUTE_ROOT_PAKCAGE = "com.synertone.myrouter.routes";
    private static final String SDK_NAME = "DNRouter";
    private static final String SEPARATOR = "$$";
    private static final String SUFFIX_ROOT = "Root";

    /**
     * 初始化
     *
     * @param application
     */
    public static void init(Application application) {
        mContext = application;
        try {
            loadInfo();
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(TAG, "初始化失败!", e);
        }
    }

    private static void loadInfo() throws ClassNotFoundException, InterruptedException, IOException, PackageManager.NameNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获得所有 apt生成的路由类的全类名 (路由表)
        Set<String> routerMap = ClassUtils.getFileNameByPackageName(mContext, ROUTE_ROOT_PAKCAGE);
        for (String className : routerMap) {
            if (className.startsWith(ROUTE_ROOT_PAKCAGE + "." + SDK_NAME + SEPARATOR +
                    SUFFIX_ROOT)) {
                // root中注册的是分组信息 将分组信息加入仓库中
                ((IRouteRoot) (Class.forName(className).getConstructor().newInstance())).loadInto
                        (Warehouse.groupsIndex);
            }
        }
        for (Map.Entry<String, Class<? extends IRouteGroup>> stringClassEntry : Warehouse
                .groupsIndex.entrySet()) {
            Log.e(TAG, "Root映射表[ " + stringClassEntry.getKey() + " : " + stringClassEntry
                    .getValue() + "]");
        }

    }

}
