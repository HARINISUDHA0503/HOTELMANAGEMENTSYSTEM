package com.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableFeignClients(basePackages="com.manager.feignclient")
public class ManagerEndUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerEndUserApplication.class, args);
	}

}
