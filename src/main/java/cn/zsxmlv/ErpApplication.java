package cn.zsxmlv;

import cn.zsxmlv.common.utils.RedisUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ErpApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ErpApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ErpApplication.class);
    }
}

