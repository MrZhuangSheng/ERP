package cn.zsxmlv.modules.sys.ctrl;

import cn.zsxmlv.common.utils.R;
import cn.zsxmlv.modules.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zs
 * @description:
 * @date: 2019/2/10 16:19
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserCtrl extends BaseCtrl {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/info")
    public R info() {
        return R.ok().put("user", getUser());
    }

}
