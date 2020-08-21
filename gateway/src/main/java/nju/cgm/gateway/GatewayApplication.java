package nju.cgm.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    // 优先实例化
    // 使得这个zuulProperties的优先级高于zuul-org.springframework.cloud.netflix.zuul.filters.ZuulProperties
    @Primary
    //该注解使 zuul 的配置内容动态化
    @RefreshScope
    @ConfigurationProperties(prefix = "zuul")
    public ZuulProperties zuulProperties() {
        return new ZuulProperties();
    }

}
