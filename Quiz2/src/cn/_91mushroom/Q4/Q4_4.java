package cn._91msuhroom.Q4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * 查询数据库中名字为刘建国20000的记录
 * 关闭了数据库的查询缓存
 * 
 * 为name创建索引：ALTER TABLE `students` ADD INDEX name_index ( `name` );
 * 删除name的索引：DROP INDEX name_index ON students;
 * 未创建索引时用时604ms，创建索引时用时34ms
 * @author H.H
 *
 */

public class Q4_4 {
	public static void main(String[] args) {
		Connection conn = Utils.getConnection();
		
		String sql1 = "select * from students where name = '刘建国20000'";
		ResultSet rs = null;
		
		try {
			
			Statement statement = Utils.getStatement();
			
			long start = System.currentTimeMillis();
			rs = statement.executeQuery(sql1);
			long end = System.currentTimeMillis();
			
			System.out.println("查询用时：" + (end -start) + "ms");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if( rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		Utils.close();
	}
}
