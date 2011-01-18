package CIAPI.Java.urlstuff;

import java.util.Map;
import java.util.Map.Entry;

public class UrlHelper {

	public String mapToParamList(Map<String, String> map) {
		if (map == null)
			return "";
		StringBuilder ret = new StringBuilder("?");
		for (Entry<String, String> entry : map.entrySet()) {
			ret.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		return ret.toString();
	}

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

	public String createRoute(String baseUrl, String extendedUrl, Map<String, String> params) {
		String result = combineMany(baseUrl, extendedUrl, mapToParamList(params));
		return result;
	}

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
