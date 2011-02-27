package modelobjects;

import java.util.Map;

public class SMDDescriptor {

	private String SMDVersion;
	private String version;
	private String id;
	private String target;
	private String schema;
	private String description;
	private boolean additionalParameters;
	private Map<String, Service> services;
}
