package com.zjzx.dao;

import org.springframework.stereotype.Repository;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

@Repository
public class UserDao {
	
	private static final String tableName = "user";
	/**
	 * 根据openid 获取用户
	 * @param openid
	 * @return
	 */
	public Record getUserByOpenid(String openid) {
		// TODO Auto-generated method stub
		String sql = "select * from user where openid=?";
		Record user = Db.findFirst(sql,openid);
		return user;
	}
	/**
	 * 保存用户
	 * @param wx_user_record
	 */
	public void saveUser(Record wx_user_record) {
		// TODO Auto-generated method stub
		Db.save(tableName, wx_user_record);
	}
	/**
	 * 更新用户
	 * @param wx_user_record
	 */
	public void updateUser(Record wx_user_record) {
		// TODO Auto-generated method stub
		Db.update(tableName, wx_user_record);
		
	}
	
	

}
