package cn._91mushroom.Q3;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtils {
	
	/**
	 * dom解析方式
	 * @param doc
	 * @return
	 */
	public static Project XML2JavaBeanByDOM(String filename) {
		
		Document doc = null;

		DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder docb = docbf.newDocumentBuilder();
			doc = docb.parse(filename);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Project project = new Project();
		
		Node projectNode = doc.getElementsByTagName("project").item(0);
		
		//获取project的所有子节点
		NodeList nodeLlist = projectNode.getChildNodes();
		
		project.setModelVersion(nodeLlist.item(1).getTextContent());
		project.setGroupId(nodeLlist.item(3).getTextContent());
		project.setArtifactId(nodeLlist.item(5).getTextContent());
		project.setVersion(nodeLlist.item(7).getTextContent());
		
		List<Dependency> dependencies = new ArrayList<>();
		
		//获取Dependencies节点
		Node dependenciesNode = nodeLlist.item(13);
		//获取Dependencies节点的所有子节点
		NodeList denpendencyNodeList = dependenciesNode.getChildNodes();
		
		
		for (int i = 1; i * 2 -1 < denpendencyNodeList.getLength(); i++) {
			
			Node temp = denpendencyNodeList.item(i * 2 -1);
			
			Dependency dependency = new Dependency();
			
			NodeList dependencyChildNodes = temp.getChildNodes();

			dependency.setGroupId(dependencyChildNodes.item(1).getTextContent());
			dependency.setArtifactId(dependencyChildNodes.item(3).getTextContent());
			dependency.setVersion(dependencyChildNodes.item(5).getTextContent());
			
			if (dependencyChildNodes.getLength() > 7) {
				dependency.setScope(dependencyChildNodes.item(7).getTextContent());
			}
			
			dependencies.add(dependency);
			
		}
		
		project.setDependencies(dependencies);
		
		
		return project;
	}
	
	/**
	 * SAX方式解析
	 * @param doc
	 * @return
	 */
	public static Project XML2JavaBeanBySAX(String filename) {
		
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		SAXXmlParseHandler saxXmlParseHandler = new SAXXmlParseHandler();
		try {
			
			SAXParser saxParser = saxParserFactory.newSAXParser();
			
			saxParser.parse(filename, saxXmlParseHandler);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saxXmlParseHandler.getResult();
	}
}
