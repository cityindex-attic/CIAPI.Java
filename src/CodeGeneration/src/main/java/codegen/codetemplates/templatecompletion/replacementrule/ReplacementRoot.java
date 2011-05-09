package codegen.codetemplates.templatecompletion.replacementrule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import xmlcomponents.Jocument;
import xmlcomponents.Jode;
import xmlcomponents.JodeList;

public class ReplacementRoot implements Iterable<Replacement> {

	private List<Replacement> replacements;

	public ReplacementRoot(String location) throws ParserConfigurationException, SAXException,
			IOException {
		Jocument doc = Jocument.load(location);
		JodeList replacementNodes = doc.children().first().children();
		replacements = new ArrayList<Replacement>();
		for (Jode n : replacementNodes) {
			replacements.add(nodeToReplacement(n));
		}
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
		List<Replacement> replacements = new ArrayList<Replacement>();
		for (Jode node : children) {
			replacements.add(nodeToReplacement(node));
		}
		ReplacementSet ret = new ReplacementSet(n.attribute("name").value(), n.attribute("value")
				.value(), "", subObjectName, replacements);
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
