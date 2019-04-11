package cn._91mushroom.Q3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import org.jdom.input.SAXBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLUtils {

	/**
	 * dom解析方式
	 * 
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

		// 获取project的所有子节点
		NodeList nodeLlist = projectNode.getChildNodes();

		project.setModelVersion(nodeLlist.item(1).getTextContent());
		project.setGroupId(nodeLlist.item(3).getTextContent());
		project.setArtifactId(nodeLlist.item(5).getTextContent());
		project.setVersion(nodeLlist.item(7).getTextContent());

		List<Dependency> dependencies = new ArrayList<>();

		// 获取Dependencies节点
		Node dependenciesNode = nodeLlist.item(13);
		// 获取Dependencies节点的所有子节点
		NodeList denpendencyNodeList = dependenciesNode.getChildNodes();

		for (int i = 1; i * 2 - 1 < denpendencyNodeList.getLength(); i++) {

			Node temp = denpendencyNodeList.item(i * 2 - 1);

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
	 * 
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

	/**
	 * 通过jdom解析xml
	 * 
	 * @param fileName
	 * @return
	 */
	public static Project XML2JavaBeanByJDOM(String fileName) {

		Project project = new Project();

		SAXBuilder builder = new SAXBuilder();

		org.jdom.Document doc = null;

		try {

			doc = builder.build(new File(fileName));

		} catch (Exception e) {
			e.printStackTrace();
		}

		org.jdom.Element rootElement = doc.getRootElement();

		List<org.jdom.Element> rootChildern = rootElement.getChildren();

		for (org.jdom.Element element : rootChildern) {

			String tempElementName = element.getName();

			if ("modelVersion".equals(tempElementName)) {

				project.setModelVersion(element.getValue());

			} else if ("groupId".equals(tempElementName)) {

				project.setGroupId(element.getValue());

			} else if ("artifactId".equals(tempElementName)) {

				project.setArtifactId(element.getValue());

			} else if ("version".equals(tempElementName)) {

				project.setVersion(element.getValue());

			} else if ("dependencies".equals(tempElementName)) {

				List<org.jdom.Element> dependenciesChildren = element.getChildren();

				List<Dependency> dependencies = new ArrayList<Dependency>();

				for (int i = 0; i < dependenciesChildren.size(); i++) {
					
					List<org.jdom.Element> temp =  dependenciesChildren.get(i).getChildren();
					
					Dependency dependency = new Dependency();
					
					for (org.jdom.Element element2 : temp) {

						String tempElement2Name = element2.getName();
						
						if ("groupId".equals(tempElement2Name)) {
							
							dependency.setGroupId(element2.getValue());

						} else if ("artifactId".equals(tempElement2Name)) {

							dependency.setArtifactId(element2.getValue());

						} else if ("version".equals(tempElement2Name)) {

							dependency.setVersion(element2.getValue());

						} else if ("scope".equals(tempElement2Name)) {
							
							dependency.setScope(element2.getValue());
							
						}

					}
					dependencies.add(dependency);
				}
				project.setDependencies(dependencies);

			}
		}

		return project;
	}
	
	/**
	 * 通过DOM4j解析XML
	 * @param fileName
	 * @return
	 */
	public static Project XML2JavaBeanByDOM4j(String fileName) {
		
		SAXReader saxReader = new SAXReader();
		org.dom4j.Document doc = null;
		
        Project project = new Project();
		
		try {
			
			doc = saxReader.read(fileName);
		
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		org.dom4j.Element rootElement = doc.getRootElement();

		List<org.dom4j.Element> rootChildern = rootElement.elements();

		for (org.dom4j.Element element : rootChildern) {

			String tempElementName = element.getName();

			if ("modelVersion".equals(tempElementName)) {

				project.setModelVersion(element.getStringValue());

			} else if ("groupId".equals(tempElementName)) {

				project.setGroupId(element.getStringValue());

			} else if ("artifactId".equals(tempElementName)) {

				project.setArtifactId(element.getStringValue());

			} else if ("version".equals(tempElementName)) {

				project.setVersion(element.getStringValue());

			} else if ("dependencies".equals(tempElementName)) {

				List<org.dom4j.Element> dependenciesChildren = element.elements();

				List<Dependency> dependencies = new ArrayList<Dependency>();

				for (int i = 0; i < dependenciesChildren.size(); i++) {
					
					List<org.dom4j.Element> temp =  dependenciesChildren.get(i).elements();
					
					Dependency dependency = new Dependency();
					
					for (org.dom4j.Element element2 : temp) {

						String tempElement2Name = element2.getName();
						
						if ("groupId".equals(tempElement2Name)) {
							
							dependency.setGroupId(element2.getStringValue());

						} else if ("artifactId".equals(tempElement2Name)) {

							dependency.setArtifactId(element2.getStringValue());

						} else if ("version".equals(tempElement2Name)) {

							dependency.setVersion(element2.getStringValue());

						} else if ("scope".equals(tempElement2Name)) {
							
							dependency.setScope(element2.getStringValue());
							
						}

					}
					dependencies.add(dependency);
				}
				project.setDependencies(dependencies);

			}
		}
		
		
	   return project;
	}
	
}
