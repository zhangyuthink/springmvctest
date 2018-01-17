package com.zhangyu.cmms.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//this class used for configure your project
//the values in this class should be static and will be visited by other class
//you should eidt these values when your environment changed

class Configure {
 // user name
 public final static String USERNAME = "root";
 // password
 public final static String PASSWORD = "123456";
 // your database name
 public final static String DBNAME   = "springmvctest";
 // mysql driver
 public final static String DRIVER   = "com.mysql.jdbc.Driver";
 // mysql url
 public final static String URL      = "jdbc:mysql://localhost:3306/" + DBNAME;
 // must bigger than the number of the keyword in your database table 

}
public class MyDB {
    /**
     * -------------
     * # if you want to connect mysql, you should go to com.teamghz.configure.MysqlConnecter.java to edit information
     * --------------
     * # insert/update -> int update(String sql) : "sql" is what you want to execute
     * # return a integer, when 0 -> false; when other(n) success and this operation affect n lines
     * --------------
     * # delete        -> int delete(String sql) : "sql" is what you want to execute
     * # return a integer, when 0 -> false; when other(n) success and this operation affect n lines
     * --------------
     * # query         -> ArrayList<Map<String, String>> select(String sql, String tableName) : 
     *                                      "sql" is what you want to execute
     *                                      "tableName" is the table name which you want to operate
     * # return a ArrayList, the elements in the ArrayList is Map<String, String>
     * # every Map is one query result
     * # when you need to use the data returned:
     * ArrayList<Map<String, String>> result = mc.select("select * from User", "User");
     *  for (Map<String, String> map : result) {
     *      System.out.println("______________________");
     *      for(Map.Entry<String, String> entry:map.entrySet()){    
     *            System.out.println(entry.getKey()+"--->"+entry.getValue());    
     *      }
     *  }
     * --------------
     * 
     */
    public static void main(String[] args) {
    	MyDB mc = new MyDB();
        // insert
        //mc.update("insert into User values(3, \"xiaoshitouer\", \"xiaoshitouer@gmail.com\", \"123\", 20160930)");
        // update
        //System.out.println(mc.update("update User set passwd=\"liuxiaoliu\" where userid=2"));
        // delete
        //System.out.println(mc.delete("delete from User where userid=3"));
        // select
        ArrayList<Map<String, String>> result = mc.select("select * from TUser", "TUser");
        // map的遍历方法
        for (Map<String, String> map : result) {
            System.out.println("______________________");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "--->" + entry.getValue());
            }
        }
    }
    private Connection connection = null;
    private boolean connected = false;

    public MyDB() {
        try {
            Class.forName(Configure.DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("ERROR AT MysqlConnecter");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(Configure.URL, Configure.USERNAME, Configure.PASSWORD);
            connected = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(String sql)  
    {  
        int lineNum = 0;
        if (!connected) return 0;
        try{  
            PreparedStatement preStmt = connection.prepareStatement(sql);    
            lineNum = preStmt.executeUpdate();  
            preStmt.close();
        }  
        catch (SQLException e)  
        {  
            e.printStackTrace();  
        }  
        return lineNum; 
    }

    public int update(String sql)
    {  
        int lineNum = 0;
        if (!connected) return 0;
        try{  
            PreparedStatement preStmt = connection.prepareStatement(sql);   
            lineNum = preStmt.executeUpdate();  
            preStmt.close();
        }  
        catch (SQLException e)  
        {  
            e.printStackTrace();  
        }  
        return lineNum;
    }  
    public ArrayList<Map<String, String>> select(String sql, String tableName)
    {   
        ArrayList<Map<String, String>> result = new ArrayList<>();

        try  
        {  
            Statement stmt = connection.createStatement();  
            ResultSet rs = stmt.executeQuery(sql);
            String[] frame = getFrame(tableName);
            while (rs.next())  
            {  
                Map<String, String> tmp = new HashMap<>();
                for (String key : frame) {
                    if (key == "#") break;
                    tmp.put(key, rs.getString(key));
                }
                result.add(tmp);
            }
            rs.close();
            stmt.close();
        }  
        catch (SQLException e)  
        {  
            e.printStackTrace();  
        }  
        return result;  
    }
    public int delete(String sql)  
    {   
        int lineNum = 0;    
        try  
        {  
            Statement stmt = connection.createStatement();  
            lineNum = stmt.executeUpdate(sql);  
            stmt.close();
        }  
        catch (SQLException e)  
        {  
            e.printStackTrace();  
        }  
        return lineNum;  
    }  
    // 获取当前表的关键字，并以字符串数组的形式返回：如“username”，“id“等
    private String[] getFrame(String tableName) {
        String[] result = new String[getTableColums(tableName)];
         try  
            {  
                Statement stmt = connection.createStatement();  
                ResultSet rs = stmt.executeQuery("show columns from " + tableName);
                int i = 0;
                while (rs.next())  
                {  
                    result[i++] = rs.getString(1);
                }
                result[i-1] = "#";
                rs.close();
                stmt.close();
            }  
            catch (SQLException e)  
            {  
                e.printStackTrace();  
            }  
         return result;
    }
 // 获取当前表的关键字，并以字符串数组的形式返回：如“username”，“id“等
    private int getTableColums(String tableName) {
        int result =0;
         try  
            {  
                Statement stmt = connection.createStatement();  
                ResultSet rs = stmt.executeQuery("select count(*) from information_schema.columns where table_name='" + tableName+"'");
                while (rs.next())
                {
                    result=rs.getInt(1);
                }
                rs.close();
                stmt.close();
            }
            catch (SQLException e)  
            {
                e.printStackTrace();
            }
         return result;
    }
    //最后关闭数据库连接
    public void closeConn(){
        try {
            if (connection!=null) {
            	connection.close();//关闭结果集对象
            	connected=false;
            }            
        } catch (Exception e) {            
            e.printStackTrace();
        }
    }
}
