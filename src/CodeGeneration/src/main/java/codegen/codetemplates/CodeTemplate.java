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
 * <p>
 * Represents a Code Template. This can contain simple or complex template entries.
 * </p>
 * <p>
 * The general idea is, that once you have a code template, you are free to write whatever code you
 * like ot fill those templates. You may have SMD/DTO objects, or you may have arbitrary other
 * formats of data. You just need to be able to tell the template what data to put where.
 * </p>
 * 
 * @author Justin Nelson
 */
public class CodeTemplate implements TemplateEntry {
	private static String simplePatternS = "<@([^@]*)@>";
	private static String compoundPatternStartS = "<@@([^@]*)@@>";
	private static String compoundPatternEndS = "<@@@@>";
	private Map<String, TemplateEntry> templateReplacement;
	private String fullTemplateString;
	private String resultingTemplate;

	/**
	 * Creates a new template from the given string.
	 * 
	 * @param template
	 */
	public CodeTemplate(String template) {
		templateReplacement = new HashMap<String, TemplateEntry>();
		fullTemplateString = template;
		// While there are still compound patterns
		while (template.contains(compoundPatternEndS)) {
			String nextTagString = findNextTagString(template, 0);
			// find the beginning of the compound template
			int compoundStart = template.indexOf(nextTagString) + nextTagString.length();
			// find the end of the template
			int compoundEnd = findMatchingPatternClose(template, compoundStart);
			// the compound template is the string starting at the open tag, and
			// going to the close tag
			String matchedTemplate = template.substring(compoundStart, compoundEnd);
			// Use this to find the name of the parameter in the compound tag
			String compountPropDescriptor = nextTagString.substring(3, nextTagString.length() - 3);
			// compoundProperties may have a delimiter specified
			String[] compoundPropNameParts = compountPropDescriptor.split(":");
			String delim = null;
			if (compoundPropNameParts.length == 2)
				delim = compoundPropNameParts[1];
			templateReplacement.put(compoundPropNameParts[0], new CompoundCodeTemplate(matchedTemplate, delim));
			template = template.replace(nextTagString + matchedTemplate + compoundPatternEndS, "<@"
					+ compoundPropNameParts[0] + "@>");
		}
		Pattern simplePattern = Pattern.compile(simplePatternS);
		Matcher m = simplePattern.matcher(template);
		while (m.find()) {
			String matchedTerm = m.group(1);
			if (!templateReplacement.containsKey(matchedTerm)) {
				templateReplacement.put(matchedTerm, new EmptyCodeTemplate());
			}
		}
		resultingTemplate = template;
	}

	/**
	 * From the template, find the next compound tag.
	 * 
	 * @param template
	 *            the template string
	 * @return
	 */
	private static String findNextTagString(String template, int patternStart) {
		Pattern compoundOpen = Pattern.compile(compoundPatternStartS);
		Matcher m = compoundOpen.matcher(template);
		if (!m.find(patternStart)) {
			// there was no matching pattern
			return null;
		} else {
			if (!m.group().equals(compoundPatternEndS)) {
				return m.group(0);
			} else {
				return null;
			}
		}
	}

	/**
	 * This number represents the max depth we allow the following method to traverse before we
	 * assume there is a bug in the code, or the Template file was poorly structured.
	 */
	private static final int MAX_DEPTH_BEFORE_ERROR = 100000;

	/**
	 * Parses a string to find matching tag pairs
	 * 
	 * @param template
	 *            the template to match
	 * @param patternOpenLocation
	 *            the place in the string the compound pattern begins
	 * @return the location of the tag that closes the compound pattern
	 */
	private static int findMatchingPatternClose(String template, int patternOpenLocation) {
		// Start looking right after the start index
		int currentIndex = patternOpenLocation + 1;
		// keep track of how deep the nesting goes
		int depthCount = 0;
		while (true) {
			String nextOpenTag = findNextTagString(template, currentIndex);
			// find the next index of an open tag
			int nextOpenIdx = nextOpenTag == null ? -1 : template
					.indexOf(nextOpenTag, currentIndex) + nextOpenTag.length();
			// find the next index of a closing tag
			int nextCloseIdx = template.indexOf(compoundPatternEndS, currentIndex);
			// if we find a close tag before an open tag
			if (nextOpenIdx == -1 || nextCloseIdx < nextOpenIdx) {
				// if we are a 0 depth
				if (depthCount == 0) {
					// then we have found our match
					return nextCloseIdx;
				} else {
					// otherwise, we have gone up a depth, and will start
					// looking after that tag
					depthCount--;
					currentIndex = nextCloseIdx + 1;
				}
			} else {
				// we have found an open tag before a close tag, so we go one
				// deeper, and begin looking at that point
				depthCount++;
				currentIndex = nextOpenIdx + 1;
				// Check to make sure we aren't stuck in the loop
				if (depthCount > MAX_DEPTH_BEFORE_ERROR) {
					throw new IllegalStateException(
							"The template parser has encountered an error.  "
									+ "Please make sure your template file is correctly built.  "
									+ "If there is no error with hte template file, please file a bug with the developers of this API.");
				}
			}
			// if at any point the depth has gone negative, there is a serious
			// error
			if (depthCount < 0)
				throw new AssertionError("The code is broken, or the template is.  Check both.");
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
			throw new IllegalArgumentException(
					"This template does not contain a definition for the given term.");
		}
		return oldEntry;
	}

	/**
	 * Convenience method for binding a simple template entry to a key.
	 * 
	 * @param templateKey
	 * @param entry
	 * @return an entry that was previously bound to the given key.
	 */
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
		Scanner fin = new Scanner(new File(location));
		StringBuilder templateString = new StringBuilder();
		while (fin.hasNextLine()) {
			templateString.append(fin.nextLine()).append("\n");
		}
		return new CodeTemplate(templateString.toString());
	}

	@Override
	public String codeReplacement() {
		String code = resultingTemplate;
		for (Entry<String, TemplateEntry> entry : templateReplacement.entrySet()) {
			code = code
					.replaceAll("<@" + entry.getKey() + "@>", entry.getValue().codeReplacement());
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
	@Override
	public CodeTemplate copyEmptyTemplate() {
		CodeTemplate copy = new CodeTemplate();
		copy.fullTemplateString = this.fullTemplateString;
		copy.resultingTemplate = this.resultingTemplate;
		copy.templateReplacement = new HashMap<String, TemplateEntry>();
		for (String key : templateReplacement.keySet()) {
			copy.templateReplacement.put(key, templateReplacement.get(key).copyEmptyTemplate());
		}
		return copy;
	}
}
