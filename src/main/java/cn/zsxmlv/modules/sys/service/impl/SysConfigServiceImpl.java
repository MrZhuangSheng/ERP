package cn.zsxmlv.modules.sys.service.impl;

import cn.zsxmlv.modules.sys.dao.SysConfigDao;
import cn.zsxmlv.modules.sys.entity.SysConfigEntity;
import cn.zsxmlv.modules.sys.service.SysConfigService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: zs
 * @description: 系统配置
 * @date: 2019/1/23 14:47
 */
@Service
@Transactional
public class SysConfigServiceImpl extends ServiceImpl<SysConfigDao, SysConfigEntity> implements SysConfigService {
}
