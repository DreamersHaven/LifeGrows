package com.dreamershaven;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

 

@EnableTransactionManagement
@ServletComponentScan
@SpringBootApplication
@EnableCaching
//@ComponentScan(basePackages= {"com.example.demo.controller","com.example.demo.service"})
@MapperScan(basePackages = { "com.dreamershaven.wechat.mapper","com.dreamershaven.design.config" })
//@EnableAutoConfiguration
@EnableAsync
@EnableScheduling
@Configuration
@EnableAutoConfiguration // 自动加载配置信息
public class WechatApplication extends SpringBootServletInitializer{
	 
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		//applicationContext = SpringApplication.run(WechatApplication.class, null);
		return builder.sources(WechatApplication.class);
	}

	public static void main(String[] args) {

		 SpringApplication.run(WechatApplication.class, args);
		 
		System.out.println("ヾ(◍°∇°◍)ﾉﾞ    dreamersHaven wechat模块启动成功      ヾ(◍°∇°◍)ﾉﾞ\n"
				+ " ______                    _   ______            \n"
				+ "|_   _ \\                  / |_|_   _ `.          \n"
				+ "  | |_) |   .--.    .--. `| |-' | | `. \\  .--.   \n"
				+ "  |  __'. / .'`\\ \\/ .'`\\ \\| |   | |  | |/ .'`\\ \\ \n"
				+ " _| |__) || \\__. || \\__. || |, _| |_.' /| \\__. | \n"
				+ "|_______/  '.__.'  '.__.' \\__/|______.'  '.__.'  ");
	}
}
