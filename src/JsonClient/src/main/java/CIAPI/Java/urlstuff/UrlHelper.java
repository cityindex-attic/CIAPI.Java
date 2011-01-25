package CIAPI.Java.urlstuff;

import java.util.Map;
import java.util.Map.Entry;

/**
 * Simple helper class for manipulating URLs.
 * 
 * @author Justin Nelson
 * 
 */
public class UrlHelper {

	/**
	 * Takes a Map and transforms it into a URL params string.
	 * 
	 * @param map
	 *            The parameters to transform into the string
	 * @return a URL params string
	 */
	public String mapToParamList(Map<String, String> map) {
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
	public String combineMany(String... args) {
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
	public String createRoute(String baseUrl, String extendedUrl, Map<String, String> params) {
		// combine all parts of the URL
		String result = combineMany(baseUrl, extendedUrl, mapToParamList(params));
		// strip trailing '/' from the URL
		if (result.endsWith("/"))
			return result.substring(0, result.length() - 1);
		else
			return result;
	}

	/**
	 * Combines two strings to create a valid url directory path.
	 * 
	 * @param first
	 *            The first string
	 * @param second
	 *            The second string
	 * @return The combined strings
	 */
	public String urlDirCombine(String first, String second) {
		if (first == null && second == null)
			return "";
		if (first == null)
			return second;
		if (second == null)
			return first;
		if (first.endsWith("/")) {
			if (second.startsWith("/")) {
				return first + second.substring(1);
			} else {
				return first + second;
			}
		} else {
			if (second.startsWith("/")) {
				return first + second;
			} else {
				return first + "/" + second;
			}
		}
	}
}
