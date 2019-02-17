package cn.zsxmlv.common.aspect;

import cn.zsxmlv.common.exception.RRException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zs
 * @description: Redis切面处理类
 * @date: 2019/1/25 14:22
 */
@Aspect
@Configuration
public class RedisAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    // redis 配置开关
    @Value("${erp.redis.open}")
    private boolean open;

    /**
     *
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("execution(* cn.zsxmlv.common.utils.RedisUtils.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;

        if (open) {
            try {
                result = point.proceed();
            } catch (Exception e) {
                logger.error(" redis error ", e);
                throw new RRException("Redis服务异常");
            }
        }

        return result;
    }

}
