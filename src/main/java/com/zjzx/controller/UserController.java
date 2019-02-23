package com.zjzx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.zjzx.clientservice.zjzx_wx.WxCientService;
import com.zjzx.constant.ZjzxServerConfig;
import com.zjzx.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	RestTemplate restIpTemplate;
	
	@Autowired
	UserService userService;
	@Autowired
	ZjzxServerConfig zjzxServerConfig;
	@Autowired
	WxCientService wxCientService;
	
	@RequestMapping("getSysUser")
	@ResponseBody
	public JSONObject getSysUser(String openid,String access_token) {
		
		//JSONObject wx_user = restIpTemplate.getForObject("http://wx.zjzx.xyz/zjzx-wx/wx/getWxUser?openid={openid}&access_token={access_token}", JSONObject.class, openid,access_token);
		JSONObject wx_user = restTemplate.getForObject("http://zjzx-wx/wx/getWxUser?openid={openid}&access_token={access_token}", JSONObject.class, openid,access_token);
		//JSONObject wx_user =wxCientService.getWxUser(openid, access_token);
		String unionid = wx_user.getString("unionid");
		String url = zjzxServerConfig.getUrl();
		
		JSONObject userMap = restIpTemplate.getForObject(url+"/user/getUserByWxUid?uid="+unionid, JSONObject.class);
		JSONObject app_user = userMap.getJSONObject("user");
		JSONObject resMap = new JSONObject();
		resMap.put("status", "success");
		resMap.put("wx_user", wx_user);
		resMap.put("app_user", app_user);
		return resMap;
	}
	@RequestMapping("health")
	public String health() {
		return "health";
	}

}
