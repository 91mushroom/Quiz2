package cn._91mushroom.Q3;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXXmlParseHandler extends DefaultHandler {
   
	private Project project;
	private String currentElement;
	private List<Dependency> dependencies;
	
	@Override
	public void startDocument() throws SAXException {
	    // TODO Auto-generated method stub
	    super.startDocument();
	    
	    project = new Project();
	    dependencies = new ArrayList<>();
	    System.out.println("xml解析开始");
	}
	
	@Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("xml解析完成");
    }
	
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        
    	currentElement = qName.trim();
        
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    	// TODO Auto-generated method stub
    	super.endElement(uri, localName, qName);
    }
    
    @Override    public void characters(char[] ch, int start, int length) throws SAXException {
    	super.characters(ch, start, length);
    	
    	
    	
    	String context = new String(ch, start, length).trim();
    	switch(currentElement) {
    	case CurrentStageValue.MODEL_VERSION:
    		
    		if(!"".equals(context)) {
    			project.setModelVersion(context);
    		}
    		
    		break;
    		
    	case CurrentStageValue.GROUP_ID:
    		if(!"".equals(context)) {
    			if (project.getGroupId() == null) {
    				project.setGroupId(context);
    			}else {
    				
    			}
    		    
    		}
    		break;
    		
    	case CurrentStageValue.ARTIFACT_ID:
    		if(!"".equals(context)) {
    			if (project.getArtifactId() == null) {
    				project.setArtifactId(context);
    			}else {
    				
    			}
    		}
    		break;
    		
    	case CurrentStageValue.VERSION:
    		if(!"".equals(context)) {
    			if (project.getVersion() == null) {
    				project.setVersion(context);
    			}else {
    				
    			}
    		}
    		break;
    		
    	default:
    		break;
    	}
    }

	public Project getResult() {
		
		return project;
		
	}
   
}
