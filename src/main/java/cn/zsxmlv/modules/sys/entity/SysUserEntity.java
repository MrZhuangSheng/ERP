package cn.zsxmlv.modules.sys.entity;

import cn.zsxmlv.common.validator.group.AddGroup;
import cn.zsxmlv.common.validator.group.UpdateGroup;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author: zs
 * @description: 系统用户
 * @date: 2019/1/23 14:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@TableName("erp_sys_user")
public class SysUserEntity implements Serializable {

    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空", groups = {AddGroup.class, UpdateGroup.class})
    private String username;

    @NotBlank(message = "密码不能为空", groups = AddGroup.class)
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户手机
     */
    private String mobile;

    /**
     * 状态 0：启用 1：禁用 ... (后面可以改成枚举)
     */
    private Integer status;

    /**
     * 创建人
     */
    private Integer createUserId;

    /**
     * 创建时间
     */
    private Data createTime;

}
