package cn.zsxmlv.modules.sys.service.impl;

import cn.zsxmlv.modules.sys.dao.SysLogDao;
import cn.zsxmlv.modules.sys.entity.SysLogEntity;
import cn.zsxmlv.modules.sys.service.SysLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: zs
 * @description: 用户操作日志管理
 * @date: 2019/1/23 14:47
 */
@Service
@Transactional
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLogEntity> implements SysLogService {
}
