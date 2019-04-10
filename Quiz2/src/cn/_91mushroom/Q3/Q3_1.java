package cn._91mushroom.Q3;

public class Q3_1 {

	public static void main(String[] args) {

		//dom解析方式
		Project project = XMLUtils.XML2JavaBeanByDOM("pom.xml");
		System.out.println(project);
		
//		Project project = XML2JavaBeanUtils.XML2JavaBeanBySAX("pom.xml");
//		System.out.println(project);
		
		//将java对象转换成json并写入文件
		JSONUtils.Object2Json(project);
		
		//将json文件转换成java对象
		Project  newProject = (Project)JSONUtils.Json2Object("pom.json");
		System.out.println(newProject);
	}
}
