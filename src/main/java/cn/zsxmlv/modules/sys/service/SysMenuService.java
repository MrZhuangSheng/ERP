package cn.zsxmlv.modules.sys.service;

import cn.zsxmlv.modules.sys.entity.SysMenuEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * @author: zs
 * @description: 菜单管理
 * @date: 2019/1/19 22:57
 */

public interface SysMenuService extends IService<SysMenuEntity> {


    /**
     * 查询菜单(不包含按钮)
     * @return
     */
    List<SysMenuEntity> queryNotButtonList();

}
