package cn._91mushroom.Q4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

/**
 * 向数据库中插入100万条数据
 * @author H.H
 *
 */
public class Q4_3 {
	
	
	public static void insertMillionStudents() {
			Connection conn = Utils.getConnection();
			
			String sql = "insert into students(name,score) values(?,?)";
			Random random = new Random();
			
			PreparedStatement ps = null;
			
			try {
				
				conn.setAutoCommit(false);
				ps = conn.prepareStatement(sql);
				
				
				
				for (int i = 0; i < 100; i++) {
					for (int j = 1; j <= 10000; j++) {
						ps.setString(1, "刘建国" + (i*10000 + j));
						ps.setDouble(2, random.nextInt(101));
						ps.execute();
					}
					conn.commit();
					System.out.println("已经插入：" + (i+1)*10000 + "条");
				}
				
				
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
			Utils.close();
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		insertMillionStudents();
		long end = System.currentTimeMillis();
		System.out.println("插入用时：" + (end - start)/1000.0 + "秒");
	}
}
