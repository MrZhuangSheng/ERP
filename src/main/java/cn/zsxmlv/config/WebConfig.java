package cn.zsxmlv.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * web 配置
 */
@Configuration
public class WebConfig {

//    @Bean(name = "beetlConfig")
//    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
//        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
//        ClasspathResourceLoader classpathResourceLoader = new ClasspathResourceLoader();
//        beetlGroupUtilConfiguration.setResourceLoader(classpathResourceLoader);
//        beetlGroupUtilConfiguration.init();
//        return beetlGroupUtilConfiguration;
//    }
//
//    @Bean(name = "beetlViewResolver")
//    public BeetlSpringViewResolver getBeetlSpringViewResolver(
//            @Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
//        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
//        beetlSpringViewResolver.setPrefix("/templates/");
//        beetlSpringViewResolver.setSuffix(".html");
//        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
//        beetlSpringViewResolver.setOrder(0);
//        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
//        return beetlSpringViewResolver;
//    }

//    @Value("${beetl.templatesPath}")String templatesPath;
//    @Bean(name = "beetlConfig")
//    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
//        System.out.println("开始配置beetl" + templatesPath);
//        BeetlGroupUtilConfiguration configuration = new BeetlGroupUtilConfiguration();
//        //获取Spring Boot 的ClassLoader
//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        if (loader == null) {
//            loader = WebConfig.class.getClassLoader();
//        }
//
//        ClasspathResourceLoader templates = new ClasspathResourceLoader(loader,"");
//        configuration.setResourceLoader(templates);
//        configuration.init();
//        //如果使用了优化编译器，涉及到字节码操作，需要添加ClassLoader
//        configuration.getGroupTemplate().setClassLoader(loader);
//        return configuration;
//    }
//
//    @Bean(name = "beetlViewResolver")
//    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
//        BeetlSpringViewResolver resolver = new BeetlSpringViewResolver();
//        resolver.setContentType("text/html;charset=UTF-8");
////        resolver.setPrefix(".html");
//        resolver.setOrder(0);
//        resolver.setConfig(beetlGroupUtilConfiguration);
//        return resolver;
//    }

}
