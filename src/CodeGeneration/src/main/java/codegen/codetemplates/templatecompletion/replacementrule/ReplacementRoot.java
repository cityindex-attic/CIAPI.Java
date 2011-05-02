package codegen.codetemplates.templatecompletion.replacementrule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import codegen.codetemplates.templatecompletion.replacementrule.xmlparsing.MyNd;
import codegen.codetemplates.templatecompletion.replacementrule.xmlparsing.NdLst;

public class ReplacementRoot {

	private List<Replacement> replacements;

	public ReplacementRoot(String location) throws ParserConfigurationException, SAXException,
			IOException {
		DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		fact.setIgnoringComments(true);
		fact.setIgnoringElementContentWhitespace(true);
		DocumentBuilder bldr = fact.newDocumentBuilder();
		Document doc = bldr.parse(new File(location));
		NdLst replacementNodes = new NdLst(doc.getChildNodes().item(0).getChildNodes());
		replacements = new ArrayList<Replacement>();
		for (MyNd n : replacementNodes) {
			replacements.add(nodeToReplacement(n));
		}
	}

	private static Replacement nodeToReplacement(MyNd n) {
		if (n.getNodeName().equals("replacement")) {
			return parseSimpleNode(n);
		} else if (n.getNodeName().equals("replacementSet")) {
			return parseComplexNode(n);
		} else {
			throw new IllegalArgumentException("The node is not allowed in the context: "
					+ n.getNodeName());
		}
	}

	private static ReplacementSet parseComplexNode(MyNd n) {
		NdLst children = new NdLst(n.getChildNodes());
		MyNd templateValue = children.single("templateValue");
		MyNd objectValue = children.single("objectValue");
		String subObjectName = n.attribute("subObjName");
		MyNd replacementsNode = children.single("replacements");
		List<Replacement> replacements = new ArrayList<Replacement>();
		for (MyNd node : replacementsNode.getChildNodes()) {
			replacements.add(nodeToReplacement(node));
		}
		ReplacementSet ret = new ReplacementSet(templateValue.getTextContent(),
				objectValue.getTextContent(), subObjectName, replacements);
		return ret;
	}

	private static SimpleReplacement parseSimpleNode(MyNd n) {
		NdLst children = new NdLst(n.getChildNodes());
		Node templateValue = children.single("templateValue");
		Node objectValue = children.single("objectValue");
		SimpleReplacement rep = new SimpleReplacement(templateValue.getTextContent(),
				objectValue.getTextContent());
		return rep;
	}
}
