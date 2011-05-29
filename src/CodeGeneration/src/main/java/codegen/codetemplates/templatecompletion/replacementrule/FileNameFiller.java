package codegen.codetemplates.templatecompletion.replacementrule;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import CIAPI.Java.logging.Log;

/**
 * Similar to a Replacement. Its job is to turn a filename specification into an actual valid
 * filename.
 * 
 * @author Justin Nelson
 * 
 */
public class FileNameFiller {
	private List<List<SimpleReplacement>> fileNameParts;
	private boolean beganWithSlash;

	/**
	 * Creates a file name filler from the specified path in the Replacement file
	 * 
	 * @param fileName
	 *            the name of the place where the replacement file should be saved
	 */
	public FileNameFiller(String fileName, File replRootLocation) {
		String[] fileParts = fileName.split("(/|\\\\)");
		Log.trace("Found the following parts of a file name: " + fileParts);
		fileNameParts = new ArrayList<List<SimpleReplacement>>();
		// process each specified directory
		for (String s : fileParts) {
			List<SimpleReplacement> innerList = new ArrayList<SimpleReplacement>();
			String[] concatParts = s.split("\\+");
			for (String concatPart : concatParts) {
				innerList.add(new SimpleReplacement(concatPart, concatPart, null));
			}
			fileNameParts.add(innerList);
		}
		beganWithSlash = fileName.startsWith("/");
	}

	/**
	 * Will return the correct filename for the object
	 * 
	 * @param obj
	 *            the object to resolve the name for
	 * @param args
	 *            any extra args to provide along with the object
	 * @return the real filename for the object
	 */
	public String resolveFileName(Object obj, String... args) {
		String name = "";
		for (List<SimpleReplacement> concatPart : fileNameParts) {
			for (SimpleReplacement repl : concatPart) {
				name += repl.resolveValue(obj, args).toString();
			}
			name += "/";
		}
		return beganWithSlash ? "/" + name : name;
	}
}
