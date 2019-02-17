package cn.zsxmlv.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: zs
 * @description: 系统角色
 * @date: 2019/1/23 14:53
 */
@Data
@ToString
@Builder
@TableName("erp_sys_role")
public class SysRoleEntity implements Serializable {

    /**
     * 角色ID
     */
    @TableId
    private Integer id;

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    private String roleName;

    /**
     * 角色备注
     */
    private String remark;

    /**
     * 创建人
     */
    private Integer createUserId;

    /**
     * 创建时间
     */
    private Date createTime;
}
