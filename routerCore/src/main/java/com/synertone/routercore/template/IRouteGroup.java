package com.synertone.routercore.template;

import com.synertone.routerannotation.model.RouteMeta;

import java.util.Map;

/**
 * @author Lance
 * @date 2018/2/22
 */

public interface IRouteGroup {

    void loadInto(Map<String, RouteMeta> atlas);
}
