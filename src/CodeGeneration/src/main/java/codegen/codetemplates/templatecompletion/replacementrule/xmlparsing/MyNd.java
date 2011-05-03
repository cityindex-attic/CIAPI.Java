package codegen.codetemplates.templatecompletion.replacementrule.xmlparsing;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;

public class MyNd implements Node {

	private Node n;

	public MyNd(Node n) {
		this.n = n;
	}

	public String attribute(String name){
		NamedNodeMap map = getAttributes();
		Node attr = map.getNamedItem(name);
		return attr.getNodeValue();
	}
	
	// /
	// Regular node methods below. WARNING boring!!!
	// /

	@Override
	public String getNodeName() {
		return n.getNodeName();
	}

	@Override
	public String getNodeValue() throws DOMException {
		return n.getNodeValue();
	}

	@Override
	public void setNodeValue(String nodeValue) throws DOMException {
		n.setNodeValue(nodeValue);
	}

	@Override
	public short getNodeType() {
		return n.getNodeType();
	}

	@Override
	public Node getParentNode() {
		return n.getParentNode();
	}

	@Override
	public NdLst getChildNodes() {
		return new NdLst(n.getChildNodes());
	}

	@Override
	public Node getFirstChild() {
		return n.getFirstChild();
	}

	@Override
	public Node getLastChild() {
		return n.getLastChild();
	}

	@Override
	public Node getPreviousSibling() {
		return n.getPreviousSibling();
	}

	@Override
	public Node getNextSibling() {
		return n.getNextSibling();
	}

	@Override
	public NamedNodeMap getAttributes() {
		return n.getAttributes();
	}

	@Override
	public Document getOwnerDocument() {
		return n.getOwnerDocument();
	}

	@Override
	public Node insertBefore(Node newChild, Node refChild) throws DOMException {
		return n.insertBefore(newChild, refChild);
	}

	@Override
	public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
		return n.replaceChild(newChild, oldChild);
	}

	@Override
	public Node removeChild(Node oldChild) throws DOMException {
		return n.removeChild(oldChild);
	}

	@Override
	public Node appendChild(Node newChild) throws DOMException {
		return n.appendChild(newChild);
	}

	@Override
	public boolean hasChildNodes() {
		return n.hasChildNodes();
	}

	@Override
	public Node cloneNode(boolean deep) {
		return n.cloneNode(deep);
	}

	@Override
	public void normalize() {
		n.normalize();
	}

	@Override
	public boolean isSupported(String feature, String version) {
		return n.isSupported(feature, version);
	}

	@Override
	public String getNamespaceURI() {
		return n.getNamespaceURI();
	}

	@Override
	public String getPrefix() {
		return n.getPrefix();
	}

	@Override
	public void setPrefix(String prefix) throws DOMException {
		n.setPrefix(prefix);
	}

	@Override
	public String getLocalName() {
		return n.getLocalName();
	}

	@Override
	public boolean hasAttributes() {
		return n.hasAttributes();
	}

	@Override
	public String getBaseURI() {
		return n.getBaseURI();
	}

	@Override
	public short compareDocumentPosition(Node other) throws DOMException {
		return n.compareDocumentPosition(other);
	}

	@Override
	public String getTextContent() throws DOMException {
		return n.getTextContent();
	}

	@Override
	public void setTextContent(String textContent) throws DOMException {
		n.setTextContent(textContent);
	}

	@Override
	public boolean isSameNode(Node other) {
		return n.isSameNode(other);
	}

	@Override
	public String lookupPrefix(String namespaceURI) {
		return n.lookupPrefix(namespaceURI);
	}

	@Override
	public boolean isDefaultNamespace(String namespaceURI) {
		return n.isDefaultNamespace(namespaceURI);
	}

	@Override
	public String lookupNamespaceURI(String prefix) {
		return n.lookupNamespaceURI(prefix);
	}

	@Override
	public boolean isEqualNode(Node arg) {
		return n.isEqualNode(arg);
	}

	@Override
	public Object getFeature(String feature, String version) {
		return n.getFeature(feature, version);
	}

	@Override
	public Object setUserData(String key, Object data, UserDataHandler handler) {
		return n.setUserData(key, data, handler);
	}

	@Override
	public Object getUserData(String key) {
		return n.getUserData(key);
	}
}
