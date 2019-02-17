package cn.zsxmlv.common.validator.group;

import javax.validation.GroupSequence;

/**
 * @author: zs
 * @description: 定义校验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 * @date: 2019/1/23 14:35
 */
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface Group {
}
