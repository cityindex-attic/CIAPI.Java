package codegen.codetemplates;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents a Code Template. This can contain simple or complex template
 * entries.
 * 
 * @author Justin Nelson
 */
public class CodeTemplate implements TemplateEntry {
	private String simplePatternS = "<@([^@]*)@>";
	private String compoundPatternStartS = "<@@([^@]*)@@>";
	private String compoundPatternEndS = "<@@@@>";
	private Map<String, TemplateEntry> templateReplacement;
	private String templateString;

	/**
	 * Creates a new template from the given location.
	 * 
	 * @param template
	 */
	public CodeTemplate(String template) {
		templateReplacement = new HashMap<String, TemplateEntry>();
		templateString = template;
		String compoundPatternS = compoundPatternStartS + "(.)*?" + compoundPatternEndS;
		Pattern compoundPattern = Pattern.compile(compoundPatternS, Pattern.DOTALL);
		Matcher compoundMatcher = compoundPattern.matcher(templateString);
		while (compoundMatcher.find()) {
			String matchedTerm = compoundMatcher.group(1);
			String matchedTemplate = compoundMatcher.group(0);
			templateReplacement.put(matchedTerm, new CompoundCodeTemplate(matchedTemplate));
			templateString = compoundMatcher.replaceFirst("<@" + matchedTerm + "@>");
		}
		Pattern simplePattern = Pattern.compile(simplePatternS);
		Matcher m = simplePattern.matcher(templateString);
		while (m.find()) {
			String matchedTerm = m.group(1);
			if (!templateReplacement.containsKey(matchedTerm)) {
				templateReplacement.put(matchedTerm, new EmptyCodeTemplate());
			}
		}
	}

	/**
	 * Adds or replaces a template entry definition
	 * 
	 * @param templateKey
	 * @param entry
	 * @return the old entry for the key.
	 */
	public TemplateEntry putNewTemplateDefinition(String templateKey, TemplateEntry entry) {
		TemplateEntry oldEntry = templateReplacement.put(templateKey, entry);
		// You can't replace a template definition for a key that doesn't exist
		if (oldEntry == null) {
			throw new IllegalArgumentException("This template does not contain a definition for the given term.");
		}
		return oldEntry;
	}

	public TemplateEntry putNewTemplateDefinition(String templateKey, String entry) {
		if (entry == null) {
			entry = "";
		}
		return putNewTemplateDefinition(templateKey, new SimpleTemplateEntry(entry));
	}

	/**
	 * @param templateKey
	 *            the key of the desired template
	 * @return the template entry corresponding to the given key
	 */
	public TemplateEntry getTemplateEntry(String templateKey) {
		if (templateKey == null) {
			throw new NullPointerException("The key must not be null");
		}
		return templateReplacement.get(templateKey);
	}

	/**
	 * Builds a new Code Template out of a template file.
	 * 
	 * @param location
	 *            the location of the template file
	 * @return a new code template based off of the file
	 * @throws FileNotFoundException
	 *             if the file did not exist
	 */
	public static CodeTemplate loadTemplate(String location) throws FileNotFoundException {
		return new CodeTemplate(new Scanner(new File(location)).useDelimiter("\\z").next());
	}

	@Override
	public String codeReplacement() {
		String code = templateString;
		for (Entry<String, TemplateEntry> entry : templateReplacement.entrySet()) {
			code = code.replaceAll("<@" + entry.getKey() + "@>", entry.getValue().codeReplacement());
		}
		return code;
	}

	/**
	 * Creates an empty template object. Used in copying an item
	 */
	private CodeTemplate() {
	}

	/**
	 * Creates a copy of this template with empty mappings.
	 * 
	 * @return an empty copy of this object.
	 */
	public CodeTemplate copyEmptyTemplate() {
		CodeTemplate copy = new CodeTemplate();
		copy.templateString = this.templateString;
		copy.templateReplacement = new HashMap<String, TemplateEntry>();
		for (String key : templateReplacement.keySet()) {
			copy.templateReplacement.put(key, new EmptyCodeTemplate());
		}
		return copy;
	}
}
