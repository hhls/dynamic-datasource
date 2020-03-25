package com.hhls.dbRouting.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hhls Date: 2019-08-09 Time: 下午12:05
 * @version $Id$
 * @Target 是作用的目标，接口、方法、类、字段、包等等 @Retention 是注解存在的范围，
 * @RUNTIME 代表的是注解会在class字节码文件中存在，在运行时可以通过<b>反射</b>获取到
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Router {

    // 路由的字段
    String routerField() default RouterConstants.ROUTER_FIELD_DEFAULT;

    // 表名风格后缀
    String tableStyle() default RouterConstants.ROUTER_TABLE_SUFFIX_DEFAULT;
}
