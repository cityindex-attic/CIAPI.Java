package codegen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeTemplate {
	private String pattern = "<@([^@]*)@>";
	private Map<String, TemplateEntry> templateReplacement;
	private String templateString;

	/**
	 * Creates a new template from the given location.
	 * 
	 * @param templateLocation
	 * @throws FileNotFoundException
	 */
	public CodeTemplate(String templateLocation) throws FileNotFoundException {
		templateString = loadTemplate(templateLocation);
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(templateString);
		while (m.find()) {
			String matchedTerm = m.group(1);
			System.out.println(matchedTerm);
		}
	}

	public TemplateEntry put(String templateKey, TemplateEntry entry) {
		TemplateEntry oldEntry = templateReplacement.put(templateKey, entry);
		if (oldEntry == null) {
			throw new IllegalArgumentException("This template does not contain a definition for the given term.");
		}
		return oldEntry;
	}

	public String generateCode() {
		String code = templateString;
		for (Entry<String, TemplateEntry> entry : templateReplacement.entrySet()) {
			code = templateString.replaceAll(pattern, templateReplacement.get("$1").codeReplacement());
		}
		return code;
	}

	private String loadTemplate(String location) throws FileNotFoundException {
		return new Scanner(new File(location)).useDelimiter("\\z").next();
	}
}
