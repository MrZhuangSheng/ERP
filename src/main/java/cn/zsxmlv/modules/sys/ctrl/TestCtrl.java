package cn.zsxmlv.modules.sys.ctrl;

import cn.zsxmlv.common.utils.RedisUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author: zs
 * @description:
 * @date: 2019/1/28 15:15
 */
@RestController
@RequestMapping("/test")
@Api("测试接口")
public class TestCtrl extends BaseCtrl {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/redisApi")
    public String redisApi(String key) throws UnsupportedEncodingException {
        System.out.println("================== redis start ================");

        String str = redisUtils.get(key);

        byte[] bytes = str.getBytes("GBK");

        String s = new String(bytes, "UTF-8");
        System.out.println(s);

        System.out.println("================== redis end ================");
        return s;
    }

}
