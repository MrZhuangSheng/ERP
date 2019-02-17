package cn.zsxmlv.modules.sys.dao;

import cn.zsxmlv.modules.sys.entity.SysMenuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: zs
 * @description: 系统菜单管理
 * @date: 2019/1/19 22:54
 */
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenuEntity> {


    /**
     * 获取不包含按钮的菜单列表
     * @return
     */
    List<SysMenuEntity> queryNotButtonList();

}
