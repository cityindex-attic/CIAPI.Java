package codegen.modelobjects;

import java.util.Map;

public class SMDDescriptor {

	private String SMDVersion;
	private String version;
	private String id;
	private String target;
	private String schema;
	private String description;
	private boolean additionalParameters;
	private Map<String, DataMethod> services;

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
		return services.get("rpc").getServices();
	}
	@Override
	public String toString() {
		return SMDVersion + ": " + version;
	}
}
