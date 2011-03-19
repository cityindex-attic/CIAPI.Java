package codegen.modelobjects;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;

import codegen.codecreation.MethodCreator;

import CIAPI.Java.JsonApi;
import CIAPI.Java.cachestuff.CachedJsonClient;

public class SMDDescriptor {

	private String SMDVersion;
	private String version;
	private String id;
	private String target;
	private String schema;
	private String description;
	private boolean additionalParameters;
	private Map<String, Service> services;

	public String getSMDVersion() {
		return SMDVersion;
	}

	public String getVersion() {
		return version;
	}

	public String getId() {
		return id;
	}

	public String getTarget() {
		return target;
	}

	public String getSchema() {
		return schema;
	}

	public String getDescription() {
		return description;
	}

	public boolean isAdditionalParameters() {
		return additionalParameters;
	}

	public Map<String, Service> getServices() {
		return services;
	}

	public String toCode(String packageName) throws FileNotFoundException {
		return new MethodCreator(this, packageName).toCode();
	}
}
