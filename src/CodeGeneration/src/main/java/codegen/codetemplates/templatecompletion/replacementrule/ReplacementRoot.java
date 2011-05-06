package codegen.codetemplates.templatecompletion.replacementrule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import xmlcomponents.Jode;
import xmlcomponents.complex.ExtendedDocument;
import xmlcomponents.complex.ExtendedNode;
import xmlcomponents.complex.ExtendedNodeList;

public class ReplacementRoot implements Iterable<Replacement>{

	private List<Replacement> replacements;

	public ReplacementRoot(String location) throws ParserConfigurationException, SAXException,
			IOException {
		ExtendedDocument doc = ExtendedDocument.load(location);
		ExtendedNodeList replacementNodes = new ExtendedNodeList(doc.children().item(0).getChildNodes());
		replacements = new ArrayList<Replacement>();
		for (ExtendedNode n : replacementNodes) {
			replacements.add(nodeToReplacement(n));
		}
	}

	private static Replacement nodeToReplacement(ExtendedNode n) {
		if (n.getNodeName().equals("replacement")) {
			return parseSimpleNode(n);
		} else if (n.getNodeName().equals("replacementSet")) {
			return parseComplexNode(n);
		} else {
			throw new IllegalArgumentException("The node is not allowed in the context: "
					+ n.getNodeName());
		}
	}

	private static ReplacementSet parseComplexNode(ExtendedNode n) {
		ExtendedNodeList children = new ExtendedNodeList(n.getChildNodes());
		ExtendedNode templateValue = children.single("templateValue");
		ExtendedNode objectValue = children.single("objectValue");
		String subObjectName = new Jode(n).attribute("subObjName").name();
		ExtendedNode replacementsNode = children.single("replacements");
		List<Replacement> replacements = new ArrayList<Replacement>();
		for (ExtendedNode node : replacementsNode.getChildNodes()) {
			replacements.add(nodeToReplacement(node));
		}
		ReplacementSet ret = new ReplacementSet(templateValue.getTextContent(),
				objectValue.getTextContent(), "",subObjectName, replacements);
		return ret;
	}

	private static SimpleReplacement parseSimpleNode(ExtendedNode n) {
		ExtendedNodeList children = new ExtendedNodeList(n.getChildNodes());
		Node templateValue = children.single("templateValue");
		Node objectValue = children.single("objectValue");
		SimpleReplacement rep = new SimpleReplacement(templateValue.getTextContent(),
				objectValue.getTextContent(), null);
		return rep;
	}

	@Override
	public Iterator<Replacement> iterator() {
		return replacements.iterator();
	}
}
