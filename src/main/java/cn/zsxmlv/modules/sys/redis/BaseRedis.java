package cn.zsxmlv.modules.sys.redis;

import cn.zsxmlv.common.utils.RedisKeys;
import cn.zsxmlv.common.utils.RedisUtils;
import cn.zsxmlv.modules.sys.entity.SysConfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zs
 * @description:
 * @date: 2019/1/25 15:44
 */
@Component
public class BaseRedis<T> {

    @Autowired
    private RedisUtils redisUtils;

    public void saveOrUpdate(T t,String key) {

    }

    public void delete(String configKey) {
        String key = RedisKeys.getSysConfigKey(configKey);
        redisUtils.delete(key);
    }

    public SysConfigEntity get(String configKey){
        String key = RedisKeys.getSysConfigKey(configKey);
        return redisUtils.get(key, SysConfigEntity.class);
    }

}
