package cn.zsxmlv.modules.sys.service;

import cn.zsxmlv.modules.sys.entity.SysUserEntity;

import java.util.Set;

/**
 * @author: zs
 * @description: shiro相关接口
 * @date: 2019/1/24 21:52
 */
public interface ShiroService {

    /**
     * 获取用户权限列表
     * @param userId 系统用户ID
     * @return
     */
    Set<String> getUserPermissions(int userId);

    /**
     * 根据用户ID获取系统用户信息
     * @param userId 系统用户ID
     * @return
     */
    SysUserEntity queryUser(int userId);

    /**
     * 根据token从redis中获取用户信息
     * @param token 授权令牌
     * @return
     */
    SysUserEntity queryUserByToken(String token);

}
