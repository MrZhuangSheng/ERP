package cn.zsxmlv.modules.sys.ctrl;

import cn.zsxmlv.common.exception.RRException;
import cn.zsxmlv.common.utils.Constant;
import cn.zsxmlv.common.utils.R;
import cn.zsxmlv.common.utils.RedisUtils;
import cn.zsxmlv.modules.sys.entity.SysMenuEntity;
import cn.zsxmlv.modules.sys.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: zs
 * @description: 菜单管理
 * @date: 2019/1/19 23:10
 */
@RestController
@RequestMapping("/sys/menu")
@Api(tags = "菜单管理")
public class SysMenuCtrl extends BaseCtrl {

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private RedisUtils redisUtils;


    @GetMapping("/nav")
    public String nav(){
        // TODO 获取菜单及权限列表
        String str = "{\"msg\":\"success\",\"menuList\":[{\"menuId\":1,\"parentId\":0,\"parentName\":null,\"name\":\"系统管理\",\"url\":null,\"perms\":null,\"type\":0,\"icon\":\"system\",\"orderNum\":0,\"open\":null,\"list\":[{\"menuId\":2,\"parentId\":1,\"parentName\":null,\"name\":\"管理员列表\",\"url\":\"sys/user\",\"perms\":null,\"type\":1,\"icon\":\"admin\",\"orderNum\":1,\"open\":null,\"list\":null},{\"menuId\":3,\"parentId\":1,\"parentName\":null,\"name\":\"角色管理\",\"url\":\"sys/role\",\"perms\":null,\"type\":1,\"icon\":\"role\",\"orderNum\":2,\"open\":null,\"list\":null},{\"menuId\":4,\"parentId\":1,\"parentName\":null,\"name\":\"菜单管理\",\"url\":\"sys/menu\",\"perms\":null,\"type\":1,\"icon\":\"menu\",\"orderNum\":3,\"open\":null,\"list\":null},{\"menuId\":5,\"parentId\":1,\"parentName\":null,\"name\":\"SQL监控\",\"url\":\"http://localhost:8080/renren-fast/druid/sql.html\",\"perms\":null,\"type\":1,\"icon\":\"sql\",\"orderNum\":4,\"open\":null,\"list\":null},{\"menuId\":6,\"parentId\":1,\"parentName\":null,\"name\":\"定时任务\",\"url\":\"job/schedule\",\"perms\":null,\"type\":1,\"icon\":\"job\",\"orderNum\":5,\"open\":null,\"list\":null},{\"menuId\":27,\"parentId\":1,\"parentName\":null,\"name\":\"参数管理\",\"url\":\"sys/config\",\"perms\":\"sys:config:list,sys:config:info,sys:config:save,sys:config:update,sys:config:delete\",\"type\":1,\"icon\":\"config\",\"orderNum\":6,\"open\":null,\"list\":null},{\"menuId\":30,\"parentId\":1,\"parentName\":null,\"name\":\"文件上传\",\"url\":\"oss/oss\",\"perms\":\"sys:oss:all\",\"type\":1,\"icon\":\"oss\",\"orderNum\":6,\"open\":null,\"list\":null},{\"menuId\":29,\"parentId\":1,\"parentName\":null,\"name\":\"系统日志\",\"url\":\"sys/log\",\"perms\":\"sys:log:list\",\"type\":1,\"icon\":\"log\",\"orderNum\":7,\"open\":null,\"list\":null}]}],\"code\":0,\"permissions\":[\"sys:schedule:info\",\"sys:menu:update\",\"sys:menu:delete\",\"sys:config:info\",\"sys:menu:list\",\"sys:config:save\",\"sys:config:update\",\"sys:schedule:resume\",\"sys:user:delete\",\"sys:config:list\",\"sys:user:update\",\"sys:role:list\",\"sys:menu:info\",\"sys:menu:select\",\"sys:schedule:update\",\"sys:schedule:save\",\"sys:role:select\",\"sys:user:list\",\"sys:menu:save\",\"sys:role:save\",\"sys:schedule:log\",\"sys:role:info\",\"sys:schedule:delete\",\"sys:role:update\",\"sys:schedule:list\",\"sys:user:info\",\"sys:schedule:run\",\"sys:config:delete\",\"sys:role:delete\",\"sys:user:save\",\"sys:schedule:pause\",\"sys:log:list\",\"sys:oss:all\"]}";
        return str;
    }

    @RequestMapping("/select")
    public R select(){


        return R.ok().put("menuList", "");
    }

    @RequestMapping("/list")
    public List<SysMenuEntity> list() {
        List<SysMenuEntity> list = sysMenuService.selectList(null);
        for (SysMenuEntity entity : list) {
            Integer pid = entity.getPid();
            SysMenuEntity parentEntity = sysMenuService.selectById(pid);
            if (parentEntity != null) {
                entity.setParentName(parentEntity.getName() == null ? "" : parentEntity.getName());
            }
        }
        return list;
    }


    @ApiOperation("新增菜单")
    @PostMapping("/save")
    public R save(SysMenuEntity menu) {

        // 数据校验
        verifyForm(menu);

        boolean insert = sysMenuService.insert(menu);

        return R.ok();
    }


    /**
     * 验证参数是否正确
     * @param menu
     */
    private void verifyForm(SysMenuEntity menu) {
        if (StringUtils.isBlank(menu.getName())) {
            throw new RRException("菜单名称不能为空");
        }

        if (menu.getPid() == null) {
            throw new RRException("上级菜单不能为空");
        }

        if (menu.getType() == Constant.MenuType.MENU.getValue()) {
            if (StringUtils.isBlank(menu.getUrl())) {
                throw new RRException("菜单URL不能为空");
            }
        }



    }

}
