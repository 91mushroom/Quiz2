package cn._91mushroom.Q3;

public class Q3_1 {

	public static void main(String[] args) {

		//dom解析方式
		Project project = XML2JavaBeanUtils.XML2JavaBeanByDOM("pom.xml");
		System.out.println(project);
	}
}
