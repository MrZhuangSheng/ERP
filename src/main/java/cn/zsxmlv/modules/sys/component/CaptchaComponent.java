package cn.zsxmlv.modules.sys.component;

import cn.zsxmlv.common.exception.RRException;
import cn.zsxmlv.common.utils.RedisKeys;
import cn.zsxmlv.common.utils.RedisUtils;
import com.google.code.kaptcha.Producer;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;

/**
 * @author: zs
 * @description: 验证码相关
 * @date: 2019/2/8 14:20
 */
@Component
public class CaptchaComponent{

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private Producer producer;

    /**
     * 获取验证码
     * @param uuid 获取验证码的标识
     * @return 图片对象
     */
    public BufferedImage getCaptcha(String uuid) {
        if (StringUtils.isBlank(uuid)) {
            throw new RRException("验证码标识不能为空");
        }
        //生成文字验证码
        String text = producer.createText();

        // 5分钟后过期
        redisUtils.set(RedisKeys.getCaptchaKey(uuid), text, 5 * 60);

        return producer.createImage(text);
    }

    /**
     * 检验验证码是否与UUID匹配
     * @param uuid 验证码标识
     * @param code 验证码
     * @return 成功匹配返回true,否则false
     */
    public boolean validate(String uuid, String code) {

        String captchaKey = RedisKeys.getCaptchaKey(uuid);

        String text = redisUtils.get(captchaKey);
        if (text == null || "".equals(text)) {
            return false;
        }

        // 删除验证码
        redisUtils.delete(captchaKey);

        if (text.equals(code)) {
            return true;
        }

        return false;
    }

}
