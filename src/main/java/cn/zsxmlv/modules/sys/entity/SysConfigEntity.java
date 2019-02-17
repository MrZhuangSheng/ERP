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
 * @description: 系统配置
 * @date: 2019/1/24 10:58
 */
@Data
@ToString
@Builder
@TableName("erp_sys_config")
public class SysConfigEntity implements Serializable {

    @TableId
    private Integer id;

    /**
     * 参数名
     * @NotBlank(message = "参数名不能为空")
     */
    @NotBlank(message = "参数名不能为空")
    private String confKey;

    /**
     * 参数值
     * @NotBlank(message = "参数值不能为空")
     */
    @NotBlank(message = "参数值不能为空")
    private String confVal;

    /**
     * 备注
     */
    private String confDesc;

    /**
     * 启用状态 默认0启用 1禁用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
