package cn.zsxmlv.common.utils;

import com.google.gson.Gson;

/**
 * @author: zs
 * @description: Gson工具类
 * @date: 2019/1/28 14:07
 */
public class GsonUtils {

    private final static Gson gson = new Gson();

    /**
     * JSON字符串转对象
     * @param json 字符串对象
     * @param clazz 数据类型
     * @param <T>
     * @return
     */
    public static <T> T formJson(String json,Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

}
