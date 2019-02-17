package cn.zsxmlv.modules.sys.service.impl;

import cn.zsxmlv.common.utils.R;
import cn.zsxmlv.common.utils.RedisKeys;
import cn.zsxmlv.common.utils.RedisUtils;
import cn.zsxmlv.modules.sys.dao.SysUserDao;
import cn.zsxmlv.modules.sys.entity.SysUserEntity;
import cn.zsxmlv.modules.sys.oauth2.TokenGenerator;
import cn.zsxmlv.modules.sys.service.SysUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: zs
 * @description: 用户管理
 * @date: 2019/1/23 14:47
 */
@Service
@Transactional
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {

    @Autowired
    private RedisUtils redisUtils;

    // 单设备登录
    @Value("${erp.single-devices-login}")
    private boolean singleDeviceLogin;

    @Value("${erp.expire}")
    private int EXPIRE;

    @Override
    public SysUserEntity queryByUsername(String username) {
        return baseMapper.queryByUserName(username);
    }

    @Override
    public R createToken(int userId) {
        // 过期时间 默认两小时 单位：秒

        String token = TokenGenerator.generateValue();

        String loginUserKey = RedisKeys.getLoginUserKey(userId);

        SysUserEntity userEntity = this.selectById(userId);

        // 单设备登录
        if (singleDeviceLogin) {
            String oldToken = redisUtils.get(loginUserKey);
            if (!StringUtils.isBlank(oldToken)) {
                redisUtils.delete(oldToken);
            }
        }

        // 更新 redis 中的token及user对象信息
        redisUtils.delete(loginUserKey);

        redisUtils.set(loginUserKey, token, EXPIRE);

        redisUtils.set(token, userEntity, EXPIRE);

        return R.ok().put("token", token).put("expire", EXPIRE);
    }

}
