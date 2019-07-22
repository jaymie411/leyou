package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created with IDEA
 *
 * @author：JiangYuzhen
 * @date：2019/7/20
 * @time: 23:24
 * @description: TODO
 */
@EnableZuulProxy
@SpringCloudApplication
public class LyGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyGatewayApplication.class, args);
    }
}
