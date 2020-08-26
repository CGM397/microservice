package nju.cgm.gateway.config;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author: Bright Chan
 * @date: 2020/8/25 9:44
 * @description: 配置文件加载类
 */

@Configuration
public class PropertiesConfig {

    /**
     * 动态路由实现方式
     *
     * Primary: 优先实例化，
     *          使得这个zuulProperties的优先级高于
     *          zuul-org.springframework.cloud.netflix.zuul.filters.ZuulProperties
     *
     * RefreshScope: @RefreshScope使 zuul 的配置内容动态化
     *
     * ConfigurationProperties: 将配置文件中zuul为前缀的属性值加载到ZuulProperties中
     *                          可以将ZuulProperties改为其他配置类以达到动态修改对应属性的目的
     *                          相较于@Value，@ConfigurationProperties更加简洁
     *                          似乎可以不加@ConfigurationProperties，因为在ZuulProperties类中有此注解
     */
    @Bean
    @Primary
    @RefreshScope
//    @ConfigurationProperties(prefix = "zuul")
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }
}
