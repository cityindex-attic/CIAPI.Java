package codegen.codetemplates.templatecompletion.replacementrule;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import xmlcomponents.Jocument;
import xmlcomponents.Jode;
import xmlcomponents.JodeFilter;
import xmlcomponents.JodeList;
import codegen.codetemplates.CodeTemplate;

public class ReplacementRoot implements Iterable<Replacement> {

	private List<Replacement> replacements;
	private String codeTemplateLocation;
	private Class<?> requiredType;
	private FileNameFiller fileName;

	public ReplacementRoot(String location) throws ParserConfigurationException, SAXException,
			IOException, ClassNotFoundException {
		Jocument doc = Jocument.load(location);
		codeTemplateLocation = doc.children().first().attribute("templateLocation").value();
		String typeName = doc.children().first().attribute("objectType").value();
		requiredType = Class.forName(typeName);
		JodeList replacementNodes = doc.children().first().children().filter(new JodeFilter() {
			@Override
			public boolean accept(Jode j) {
				return j.name().startsWith("replacement");
			}
		});
		replacements = new ArrayList<Replacement>();
		for (Jode n : replacementNodes) {
			replacements.add(nodeToReplacement(n));
		}
		Jode fileNameNode = doc.children().first().children().first();
		fileName = new FileNameFiller(fileNameNode.attribute("value").value());
	}

	public Class<?> getRequiredClass() {
		return requiredType;
	}

	public String fileName(Object obj, String... args) {
		return fileName.resolveFileName(obj, args);
	}

	public CodeTemplate getTemplate() throws FileNotFoundException {
		return CodeTemplate.loadTemplate(codeTemplateLocation);
	}

	private static Replacement nodeToReplacement(Jode n) {
		if (n.name().equals("replacement")) {
			return parseSimpleNode(n);
		} else if (n.name().equals("replacementSet")) {
			return parseComplexNode(n);
		} else {
			throw new IllegalArgumentException("The node is not allowed in the context: "
					+ n.name());
		}
	}

	private static ReplacementSet parseComplexNode(Jode n) {
		JodeList children = n.children();
		String subObjectName = n.attribute("subObjName").name();
		String delim = n.attribute("delim") == null ? "" : n.attribute("delim").value();
		List<Replacement> replacements = new ArrayList<Replacement>();
		for (Jode node : children) {
			replacements.add(nodeToReplacement(node));
		}
		ReplacementSet ret = new ReplacementSet(n.attribute("name").value(), n.attribute("value")
				.value(), "", subObjectName, replacements, delim);
		return ret;
	}

	private static SimpleReplacement parseSimpleNode(Jode n) {
		SimpleReplacement rep = new SimpleReplacement(n.attribute("name").value(), n.attribute(
				"value").value(), null);
		return rep;
	}

	@Override
	public Iterator<Replacement> iterator() {
		return replacements.iterator();
	}
}
