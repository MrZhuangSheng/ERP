package cn.zsxmlv.modules.sys.service.impl;

import cn.zsxmlv.modules.sys.dao.SysMenuDao;
import cn.zsxmlv.modules.sys.entity.SysMenuEntity;
import cn.zsxmlv.modules.sys.service.SysMenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: zs
 * @description: 菜单管理
 * @date: 2019/1/19 23:01
 */
@Service
@Transactional
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenuEntity> implements SysMenuService {

    @Override
    public List<SysMenuEntity> queryNotButtonList() {
        return null;
    }
}
