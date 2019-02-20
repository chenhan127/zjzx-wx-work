package com.zjzx.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ZjzxServerConfig {
	
//	public static final String URL = "http://47.101.58.43:8185";
	//public static final String URL = "http://172.19.163.230:8185";
	//public static final String URL = "http://127.0.0.1:8181";
	@Value("${zjzx.api.url}")
	private String url;
	public String getUrl() {
		return this.url;
	}
	
	

}
