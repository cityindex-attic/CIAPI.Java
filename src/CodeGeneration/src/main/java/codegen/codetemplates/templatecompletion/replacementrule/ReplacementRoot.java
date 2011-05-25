package codegen.codetemplates.templatecompletion.replacementrule;

import static CIAPI.Java.logging.Log.debug;
import static CIAPI.Java.logging.Log.error;
import static CIAPI.Java.logging.Log.info;
import static CIAPI.Java.logging.Log.trace;
import static CIAPI.Java.logging.Log.warn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import CIAPI.Java.xmlcomponents.Jocument;
import CIAPI.Java.xmlcomponents.Jode;
import CIAPI.Java.xmlcomponents.JodeFilter;
import CIAPI.Java.xmlcomponents.JodeList;

import codegen.codetemplates.CodeTemplate;

/**
 * Represents a whole replacement file
 * 
 * @author Justin Nelson
 * 
 */
public class ReplacementRoot implements Iterable<Replacement> {

	private List<Replacement> replacements;
	private File codeTemplateLocation;
	private Class<?> requiredType;
	private FileNameFiller fileName;
	private File initialLocation;

	public File getInitialLocation() {
		return initialLocation;
	}

	/**
	 * Creates a {@link ReplacementRoot} from the given file location
	 * 
	 * @param location
	 *            the file path to the xml relpacement file
	 * @throws ClassNotFoundException
	 */
	public ReplacementRoot(String location) throws ClassNotFoundException {
		this.initialLocation = new File(location);
		Jocument doc = Jocument.load(location);
		Jode root = doc.children().first();
		codeTemplateLocation = resolveCodeTemplateFilePath(root.attribute("templateLocation").value(), initialLocation);
		String typeName = root.attribute("objectType").value();
		try {
			requiredType = Class.forName(typeName);
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Could not find class specified in replacement file: " + initialLocation);
		}
		JodeList replacementNodes = root.children().filter(new JodeFilter() {
			@Override
			public boolean accept(Jode j) {
				return j.name().startsWith("replacement");
			}
		});
		replacements = new ArrayList<Replacement>();
		for (Jode n : replacementNodes) {
			replacements.add(nodeToReplacement(n));
		}
		Jode fileNameNode = root.children().first();
		fileName = new FileNameFiller(fileNameNode.attribute("value").value());
	}

	/**
	 * Tells you the required class defined by the replacement file.
	 * 
	 * @return the input type that this replacement file requires
	 */
	public Class<?> getRequiredClass() {
		return requiredType;
	}

	/**
	 * The name to save the generated file as.
	 * 
	 * @param obj
	 *            the input object
	 * @param args
	 *            any extra arguments provided with this replacement
	 * @return the String to save this file as
	 */
	public String fileName(Object obj, String... args) {
		return fileName.resolveFileName(obj, args);
	}

	/**
	 * 
	 * @return the CodeTeplate that this replacement file corresponds to
	 * @throws FileNotFoundException
	 *             if the specified template file doesn't exist
	 */
	public CodeTemplate getTemplate() throws FileNotFoundException {
		try {
			return CodeTemplate.loadTemplate(codeTemplateLocation);
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException("Could not find code template file specified in replacement file: "
					+ codeTemplateLocation);
		}
	}

	/**
	 * Parses a Jode into a Replacement.
	 * 
	 * @param n
	 *            the Jode to parse
	 * @return the Replacement that the given Jode represents
	 */
	private static Replacement nodeToReplacement(Jode n) {
		if (n.name().equals("replacement")) {
			return parseSimpleNode(n);
		} else if (n.name().equals("replacementSet")) {
			return parseComplexNode(n);
		} else {
			throw new IllegalArgumentException("Cannot parse non-Replacement node: " + n.name());
		}
	}

	/**
	 * Parses a complex node into a ReplacementSet
	 * 
	 * @param n
	 *            the node to parse
	 * @return The ReplacementSet represented by the given node.
	 */
	private static ReplacementSet parseComplexNode(Jode n) {
		JodeList children = n.children();
		String subObjectName = n.attribute("subObjName").name();
		String delim = n.attribute("delim") == null ? "" : n.attribute("delim").value();
		List<Replacement> replacements = new ArrayList<Replacement>();
		for (Jode node : children) {
			replacements.add(nodeToReplacement(node));
		}
		ReplacementSet ret = new ReplacementSet(n.attribute("name").value(), n.attribute("value").value(), "",
				subObjectName, replacements, delim);
		return ret;
	}

	/**
	 * Parses a simple node into a SimpleReplacement
	 * 
	 * @param n
	 *            the node representing the SimpleReplacement
	 * @return the {@link SimpleReplacement} represented by the given node
	 */
	private static SimpleReplacement parseSimpleNode(Jode n) {
		SimpleReplacement rep = new SimpleReplacement(n.attribute("name").value(), n.attribute("value").value(), null);
		return rep;
	}

	@Override
	public Iterator<Replacement> iterator() {
		return replacements.iterator();
	}

	private static File resolveCodeTemplateFilePath(String codeReplacementPath, File replacementLocation) {
		File f = new File(codeReplacementPath);
		if (f.isAbsolute()) {
			debug("Parsed code template location: " + f.getAbsolutePath());
			return f;
		} else {
			File result = new File(replacementLocation.getParentFile().getAbsolutePath(), codeReplacementPath);
			debug("Parsed code template location: " + result.getAbsolutePath());
			return result;
		}
	}
}
