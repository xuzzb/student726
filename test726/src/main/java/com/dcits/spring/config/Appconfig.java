package com.dcits.spring.config;

import com.dcits.myspring.anno.XuzzCompontentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Spring容器的配置类，作为Spring容器的一些初始参数，比如componentScan的输入等
 */
@ComponentScan("com.dcits.spring.service")
public class Appconfig {

}
