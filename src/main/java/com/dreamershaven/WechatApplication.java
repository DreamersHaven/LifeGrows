package com.dreamershaven;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dreamershaven.wechat.util.SpringUtil;

@EnableTransactionManagement
@ServletComponentScan
@SpringBootApplication
@EnableCaching
//@ComponentScan(basePackages= {"com.example.demo.controller","com.example.demo.service"})
@MapperScan(basePackages = { "com.dreamershaven.wechat.mapper" })
//@EnableAutoConfiguration
@EnableAsync
@EnableScheduling
@Configuration
@EnableAutoConfiguration // 自动加载配置信息
public class WechatApplication {
	//依据bean的名称获取bean,用于微信公众平台的管理员的管理操作
	private static ApplicationContext applicationContext;

	public static void main(String[] args) {

		applicationContext = SpringApplication.run(WechatApplication.class, args);
		SpringUtil.setApplicationContext(applicationContext);
		System.out.println("ヾ(◍°∇°◍)ﾉﾞ    dreamersHaven wechat模块启动成功      ヾ(◍°∇°◍)ﾉﾞ\n"
				+ " ______                    _   ______            \n"
				+ "|_   _ \\                  / |_|_   _ `.          \n"
				+ "  | |_) |   .--.    .--. `| |-' | | `. \\  .--.   \n"
				+ "  |  __'. / .'`\\ \\/ .'`\\ \\| |   | |  | |/ .'`\\ \\ \n"
				+ " _| |__) || \\__. || \\__. || |, _| |_.' /| \\__. | \n"
				+ "|_______/  '.__.'  '.__.' \\__/|______.'  '.__.'  ");
	}
}
