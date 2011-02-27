package modelobjects;

/**
 * Describes a method that the service described by the SMD provides.
 * 
 * @author Justin Nelson
 * 
 */
public class Service {

	private String description;
	private String target;
	private String uriTemplate;
	private String contentType;
	private String responseContentType;
	private String transport;
	private String envelope;
	private Return returns;
	private String group;
	private String throttleScope;
	private Parameter[] parameters;

	public String getDescription() {
		return description;
	}

	public String getTarget() {
		return target;
	}

	public String getUriTemplate() {
		return uriTemplate;
	}

	public String getContentType() {
		return contentType;
	}

	public String getResponseContentType() {
		return responseContentType;
	}

	public String getTransport() {
		return transport;
	}

	public String getEnvelope() {
		return envelope;
	}

	public Return getReturns() {
		return returns;
	}

	public String getGroup() {
		return group;
	}

	public String getThrottleScope() {
		return throttleScope;
	}

	public Parameter[] getParameters() {
		return parameters;
	}
}
