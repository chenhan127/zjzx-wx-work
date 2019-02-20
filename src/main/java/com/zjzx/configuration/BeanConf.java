package com.zjzx.configuration;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.jfinal.aop.Duang;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.tx.Tx;
import com.zjzx.service.UserService;

@Configuration
public class BeanConf {

	@Resource
	private DataSource dataSource;

	@Bean(initMethod = "start", destroyMethod = "stop")
	public ActiveRecordPlugin init() {
		ActiveRecordPlugin arp = new ActiveRecordPlugin(dataSource);
		System.out.println("数据库启动成功");
		return arp;
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public RestTemplate restIpTemplate() {
		return new RestTemplate();
	}
	
	
	
	/********service*********/
	@Bean
	public UserService userService() {
		return Duang.duang(UserService.class, Tx.class);
	}

}
