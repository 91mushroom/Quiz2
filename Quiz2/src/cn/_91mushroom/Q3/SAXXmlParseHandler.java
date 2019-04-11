package cn._91mushroom.Q3;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXXmlParseHandler extends DefaultHandler {
   
	private Project project;
	private String currentElement;
	private boolean isDependencies;
	private List<Dependency> dependencies;
	private Dependency dependency;
	
	@Override
	public void startDocument() throws SAXException {
	    // TODO Auto-generated method stub
	    super.startDocument();
	    
	    project = new Project();
	    dependencies = new ArrayList<>();
	}
	
	@Override
    public void endDocument() throws SAXException {
        super.endDocument();
        project.setDependencies(dependencies);
    }
	
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        
    	currentElement = qName.trim();
    	
    	
    	if(currentElement.equals("dependencies")) {
    		isDependencies = true;
    	}
    	
        
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
    			if (! isDependencies) {
    				if (project.getGroupId() == null) {
    				    project.setGroupId(context);
    				}
    			}else {
    				dependency = new Dependency();
    				dependencies.add(dependency);
    				dependency.setGroupId(context);
    			}
    		    
    		}
    		break;
    		
    	case CurrentStageValue.ARTIFACT_ID:
    		if(!"".equals(context)) {
    			if (! isDependencies) {
    				if (project.getArtifactId() == null) {
    					project.setArtifactId(context);
    				}
    			}else {
    				dependency.setArtifactId(context);
    			}
    		}
    		break;
    		
    	case CurrentStageValue.VERSION:
    		if(!"".equals(context)) {
    			if (! isDependencies) {
    				if (project.getVersion() == null) {
    				    project.setVersion(context);
    				}
    			}else {
    				dependency.setVersion(context);
    			}
    		}
    		break;
    	
    	case CurrentStageValue.SCOPE:
    		if(!"".equals(context)) {
    	        dependency.setScope(context);
    		}
    		
    	default:
    		break;
    	}
    }

	public Project getResult() {
		
		return project;
		
	}
   
}
