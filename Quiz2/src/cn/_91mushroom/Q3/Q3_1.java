package cn._91mushroom.Q3;

public class Q3_1 {

	private static final String XML_FILE_NAME = "pom.xml"; 
	private static final String JSON_FILE_NAME = "pom.json"; 
	
	public static void main(String[] args) {

		//dom解析方式
		Project domProject = XMLUtils.XML2JavaBeanByDOM(XML_FILE_NAME);
		System.out.println("DOM解析方式");
		System.out.println(domProject);
		
		//sax方式解析
		Project saxProject = XMLUtils.XML2JavaBeanBySAX(XML_FILE_NAME);
		System.out.println("SAX解析方式");
		System.out.println(saxProject);
		
		//jdom解析方式
		System.out.println("JDOM解析方式");
		Project jdomProject = XMLUtils.XML2JavaBeanByJDOM(XML_FILE_NAME);
		System.out.println(jdomProject);
		
		//dom4j解析方式
		System.out.println("DOM4j解析方式");
		Project dom4jProject = XMLUtils.XML2JavaBeanByDOM4j(XML_FILE_NAME);
		System.out.println(dom4jProject);
		
		//将java对象转换成json并写入文件
		JSONUtils.Object2Json(domProject);
		
		//将json文件转换成java对象
		System.out.println("json转换成java对象");
		Project  newProject = (Project)JSONUtils.Json2Object(JSON_FILE_NAME);
		System.out.println(newProject);
		
	}
}
