package CIAPI.Java.examples.stackexchange;

public class Site {

	private String name;
	private String logo_url;
	private String api_endpoint;
	private String site_url;
	private String description;
	private String icon_url;
	private String[] aliases;
	private State state;
	private Styling styling;

	public String getName() {
		return name;
	}

	public String getLogo_url() {
		return logo_url;
	}

	public String getApi_endpoint() {
		return api_endpoint;
	}

	public String getSite_url() {
		return site_url;
	}

	public String getDescription() {
		return description;
	}

	public String getIcon_url() {
		return icon_url;
	}

	public String[] getAliases() {
		return aliases;
	}

	public State getState() {
		return state;
	}

	public Styling getStyling() {
		return styling;
	}

	public static enum State {
		normal, closed_beta, open_beta, linked_meta;
	}
}
