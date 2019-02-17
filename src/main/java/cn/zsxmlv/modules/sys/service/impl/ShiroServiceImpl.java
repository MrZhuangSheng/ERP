package cn.zsxmlv.modules.sys.service.impl;

import cn.zsxmlv.common.exception.RRException;
import cn.zsxmlv.common.utils.GsonUtils;
import cn.zsxmlv.common.utils.RedisKeys;
import cn.zsxmlv.common.utils.RedisUtils;
import cn.zsxmlv.modules.sys.dao.SysMenuDao;
import cn.zsxmlv.modules.sys.dao.SysUserDao;
import cn.zsxmlv.modules.sys.entity.SysUserEntity;
import cn.zsxmlv.modules.sys.service.ShiroService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author: zs
 * @description:
 * @date: 2019/1/24 22:01
 */
@Service
public class ShiroServiceImpl implements ShiroService {

    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SysMenuDao sysMenuDao;
    @Autowired
    private RedisUtils redisUtils;

    // session 有效时长默认两小时（单位秒(s)）
    @Value("${erp.expire}")
    private int EXPIRE;

    @Override
    public Set<String> getUserPermissions(int userId) {
        return null;
    }

    @Override
    public SysUserEntity queryUser(int userId) {
        return null;
    }

    @Override
    public SysUserEntity queryUserByToken(String token) {
        // 根据token获取用户对象 并更新token时长
        String userJson = redisUtils.get(token, EXPIRE);
        if (userJson != null && !"".equals(userJson)) {
            SysUserEntity userEntity = GsonUtils.formJson(userJson, SysUserEntity.class);
            String loginUserKey = RedisKeys.getLoginUserKey(userEntity.getId());
            redisUtils.get(loginUserKey, EXPIRE);
            return userEntity;
        }
        return null;
    }
}
