package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created with IDEA
 *
 * @author：JiangYuzhen
 * @date：2019/7/20
 * @time: 22:47
 * @description: TODO
 */
@EnableEurekaServer
@SpringBootApplication
public class LyRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyRegistryApplication.class, args);
    }
}
