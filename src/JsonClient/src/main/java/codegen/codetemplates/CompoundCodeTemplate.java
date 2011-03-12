package codegen.codetemplates;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Template for allowing many different replacements for a single template. WIll
 * apply the template to each replacement set and create a reapeated code
 * pattern.
 * 
 * This template does not allow for compound templates.
 * 
 * @author Justin Nelson
 * 
 */
public class CompoundCodeTemplate implements TemplateEntry {
	private String compoundPatternStartS = "<@@([^@]*)@@>";
	private String compoundPatternEndS = "<@@@@>";
	private String simplePatternS = "<@([^@]*)@>";
	private Map<String, TemplateEntry> templateReplacement;

	/**
	 * Creates a new compound template from a compound template definition.
	 * @param template
	 */
	public CompoundCodeTemplate(String template) {
		templateReplacement = new HashMap<String, TemplateEntry>();
		// the next two lines strip the compound pattern start and end from the code if they exist.
		// this completely breaks if people try to nest compound templates.  We don't support that.
		template = template.replaceAll(compoundPatternStartS, "");
		template = template.replaceAll(compoundPatternEndS, "");
		Pattern simplePattern = Pattern.compile(simplePatternS);
		Matcher m = simplePattern.matcher(template);
		while (m.find()) {
			String matchedTerm = m.group(1);
			templateReplacement.put(matchedTerm, new EmptyCodeTemplate());
		}
	}

	@Override
	public String codeReplacement() {
		return null;
	}
}
