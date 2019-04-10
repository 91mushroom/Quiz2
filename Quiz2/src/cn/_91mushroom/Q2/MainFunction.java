package cn._91mushroom.Q2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MainFunction {
	
	/**
	 * 序列化方法
	 * @param outPutFile
	 * @param object
	 */
	public static void serializeObject(File file, Object object) {
		OutputStream ops = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			
			//将对象序列化
			ops =  new FileOutputStream(file);
			
			objectOutputStream = new ObjectOutputStream(ops);
		
			objectOutputStream.writeObject(object);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			
			if (objectOutputStream != null) {
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (ops != null) {
				try {
					ops.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
		}
	}
	
	/**
	 * 反序列化方法
	 * @param file
	 * @return
	 */
	public static Object deserializeObject(File file) {
		
		Object object = null;
		InputStream ips = null;
		ObjectInputStream objectInputStream = null;
		
		if (!file.exists()) {
			return null;
		}
		
		try {
			
			
			ips = new FileInputStream(file);
			objectInputStream =  new ObjectInputStream(ips);
			
			object = objectInputStream.readObject();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			if(objectInputStream != null) {
				try {
					objectInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (ips != null) {
				try {
					ips.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
		}
		
		
		
		return object;
	}
	
	

	public static void main(String[] args) {
		
		/**
		 * 实现继承了Serializable接口的student的序列化和反序列化
		 */
		Student_Serializable studentSerializableBefore = new Student_Serializable();
		//序列化之前打印对象
		System.out.println(studentSerializableBefore);
		
		File file1 = new File("StudentSerializable.txt");
		//序列化
		serializeObject(file1, studentSerializableBefore);
		
		//反序列化
		Student_Serializable studentSerializableAfter = (Student_Serializable) deserializeObject(file1);
		System.out.println(studentSerializableAfter);
		

		/**
		 * 实现继承了Externalizable接口的student的序列化和反序列化
		 */
		Student_externalizable studentExternalizableBefore = new Student_externalizable();
		//序列化之前打印对象
		System.out.println(studentExternalizableBefore);
		
		File file2 = new File("StudentExternalizable.txt");
		//序列化
		serializeObject(file2, studentExternalizableBefore);
		//反序列化
		Student_externalizable studentExternalizableAfter = (Student_externalizable) deserializeObject(file2);
		System.out.println(studentExternalizableAfter);
	}
}
