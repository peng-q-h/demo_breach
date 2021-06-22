package com.xyhj.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.xyhj.demo.mapper")
public class XxlJobApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(XxlJobApplication.class,args);
	}
	
}
