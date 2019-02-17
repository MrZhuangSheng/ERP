package cn.zsxmlv.modules.sys.ctrl;

import cn.zsxmlv.common.exception.RRException;
import cn.zsxmlv.common.utils.R;
import cn.zsxmlv.modules.sys.component.CaptchaComponent;
import cn.zsxmlv.modules.sys.entity.SysUserEntity;
import cn.zsxmlv.modules.sys.form.SysLoginForm;
import cn.zsxmlv.modules.sys.service.ShiroService;
import cn.zsxmlv.modules.sys.service.SysUserService;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Method;

@RestController
public class LoginCtrl extends BaseCtrl {

    @Autowired
    private CaptchaComponent captchaComponent;
    @Autowired
    private SysUserService sysUserService;

    @RequestMapping("/captcha.jpg")
    public void captcha(HttpServletResponse response, String uuid) throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        BufferedImage image = captchaComponent.getCaptcha(uuid);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    @RequestMapping(value="/sys/login")
    public R login(@RequestBody SysLoginForm sysLoginForm) {
        /**
         * 1、检验验证码
         * 2、查询用户
         * 3、比对密码
         * 4、判断状态
         * 5、返回数据
         */

        boolean validate = captchaComponent.validate(sysLoginForm.getUuid(), sysLoginForm.getCaptcha());
        if (!validate) {
            throw new RRException("验证码不正确");
        }

        SysUserEntity user = sysUserService.queryByUsername(sysLoginForm.getUsername());

        if (user == null || !user.getPassword().equals(new Sha256Hash(sysLoginForm.getPassword(), user.getSalt()).toHex())) {
            throw new RRException("账号或密码不正确");
        }

        if (user.getStatus() != 0) {
            throw new RRException("账号异常,请联系管理员");
        }

        return sysUserService.createToken(user.getId());
    }

}
