package cn._91mushroom.Q3;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Q3_1 {
	//https://github.com/hengyunabc/executable-embeded-tomcat-sample/blob/master/pom.xml
	public static Document parseXml(String filename) {
		
		Document doc = null;
		
		DocumentBuilderFactory docbf = DocumentBuilderFactory.newInstance();
		 try {
			 
			DocumentBuilder docb = docbf.newDocumentBuilder();
			doc = docb.parse(filename);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return doc;
	}
	
	public static void main(String[] args) {
		
		Document doc = parseXml("pom.xml");
		
		NodeList nodeList = doc.getElementsByTagName("dependencies");
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			NodeList childNodeList = node.getChildNodes();
			
			for(int  j = 0; j < childNodeList.getLength(); j++) {
				Node childNode = childNodeList.item(j);
				childNode.getChildNodes();
			}
		}
		
	}
}
