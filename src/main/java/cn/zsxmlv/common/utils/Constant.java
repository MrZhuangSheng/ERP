package cn.zsxmlv.common.utils;

/**
 * @author: zs
 * @description: 常量
 * @date: 2019/1/22 19:55
 */
public class Constant {

    /** 超级管理员ID */
    public static final int SUPER_ADMIN = 1;

    /**
     * 菜单类型
     */
    public enum MenuType{

        /**
         * 目录
         */
        CATALOG(0),

        /**
         * 菜单
         */
        MENU(1),

        /**
         * 按钮
         */
        BUTTON(2);

        private int value;

        MenuType(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

}
