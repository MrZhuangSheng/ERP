package cn.zsxmlv.modules.sys.ctrl;

import cn.zsxmlv.modules.sys.entity.SysUserEntity;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zs
 * @description: 抽象基础ctrl类
 * @date: 2019/1/19 21:04
 */
public abstract class BaseCtrl {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected SysUserEntity getUser() {
        return (SysUserEntity) SecurityUtils.getSubject().getPrincipal();
    }

    protected Integer getUserId() {
        return getUser().getId();
    }

}
