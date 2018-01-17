package com.zhangyu.cmms.bean;

import java.util.Map;

public class User {
	/**
	 * 根据Key和value值来构造
	 * @param map
	 */
	public User(Map<String, String> map) {
		this.userID=map.get("FuserID");
		this.userName=map.get("FuserName");
		this.passWord=map.get("FpassWord");
		this.creditID=map.get("FcreditID");
		this.organID=map.get("ForganID");
		this.permission=map.get("Fpermission");
		this.telphone=map.get("Ftelphone");
		this.email=map.get("Femail");
		this.remark=map.get("Fremark");
	}
	@Override
	public String toString() {
		return "User:[userID="+userID+
				",userName="+userName+
				",passWord="+passWord+
				",creditID="+creditID+
				",organID="+organID+
				",permission="+permission+
				",telphone="+telphone+
				",email="+email+
				",remark="+remark+"]";
	}
	//用户登录ID
	private String userID;
	//用户名称
	private String userName;
	//用户密码
	private String passWord;
	//信贷系统号
	private String creditID;
	//机构号
	private String organID;
	//权限描述
	private String permission;
	//手机号
	private String telphone;
	//邮箱
	private String email;
	//备注
	private String remark;
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getCreditID() {
		return creditID;
	}
	public void setCreditID(String creditID) {
		this.creditID = creditID;
	}
	public String getOrganID() {
		return organID;
	}
	public void setOrganID(String organID) {
		this.organID = organID;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
