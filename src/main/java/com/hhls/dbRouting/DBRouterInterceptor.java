package com.hhls.dbRouting;

import com.hhls.dbRouting.annotation.Router;
import com.hhls.dbRouting.annotation.RouterConstants;
import java.lang.reflect.Method;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 切面 在Router注解的方法执行前执行 切点织入
 *
 * @author hhls Date: 2019-08-09 Time: 下午12:05
 * @version $Id$
 */
@Aspect
@Component
public class DBRouterInterceptor {

    private static final Logger log = LoggerFactory.getLogger(DBRouterInterceptor.class);

    @Autowired
    private DBRouter dbRouter;

    // 切点
    @Pointcut("@annotation(com.hhls.dbRouting.annotation.Router)")
    public void aopPoint() {
    }

    @Before("aopPoint()")
    public void doRoute(JoinPoint jp) throws Throwable {
        long start = System.currentTimeMillis();
        Method method = getMethod(jp);
        Router router = method.getAnnotation(Router.class);
        String routeField = router.routerField();
        Object[] args = jp.getArgs();
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                String routeFieldValue = BeanUtils.getProperty(arg, routeField);
                // 这里后续改成策略模式
                if (StringUtils.isNotEmpty(routeFieldValue)) {
                    if (RouterConstants.ROUTER_FIELD_DEFAULT.equals(routeField)) {
                        dbRouter.doRoute(routeFieldValue);
                        break;
                    } else {
                        this.searchParamCheck(routeFieldValue);
                        String resource = routeFieldValue.substring(routeFieldValue.length() - 4);
                        dbRouter.doRouteByResource(resource);
                        break;
                    }
                }
            }
        }
        log.debug("RouteTime:{}" + (System.currentTimeMillis() - start));
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature msig = (MethodSignature) sig;
        return getClass(jp).getMethod(msig.getName(), msig.getParameterTypes());
    }

    private Class<?> getClass(JoinPoint jp) {
        return jp.getTarget().getClass();
    }

    /**
     * 查询支付结构参数检查
     */
    private void searchParamCheck(String payId) {
        if (StringUtils.isBlank(payId)) {
            throw new IllegalArgumentException("payId is empty");
        }
        if (payId.length() < 4) {
            throw new IllegalArgumentException("payId is illegal");
        }
    }

}
