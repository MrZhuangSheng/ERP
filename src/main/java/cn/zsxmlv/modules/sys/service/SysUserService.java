package cn.zsxmlv.modules.sys.service;

import cn.zsxmlv.common.utils.R;
import cn.zsxmlv.modules.sys.entity.SysUserEntity;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author: zs
 * @description: 用户管理
 * @date: 2019/1/23 14:46
 */
public interface SysUserService extends IService<SysUserEntity> {

    /**
     * 根据用户名获取用户
     * @param username 用户名
     * @return 用户对象
     */
    SysUserEntity queryByUsername(String username);

    /**
     * 根据用户ID返回用户token
     * @param userId 用户ID
     * @return
     */
    R createToken(int userId);

}
