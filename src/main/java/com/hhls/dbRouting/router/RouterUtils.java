package com.hhls.dbRouting.router;

import com.hhls.dbRouting.security.Base64Binrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RouterUtils {

    private static final Logger log = LoggerFactory.getLogger(RouterUtils.class);

    /**
     * 默认编码
     */
    private final static String encode = "utf-8";

    /**
     * 最大资源数
     * 取得的值[0,9999] >= db数 * table数
     */
    private final static int resourceMax = 10000;

    /**
     * 获取hashCode
     */
    public static int getHashCodeBase64(String routeValue) {
        int hashCode = 0;
        try {
            String pinBase64 = Base64Binrary.encodeBase64Binrary(routeValue.getBytes(encode));
            hashCode = Math.abs(pinBase64.hashCode());
        } catch (Exception e) {
            log.error("hashCode 失败", e);
        }
        return hashCode;
    }

    /**
     * 获取资源码
     */
    public static int getResourceCode(String routeValue) {
        int hashCode = RouterUtils.getHashCodeBase64(routeValue);
        return hashCode % resourceMax;
    }

}
