package cn._91mushroom.Q2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Arrays;

/**
 * 学生类实现了Externalizable接口
 * @author Administrator
 *
 */
public class Student_externalizable implements Externalizable{

	private String name;//姓名、
	private double score;//分数
	private String[] addresses;//曾经的住址
	
	public Student_externalizable() {
		this.name = "尼古拉斯";
		this.score = 99.5;
		this.addresses =  new String[2];
		this.addresses[0] = "住址#1";
		this.addresses[1] = "住址#2";
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + ", addresses=" + Arrays.toString(addresses) + "]";
	}
	
	
	@Override
	public void readExternal(ObjectInput input) throws IOException, ClassNotFoundException {
		
		this.name = (String)input.readObject();
		this.score = (double)input.readObject();
		this.addresses = (String[])input.readObject();
	}

	@Override
	public void writeExternal(ObjectOutput output) throws IOException {
		
		output.writeObject(this.name);
		output.writeObject(this.score);
		output.writeObject(this.addresses);
	}

}
