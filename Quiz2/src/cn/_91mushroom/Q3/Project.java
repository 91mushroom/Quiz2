package cn._91mushroom.Q3;

import java.util.List;

public class Project {
	
	private String modelVersion;
	private String groupId;
	private String artifactId;
	private String version;
	private List<Dependency> dependencies;
	
	
	
	public List<Dependency> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<Dependency> dependencies) {
		this.dependencies = dependencies;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getModelVersion() {
		return modelVersion;
	}

	public void setModelVersion(String modelVersion) {
		this.modelVersion = modelVersion;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Project [modelVersion=" + modelVersion + ", groupId=" + groupId + ", artifactId=" + artifactId
				+ ", version=" + version + ", dependencies=" + dependencies + "]";
	}


	
	
	
	
}
