package cn.zsxmlv.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: zs
 * @description: 系统日志
 * @date: 2019/1/24 10:47
 */
@Data
@ToString
@Builder
@TableName("erp_sys_log")
public class SysLogEntity implements Serializable {

    @TableId
    private long id;

    /** 用户名 */
    private String username;

    /** 用户操作 */
    private String operation;

    /** 请求方法 */
    private String method;

    /** 请求参数 */
    private String params;

    /** 执行时长(毫秒) */
    private long time;

    /** 浏览器信息 */
    private String browser;

    /** 用户IP地址 */
    private String ip;

    /** 创建时间 */
    private Date createTime;
}
