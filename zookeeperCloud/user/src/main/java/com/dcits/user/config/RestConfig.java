package com.dcits.user.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Fox
 */
@Configuration
@Slf4j
public class RestConfig {
    
    @Bean
    @LoadBalanced  //客户端负载均衡
    public RestTemplate restTemplate() {
        log.info("这是调用ribbon服务");
        return new RestTemplate();
    }
    
    
}
