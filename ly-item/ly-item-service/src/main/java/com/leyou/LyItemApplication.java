package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created with IDEA
 *
 * @author：JiangYuzhen
 * @date：2019/7/21
 * @time: 0:52
 * @description: TODO
 */
@EnableDiscoveryClient
@SpringBootApplication
public class LyItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyItemApplication.class,args);
    }
}
