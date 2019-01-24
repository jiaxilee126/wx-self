package com.lee.self.wxapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lee.self"})
public class WxapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WxapiApplication.class, args);
	}

}

