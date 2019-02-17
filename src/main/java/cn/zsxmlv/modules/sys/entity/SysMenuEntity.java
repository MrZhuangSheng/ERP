package cn.zsxmlv.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author: zs
 * @description:
 * @date: 2019/1/19 21:13
 */
@Data
@ToString
@TableName("erp_sys_menu")
public class SysMenuEntity implements Serializable {

    /**
     * 菜单ID
     */
    @TableId
    private Integer id;

    /**
     * 父级菜单ID
     */
    private Integer pid;

    /**
     * 父级菜单名称
     */
    @TableField(exist = false)
    private String parentName;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String parms;

    /**
     * 类型     1：菜单   2：按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer sort;

}
