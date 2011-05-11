package codegen.codetemplates.templatecompletion.replacementrule;

import java.util.ArrayList;
import java.util.List;

public class FileNameFiller {
	private List<SimpleReplacement> fileNameParts;
	private boolean beganWithSlash;

	public FileNameFiller(String fileName) {
		String[] fileParts = fileName.split("(/|\\\\)");
		fileNameParts = new ArrayList<SimpleReplacement>();
		for (String s : fileParts) {
			fileNameParts.add(new SimpleReplacement(s, s, null));
		}
	}

	public String resolveFileName(Object obj, String... args) {
		String name = "";
		for (SimpleReplacement repl : fileNameParts) {
			name += "/" + repl.resolveValue(obj, args).toString();
		}
		return beganWithSlash ? name: name.substring(1);
	}
}
