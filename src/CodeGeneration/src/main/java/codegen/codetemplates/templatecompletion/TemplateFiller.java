package codegen.codetemplates.templatecompletion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import static CIAPI.Java.logging.Log.debug;
import static CIAPI.Java.logging.Log.error;
import static CIAPI.Java.logging.Log.info;
import static CIAPI.Java.logging.Log.trace;
import static CIAPI.Java.logging.Log.warn;

import codegen.codetemplates.CodeTemplate;
import codegen.codetemplates.templatecompletion.replacementrule.Replacement;
import codegen.codetemplates.templatecompletion.replacementrule.ReplacementRoot;

/**
 * Simple class for filling a code template with the given replacements
 * 
 * @author Justin Nelson
 * 
 */
public class TemplateFiller {

	private CodeTemplate toFill;
	private ReplacementRoot replacemnetTemplate;

	/**
	 * Creates a new template filler that will use the supplied template and
	 * replacement set
	 * 
	 * @param replacementTemplate
	 *            the replacement template to fill
	 * @throws FileNotFoundException
	 *             if the replacement file or code template can't be found
	 */
	public TemplateFiller(ReplacementRoot replacementTemplate)
			throws FileNotFoundException {
		this.toFill = replacementTemplate.getTemplate();
		this.replacemnetTemplate = replacementTemplate;
	}

	/**
	 * Returns a filled template. (Ideally code that compiles)
	 * 
	 * @param rootModelObject
	 *            the object to feed the code template and replacement file for
	 *            replacements
	 * @return the template that was replaced by the given replacement rules and
	 *         model object
	 */
	public String fillTemplate(Object rootModelObject) {
		for (Replacement r : replacemnetTemplate) {
			r.fillTemplateHole(rootModelObject, toFill);
		}
		return toFill.codeReplacement();
	}

	/**
	 * Will save the generated code to the given directory. Responsible for
	 * creating required directories below the specified directory. But it will
	 * error out if the given directory doesn't exist.
	 * 
	 * @param saveLocation
	 * @param rootModelObject
	 * @throws FileNotFoundException
	 */
	public void saveToFile(String saveLocation, Object rootModelObject)
			throws FileNotFoundException {
		if (!new File(saveLocation).isDirectory()) {
			error(new IllegalArgumentException(
					"The given location was not a directory."));
		}
		File saveLoc = resolveSaveLocation(saveLocation, rootModelObject);
		saveLoc.getParentFile().mkdirs();
		debug("Saving TemplateFiller to file: " + saveLoc);
		PrintStream dtoOut = new PrintStream(saveLoc);
		dtoOut.println(fillTemplate(rootModelObject));
		dtoOut.close();
	}

	/**
	 * If a replacement file specifies that it should be saved in an absolute
	 * location, we honor that. Otherwise, we will place it in a directory below
	 * the specified save location. (Relative file paths are preferred)
	 * 
	 * @param saveLocation
	 *            the specified save location
	 * @param rootModelObject
	 *            the object used to create the filename
	 * @return the file to save this filled template to
	 */
	private File resolveSaveLocation(String saveLocation, Object rootModelObject) {
		File initialLocation = replacemnetTemplate.fileName(rootModelObject);
		if (initialLocation.isAbsolute()) {
			return initialLocation;
		} else {
			return new File(saveLocation, initialLocation.getPath());
		}
	}
}
