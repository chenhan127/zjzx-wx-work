package com.zjzx.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Record;
import com.zjzx.dao.UserDao;
import com.zjzx.util.DateUtil;
public class UserService {
	@Autowired
	UserDao userDao;
	
	@Async
	public void updateUser(JSONObject wx_user) {
		// TODO Auto-generated method stub
		wx_user.put("privilege", "");
		String openid = wx_user.getString("openid");
		Record h_user = userDao.getUserByOpenid(openid);
		
		Record wx_user_record = new Record();
		wx_user_record.setColumns(wx_user);
		
		if(h_user == null) {
			wx_user_record.set("createtime", DateUtil.convertY_M_D_H_M(new Date()));
			userDao.saveUser(wx_user_record);
			return;
		}
		wx_user_record.set("id", h_user.get("id")).set("createtime", h_user.getStr("createtime"));
		userDao.updateUser(wx_user_record);
		
	}

}
