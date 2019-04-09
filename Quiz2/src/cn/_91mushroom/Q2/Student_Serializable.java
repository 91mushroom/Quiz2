package cn._91mushroom.Q2;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 学生类实现了Serializable接口
 * @author Administrator
 *
 */
public class Student_Serializable implements Serializable{
	
	private String name;//姓名、
	private double score;//分数
	private String[] addresses;//曾经的住址
	
	public Student_Serializable() {
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
	
	
	
}
