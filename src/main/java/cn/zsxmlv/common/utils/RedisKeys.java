package cn.zsxmlv.common.utils;

/**
 * @author: zs
 * @description: Redis所有Keys
 * @date: 2019/1/24 10:56
 */
public class RedisKeys {

    public static String getSysConfigKey(String key){
        return "sys:config:" + key;
    }

    /**
     * 根据用户ID获取token
     * @param userId 用户ID
     * @return user token str
     */
    public static String getLoginUserKey(int userId) {
        return "session_user_" + userId;
    }

    /**
     * 根据UUID获取验证码key
     * @param uuid 验证码标识
     * @return 获取验证码的key
     */
    public static String getCaptchaKey(String uuid) {
        return "token_captcha_" + uuid;
    }

}
