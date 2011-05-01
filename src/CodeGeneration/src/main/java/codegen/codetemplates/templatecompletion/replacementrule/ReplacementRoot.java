package codegen.codetemplates.templatecompletion.replacementrule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReplacementRoot implements Replacement {

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
		for (Node n : replacementNodes) {
			replacements.add(nodeToReplacement(n));
		}
	}

	private static Replacement nodeToReplacement(Node n) {
		if (n.getNodeName().equals("replacement")) {
			return parseSimpleNode(n);
		} else if (n.getNodeName().equals("replacementSet")) {
			return parseComplexNode(n);
		} else {
			throw new IllegalArgumentException("The node is not allowed in the context: "
					+ n.getNodeName());
		}
	}

	private static ReplacementSet parseComplexNode(Node n) {
		return null;
	}

	private static SimpleReplacement parseSimpleNode(Node n) {
		NdLst children = new NdLst(n.getChildNodes());
		Node templateValue = children.single("templateValue");
		Node objectValue = children.single("objectValue");
		SimpleReplacement rep = new SimpleReplacement(templateValue.getTextContent(), objectValue.getTextContent());
		return rep;
	}

	@Override
	public String getTemplateName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String performReplacement(String template) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Super simple implementation of a NodeList that ignores my definition of whitespace nodes.
	 * 
	 * @author Justin Nelson
	 * 
	 */
	public static class NdLst implements NodeList, Iterable<Node> {

		private List<Node> nodes;

		public NdLst(NodeList list) {
			nodes = new ArrayList<Node>();
			for (int i = 0; i < list.getLength(); i++) {
				if (!isWhitespaceNode(list.item(i))) {
					nodes.add(list.item(i));
				}
			}
		}

		private NdLst(List<Node> nodes) {
			this.nodes = nodes;
		}

		public NdLst where(NodeFilter filter) {
			List<Node> filtered = new ArrayList<Node>();
			for (Node n : this) {
				if (filter.accept(n)) {
					filtered.add(n);
				}
			}
			return new NdLst(filtered);
		}

		public NdLst where(final String nodeName){
			return this.where(new NodeFilter() {
				@Override
				public boolean accept(Node n) {
					return n.getNodeName().equals(nodeName);
				}
			});
		}
		
		public Node single(NodeFilter filter) {
			NdLst filtered = this.where(filter);
			if (filtered.getLength() != 1)
				throw new IllegalArgumentException("The filter did not return a single result.");
			return filtered.item(0);
		}

		public Node single(String nodeName){
			NdLst filtered = this.where(nodeName);
			if (filtered.getLength() != 1)
				throw new IllegalArgumentException("The filter did not return a single result.");
			return filtered.item(0);
		}
		
		@Override
		public Node item(int index) {
			return nodes.get(index);
		}

		@Override
		public int getLength() {
			return nodes.size();
		}

		private static boolean isWhitespaceNode(Node n) {
			if (n.getNodeType() == Node.TEXT_NODE) {
				String val = n.getNodeValue();
				return val.trim().length() == 0;
			} else {
				return false;
			}
		}

		@Override
		public Iterator<Node> iterator() {
			return nodes.iterator();
		}
	}

	public static interface NodeFilter {
		public boolean accept(Node n);
	}
}
