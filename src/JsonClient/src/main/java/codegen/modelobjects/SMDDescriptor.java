package codegen.modelobjects;

import java.util.Map;
import java.util.Map.Entry;

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

	public String toCode(String packageName) {
		String packageDescriptor = "package " + packageName + ";\n\n";
		String classDescriptor = "public class ServiceMethods {\n";
		StringBuilder methodBuilder = new StringBuilder();
		for (Entry<String, Service> entry : services.entrySet()) {
			methodBuilder.append(entry.getValue().toCode(packageName));
		}
		String methods = methodBuilder.toString();
		String classEnd = "}\n";
		return packageDescriptor + classDescriptor + methods + classEnd;
	}
}
