package cn._91msuhroom.Q4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 使用JDBC操作students表
 * @author H.H
 *
 */
public class Q4_2 {
	

	/**
	 * 执行出入的sql语句
	 * @param sql
	 * @param statement
	 */
	public static void executeSql(String sql, Statement statement ) {
		try {

			statement.execute(sql);
			System.out.println("操作成功");
	
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
	}
	
	
	
	public static void main(String[] args) {
	
		
		//插入一条学生记录
		String sql1 = "insert into students(id,name,score) value(1,'尼古拉斯',60.5)";
		executeSql(sql1, Utils.getStatement());
		
		//更新学生信息
		String sql2 = "update students set name = '尼古拉斯.赵四'";
		executeSql(sql2, Utils.getStatement());
		
		//删除学生信息
		String sql3 = "delete from students where id = 1";
		executeSql(sql3, Utils.getStatement());
		
		//关闭连接
		Utils.close();
		
		
	}
}
