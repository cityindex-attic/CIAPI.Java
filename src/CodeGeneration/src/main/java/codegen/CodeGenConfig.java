package codegen;

import CIAPI.Java.xmlcomponents.Jocument;
import CIAPI.Java.xmlcomponents.Jode;

public class CodeGenConfig {

	private String saveLocation;
	private String schemaUrl;
	private String smdUrl;
	private String replacementDir;

	public CodeGenConfig(String smdLocation, String schemaLocation,
			String replacementDirectory, String saveLocation) {
		this.saveLocation = saveLocation;
		this.schemaUrl = schemaLocation;
		this.smdUrl = smdLocation;
		this.replacementDir = replacementDirectory;
	}

	public String getSaveLocation() {
		return saveLocation;
	}

	public String getSchemaUrl() {
		return schemaUrl;
	}

	public String getSmdUrl() {
		return smdUrl;
	}

	public String getReplacementDir() {
		return replacementDir;
	}

	public static CodeGenConfig loadFile(String location) {
		Jode doc = Jocument.load(location).children().single("configuration");
		String repl = doc.children().single("replacementDirectory").text();
		String saveLoc = doc.children().single("saveLocation").text();
		String smdLoc = doc.children().single("smdLocation").text();
		String schemaLoc = doc.children().single("schemaLocation").text();
		return new CodeGenConfig(smdLoc, schemaLoc, repl, saveLoc);
	}
}
