package codegen.modelobjects;

import java.util.Map;

public class DataMethod {
	private Map<String, Service> services;
	private String target;

	public String getTarget() {
		return target;
	}

	public Map<String, Service> getServices() {
		return services;
	}
}
