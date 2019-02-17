package cn.zsxmlv.modules.sys.dao;

import cn.zsxmlv.modules.sys.entity.SysUserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: zs
 * @description: 系统用户管理
 * @date: 2019/1/23 14:44
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUserEntity> {


    SysUserEntity queryByUserName(String username);

}
