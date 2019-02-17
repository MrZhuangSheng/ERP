package cn.zsxmlv.modules.sys.form;

import lombok.*;

/**
 * @author: zs
 * @description: 登录表单
 * @date: 2019/2/8 17:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysLoginForm {

    private String username;
    private String password;
    private String captcha;
    private String uuid;

}
