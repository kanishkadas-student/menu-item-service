package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = "com")
@EnableFeignClients(basePackages = "com")
public class MenuItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuItemServiceApplication.class, args);
		log.info("server started at 8100");
	}

}
