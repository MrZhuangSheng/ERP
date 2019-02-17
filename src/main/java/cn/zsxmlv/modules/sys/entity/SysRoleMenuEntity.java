package cn.zsxmlv.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: zs
 * @description: 角色菜单关联表
 * @date: 2019/1/23 14:58
 */
@Data
@ToString
@Builder
@TableName("erp_sys_role_menu")
public class SysRoleMenuEntity implements Serializable {

    /**
     * 关联主键
     */
    @TableId
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 菜单ID
     */
    private Integer menuId;

}
