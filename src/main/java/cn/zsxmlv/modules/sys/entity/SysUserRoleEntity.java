package cn.zsxmlv.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: zs
 * @description: 用户角色关联表
 * @date: 2019/1/23 14:51
 */
@Data
@Builder
@ToString
@TableName("erp_sys_user_role")
public class SysUserRoleEntity implements Serializable {

    /**
     * 用户角色关联主键
     */
    @TableId
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 角色ID
     */
    private Integer roleId;

}
