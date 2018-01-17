package com.zhangyu.cmms.service;

import java.util.Map;

import com.zhangyu.cmms.bean.User;
import com.zhangyu.cmms.dao.UserDao;

public class UserService {
	private UserDao userDao;
	public UserService() {
		userDao=new UserDao();
	}
	/**
	 * 获取所有用户
	 * @return
	 */
	public Map<String, User> getAllUser(){
		return userDao.getAllUser();
	}
	/**
	 * 根据userID获取用户
	 * @param userID
	 * @return
	 */
	public User getUserbyUserID(String userID) {
		return userDao.getUserByUserID(userID);
	}
	/**
	 * 根据用户ID及密码校验登陆
	 * @param userID
	 * @param passWord
	 * @return
	 */
	public boolean checkLogin(String userID,String passWord) {
		return userDao.checkLogin(userID,passWord);
	}
	/**
	 * 更新User
	 * @param user
	 * @return
	 */
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}
	/**
	 * 插入用户
	 * @param user
	 * @return
	 */
	public boolean insertUser(User user) {
		return userDao.insertUser(user);
	}
}
