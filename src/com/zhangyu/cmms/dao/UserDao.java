package com.zhangyu.cmms.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.zhangyu.cmms.bean.User;

public class UserDao {
	public Map<String, User> getAllUser(){
		Map<String, User> result=new HashMap<String, User>();
		MyDB myDB=new  MyDB();
        ArrayList<Map<String, String>> tmpresult = myDB.select("select * from tbl_user", "tbl_user");
        // map的遍历方法
        for (Map<String, String> map : tmpresult) {
        	result.put(map.get("FuserID"), new User(map));
        }
		return result;
	}
	public User getUserByUserID(String userID) {
		User result = null;
		MyDB myDB=new  MyDB();
        ArrayList<Map<String, String>> tmpresult = myDB.select("select * from tbl_user where userID='"+userID+"'", "tbl_user");
        // map的遍历方法
        for (Map<String, String> map : tmpresult) {
        	result=new User(map);
        }
		return result;	
	}
	public boolean checkLogin(String userID,String passWord) {
		boolean result = false;
		MyDB myDB=new  MyDB();
        ArrayList<Map<String, String>> tmpresult = myDB.select("select * from tbl_user where userID='"+userID+"' and passWord='"+passWord+"'", "tbl_user");
        if(tmpresult.size()>0) {
        	result=true;
        }
		return result;	
	}
	public boolean updateUser(User user) {
		boolean result=false;
		String sql;
		MyDB myDB=new  MyDB();
		sql="update tbl_user set userName='"+user.getUserName()+"',"
				+"passWord='"+user.getPassWord()+"'"
				+" where userID='"+user.getUserID()+"'";
		if (myDB.update(sql)>0) {
			result=true;
		}
		return result;
	}
	public boolean insertUser(User user) {
		boolean result=false;
		String sql;
		MyDB myDB=new  MyDB();
		sql="insert into tbl_user values ('"+user.getUserID()+"',"
				+"'"+user.getUserName()+"')";
		if (myDB.insert(sql)>0) {
			result=true;
		}
		return result;
	}
}
