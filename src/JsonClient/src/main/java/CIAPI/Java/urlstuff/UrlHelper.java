package CIAPI.Java.urlstuff;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Simple helper class for manipulating URLs.
 * 
 * @author Justin Nelson
 * 
 */
public class UrlHelper {
	private String baseUrl;
	private String extendedUrl;
	private Map<String, String> params;

	/**
	 * Creates a new UrlHelper with the given parts
	 * 
	 * @param baseUrl
	 * @param extendedUrl
	 * @param params
	 */
	public UrlHelper(String baseUrl, String extendedUrl, Map<String, String> params) {
		this.baseUrl = baseUrl;
		this.extendedUrl = extendedUrl;
		this.params = params;
	}

	/**
	 * Combines all of the parts of the url into a full url string
	 * 
	 * @return a legal url
	 */
	public String toUrl() {
		return createRoute(baseUrl, extendedUrl, params);
	}

	/**
	 * Returns the base component of the url
	 * 
	 * @return the base component of the url
	 */
	public String getBaseUrl() {
		return baseUrl;
	}

	/**
	 * Returns the extended directory
	 * 
	 * @return the extended directory
	 */
	public String getExtendedUrl() {
		return extendedUrl;
	}

	/**
	 * The url parameters of the url
	 * 
	 * @return url parameters of the url
	 */
	public Map<String, String> getParams() {
		return params;
	}

	/**
	 * Takes a full url and parses it into its various parts
	 * 
	 * @param fullUrl
	 * @return a new Url helper backed by the various parts
	 * @throws MalformedURLException
	 */
	public static UrlHelper parseUrl(String fullUrl) throws MalformedURLException {
		String regex = "(https?://[^ /?]+)(/[^?]+)?(\\?.*)?";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(fullUrl);
		if (!m.matches())
			throw new MalformedURLException("The url is not valid.");
		String baseUrl = m.group(1);
		String extendedUrl = m.group(2);
		String paramsPart = m.group(3);
		Map<String, String> map = new HashMap<String, String>();
		if (paramsPart != null) {
			paramsPart = paramsPart.substring(1); // chop of the beginning `?`
			String[] pairs = paramsPart.split("&");

			for (String pair : pairs) {
				String[] parts = pair.split("=");
				map.put(parts[0], parts[1]);
			}
		}
		return new UrlHelper(baseUrl, extendedUrl == null ? "" : extendedUrl, map);
	}

	/**
	 * Takes a Map and transforms it into a URL params string.
	 * 
	 * @param map
	 *            The parameters to transform into the string
	 * @return a URL params string
	 */
	static String mapToParamList(Map<String, String> map) {
		if (map == null)
			return "";
		StringBuilder ret = new StringBuilder("?");
		// For each entry, append a new <key>=<value> pair to the param string
		for (Entry<String, String> entry : map.entrySet()) {
			ret.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		return ret.toString();
	}

	/**
	 * Combines a list of strings into a url path
	 * 
	 * @param args
	 *            The strings to combine into a path
	 * @return all of the strings in args combined using `/`
	 */
	static String combineMany(String... args) {
		if (args.length == 0)
			return "";
		if (args.length == 1)
			return args[0];
		String ret = args[0];
		for (int i = 1; i < args.length; i++) {
			ret = urlDirCombine(ret, args[i]);
		}
		return ret;
	}

	/**
	 * Combines all of the parts of a URL into a full URL
	 * 
	 * @param baseUrl
	 *            the base of the APIs URL.
	 * @param extendedUrl
	 *            The method or extended portion of the URL to call
	 * @param params
	 *            the URL parameters
	 * @return A full URL complete with the base URL, the extended portion, and
	 *         all parameters.
	 */
	static String createRoute(String baseUrl, String extendedUrl, Map<String, String> params) {
		if (baseUrl == null || baseUrl.trim().length() == 0)
			throw new IllegalArgumentException("BaseUrl cannot be null or empty");
		if (extendedUrl == null)
			extendedUrl = "";
		// combine all parts of the URL
		String result = combineMany(baseUrl, extendedUrl);
		String paramString = mapToParamList(params);
		// strip trailing '/' from the URL
		if (result.endsWith("/"))
			return result.substring(0, result.length() - 1) + paramString;
		else
			return result + paramString;
	}

	/**
	 * Combines two strings to create a valid url directory path. We don't care
	 * how the path's start or end after this method runs. This just ensures
	 * that the correct number of `/` are between 2 paths.
	 * 
	 * @param first
	 *            The first string
	 * @param second
	 *            The second string
	 * @return The combined strings
	 */
	private static String urlDirCombine(String first, String second) {
		// Null checks
		if (first == null && second == null)
			return "";
		if (first == null)
			return second;
		if (second == null)
			return first;
		// the case where we know we have at least one `/`
		if (first.endsWith("/")) {
			if (second.startsWith("/")) {
				// Example: first/ /second (need to remove one slash
				return first + second.substring(1);
			} else {
				// Example: first/ second (Perfect, just mush them together)
				return first + second;
			}
		} else {
			// the case where we may not have one `/`
			if (second.startsWith("/")) {
				// Example: first /second (Perfect, just mush them together)
				return first + second;
			} else {
				// Example: first second (Need to add a slash in between them)
				return first + "/" + second;
			}
		}
	}
}
