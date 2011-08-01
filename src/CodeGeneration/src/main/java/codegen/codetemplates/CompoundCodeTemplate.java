package codegen.codetemplates;

import static CIAPI.Java.logging.Log.debug;
import static CIAPI.Java.logging.Log.trace;
import static CIAPI.Java.logging.Log.error;
import static CIAPI.Java.logging.Log.warn;

import java.util.ArrayList;
import java.util.List;

/**
 * Template for allowing many different replacements for a single template. WIll
 * apply the template to each replacement set and create a repeated code
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
	/**
	 * Holds the possible replacements for the pattern
	 */
	private CodeTemplate templatePattern;
	/**
	 * Since this compound template will be repeated with many different
	 * replacements, we need a list of replacement mappings
	 */
	private List<CodeTemplate> templateReplacements;

	private String delim;

	/**
	 * Creates a new compound template from a compound template definition.
	 * 
	 * @param template
	 */
	public CompoundCodeTemplate(String template, String delim) {
		templateReplacements = new ArrayList<CodeTemplate>();
		templatePattern = new CodeTemplate(template);
		this.delim = delim;
		if (this.delim == null)
			this.delim = "";
	}

	/**
	 * Adds another mapping set to this compound pattern.
	 * 
	 * @param mappingSet
	 *            the template to add to this list
	 */
	public void addMappingSet(CodeTemplate mappingSet) {
		templateReplacements.add(mappingSet);
	}

	/**
	 * @return a copy of the template pattern that is empty. Used to give a user
	 *         an empty template that then can then fill and add to the list of
	 *         filled templates.
	 */
	public CodeTemplate getEmptyTemplate() {
		return templatePattern.copyEmptyTemplate();
	}

	@Override
	public String codeReplacement() {
		StringBuilder bldr = new StringBuilder();
		for (CodeTemplate template : templateReplacements) {
			bldr.append(template.codeReplacement());
			bldr.append(delim);
		}
		// Trim off the last delim
		// https://github.com/cityindex/CIAPI.Java/issues/6
		return bldr.toString().substring(0,
				Math.max(bldr.length() - delim.length(), 0));
	}

	private CompoundCodeTemplate() {
	}

	@Override
	public CompoundCodeTemplate copyEmptyTemplate() {
		CompoundCodeTemplate copy = new CompoundCodeTemplate();
		copy.templateReplacements = new ArrayList<CodeTemplate>();
		copy.templatePattern = this.templatePattern.copyEmptyTemplate();
		copy.delim = this.delim;
		return copy;
	}
}
