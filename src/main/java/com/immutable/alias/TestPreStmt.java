package com.immutable.alias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestPreStmt {

	 public static void main(String[] args) {
		  ResultSet rs = null;
		  Connection conn = null;
		  PreparedStatement pst = null;
		     try {
		       //第一步：加载MySQL的JDBC的驱动
		          Class.forName("oracle.jdbc.driver.OracleDriver"); 
		        //取得连接的 url,能访问MySQL数据库的用户名,密码；数据库名
		          String url = "jdbc:oracle:thin:@localhost:1521:cgq";
		          String user = "scott";
		          String password = "tiger";
		        //第二步：创建与MySQL数据库的连接类的实例
		          conn = DriverManager.getConnection(url, user, password);
		        //第三步：用conn创建Statement对象类实例 stmt
		          String sql = "select id,name from student where id=? and name=?";
		          pst = conn.prepareStatement(sql);   
		          pst.setString(1, "200001");
		          pst.setString(2, "张一");
		          rs = pst.executeQuery();
		          while(rs.next()){
		        	  System.out.println(rs.getString("id"));
		        	  System.out.println(rs.getString("name"));
		          }
		         
		         String ps = "insert into student(id,name,age) values(?,?,?)"; 
		         pst = conn.prepareStatement(ps);
		         pst.setString(1, "200005");
		         pst.setString(2, "pig");
		         pst.setInt(3, 4);
		         pst.executeUpdate();
		     } catch (ClassNotFoundException e) {  
		     //加载JDBC错误,所要用的驱动没有找到
		      System.out.println("驱动加载错误");
		  }catch (SQLException ex) {
		    //显示数据库连接错误或查询错误
		    System.err.println("SQLException:"+ex.getMessage());
		  }finally {
		     try{
		      
		         if(pst != null) {
		          pst.close();
		          pst = null;
		         }
		         if(conn != null) {
		          conn.close();
		          conn = null;
		         }
		     }catch(SQLException e) {
		      System.err.println("SQLException:"+e.getMessage());
		     }
		  }
		 }
}
