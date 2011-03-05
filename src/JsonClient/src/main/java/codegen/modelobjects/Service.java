package codegen.modelobjects;

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

	/**
	 * @return the description of the method. This is essentially the Javadoc
	 *         comment
	 */
	public String getDescription() {
		if (description == null || description.trim().isEmpty()) {
			return "No description for this method is provided.";
		} else {
			return description;
		}
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

	/**
	 * @return the transport method of this method. Either 'GET' or 'SET' (or an
	 *         exception)
	 */
	public String getTransport() {
		if (transport == null || transport.equalsIgnoreCase("post") || transport.equalsIgnoreCase("get")) {
			return transport.toUpperCase();
		} else {
			throw new IllegalArgumentException("Sorry, the method must be either GET or POST.  Was instead "
					+ transport);
		}
	}

	/**
	 * @return the envelope this method transfers data in. (Must be JSON or URL)
	 */
	public String getEnvelope() {
		if (envelope == null || envelope.equalsIgnoreCase("url") || envelope.equalsIgnoreCase("json")) {
			return envelope.toUpperCase();
		} else {
			throw new IllegalArgumentException("Sorry, the envelope must be either URL or JSON.  Was instead "
					+ envelope);
		}
	}

	/**
	 * 
	 * @return the Object representing the type that this method returns
	 */
	public Return getReturns() {
		return returns;
	}

	/**
	 * A group is a logical grouping of methods that perform similar actions
	 * 
	 * @return the group this method belongs to
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * 
	 * @return The scope at which the API should be throttled
	 */
	public String getThrottleScope() {
		return throttleScope;
	}

	/**
	 * @return all of the parameters of this method.
	 */
	public Parameter[] getParameters() {
		if (parameters == null) {
			return new Parameter[] {};
		} else {
			return parameters;
		}
	}
}
