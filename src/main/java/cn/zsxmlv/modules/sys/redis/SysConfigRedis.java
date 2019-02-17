package cn.zsxmlv.modules.sys.redis;

import cn.zsxmlv.common.utils.RedisKeys;
import cn.zsxmlv.common.utils.RedisUtils;
import cn.zsxmlv.modules.sys.entity.SysConfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: zs
 * @description: 系统配置Redis
 * @date: 2019/1/24 10:04
 */
@Component
public class SysConfigRedis {

    @Autowired
    private RedisUtils redisUtils;

    public void saveOrUpdate(SysConfigEntity config) {
        if(config == null){
            return ;
        }
        String key = RedisKeys.getSysConfigKey(config.getConfKey());
        redisUtils.set(key, config);
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
