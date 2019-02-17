package cn.zsxmlv.config;

import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("index")
    public String index(HttpServletRequest request) {
        request.setAttribute("user","jack");

        return "modules/index";
    }

    @ResponseBody
    @RequestMapping("/test1")
    public String test1(String password,String salt) {

        String s = new Sha256Hash(password, salt).toHex();
        System.out.println(s);
        return s;
    }



}
