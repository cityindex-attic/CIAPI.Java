package CIAPI.Java.xmlcomponents;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Attr;
import org.w3c.dom.Node;

import CIAPI.Java.xmlcomponents.complex.ExtendedNode;

/**
 * <p>
 * Represents a node in an xml document. It is intentionally over-simplified.
 * </p>
 * It's purpose is to simplify parsing xml. It essentially presents a simpler wrapper over a Node
 * from the Java dom interface.
 * 
 * @author Justin Nelson
 * 
 */
public class Jode {
	private ExtendedNode n;

	/**
	 * Creates a new Jode wrapping a given Node
	 * 
	 * @param n
	 *            the node to wrap
	 */
	public Jode(Node n) {
		this(new ExtendedNode(n));
	}

	/**
	 * Creates a new Jode wrapping a given Extended node
	 * 
	 * @param n
	 *            the node to wrap
	 */
	protected Jode(ExtendedNode n) {
		this.n = n;
	}

	/**
	 * 
	 * @return the name of the node
	 */
	public String name() {
		return n.getNodeName();
	}

	/**
	 * @return the text inside of this node
	 */
	public String text() {
		return n.getTextContent();
	}

	/**
	 * @return all child nodes of this node
	 */
	public JodeList children() {
		return new JodeList(n.children());
	}

	/**
	 * @param filter
	 *            the filter to use to filter the children
	 * @return all child nodes of this node that match the given filter
	 */
	public JodeList children(JodeFilter filter) {
		return new JodeList(n.children(filter));
	}

	/**
	 * @param nodeName
	 *            the name of the nodes to match
	 * @return all child nodes that match the given name
	 */
	public JodeList children(String nodeName) {
		return new JodeList(n.children(nodeName));
	}

	/**
	 * 
	 * @param name
	 *            the name of the attribute to find
	 * @return the attribute specified by the given name
	 */
	public Jattr attribute(String name) {
		for (Jattr a : attributes()) {
			if (a.name().equals(name))
				return a;
		}
		return null;
	}

	/**
	 * @return all attributes of this node
	 */
	public List<Jattr> attributes() {
		List<Jattr> attributes = new ArrayList<Jattr>();
		for (int i = 0; i < n.getAttributes().getLength(); i++) {
			attributes.add(new Jattr((Attr) n.getAttributes().item(i)));
		}
		return attributes;
	}

	/**
	 * Provided so people can use the full functionality of a Node if they want.
	 * 
	 * @return the internal ExtendedNode
	 */
	public ExtendedNode extend() {
		return n;
	}
}
