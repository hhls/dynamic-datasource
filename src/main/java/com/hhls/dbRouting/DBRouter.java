package com.hhls.dbRouting;

/**
 * DB路由接口  DB路由器接口，通过调用该接口来自动判断数据位于哪个服务器
 *
 * @author hhls Date: 2019-08-09 Time: 下午12:05
 * @version $Id$
 */
public interface DBRouter {

    /**
     * 根据fieldId, 统一hash获取资源码进行路由
     */
    String doRoute(String fieldId);


    /**
     * 根据资源码进行路由
     */
    String doRouteByResource(String resourceCode);
}
