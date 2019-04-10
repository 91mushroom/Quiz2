package cn._91mushroom.Q3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.alibaba.fastjson.JSON;

public class JSONUtils {
	
	/**
	 * 将java对象转换成json文件
	 * @param project
	 */
	public static void Object2Json(Project project) {
		
		String jsonString  = JSON.toJSONString(project);
		
		File jsonFile = new File("pom.json");
		
		OutputStream fileOutput = null;
		
		try {
			
			fileOutput = new FileOutputStream(jsonFile);
			fileOutput.write(jsonString.getBytes());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			if (fileOutput != null) {
				
				try {
					fileOutput.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
	}
    
	/**
	 * 将json文件转换成java对象
	 * @param string
	 */
	public static Object Json2Object(String fileName) {
	
		FileInputStream fileInput = null;
		
		Object object = null;
		
		try {
			
			fileInput = new FileInputStream(fileName);
			
			byte[] buffer = new byte[1024];
			
			int len = 0;
			
			String jsonString = "";
			
			while((len = fileInput.read(buffer)) != -1) {
				
				jsonString += new String(buffer, 0 , len);
				
			}
			
			System.out.println(jsonString);
			
			object  = JSON.parseObject(jsonString, Project.class);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			if (fileInput != null) {
				
				try {
					
					fileInput.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		return object;
	}
}
