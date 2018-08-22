package com.lzh.weixinservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.lzh.common.annotation.MyBatisRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.lzh.weixinservice","com.lzh.common.advice"})
@MapperScan(basePackages = "com.lzh.weixinservice.persistence", annotationClass = MyBatisRepository.class)
public class WeixinserviceApplication {

    public static void main(String[] args) {
    	ApplicationContext context =  SpringApplication.run(WeixinserviceApplication.class, args);
        
    }
}
