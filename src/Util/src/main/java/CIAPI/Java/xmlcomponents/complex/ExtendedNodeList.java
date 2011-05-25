package CIAPI.Java.xmlcomponents.complex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.NodeList;

import CIAPI.Java.xmlcomponents.JinqException;
import CIAPI.Java.xmlcomponents.Jode;
import CIAPI.Java.xmlcomponents.JodeFilter;


public class ExtendedNodeList implements NodeList, Iterable<ExtendedNode> {

	private List<ExtendedNode> jodes;

	public ExtendedNodeList(NodeList list) {
		this(list, false);
	}

	public ExtendedNodeList(NodeList list, boolean retainWhitespace) {
		jodes = new ArrayList<ExtendedNode>(list.getLength());
		for (int i = 0; i < list.getLength(); i++) {
			ExtendedNode toAdd = new ExtendedNode(list.item(i));
			if (!toAdd.isWhiteSpace() || retainWhitespace) {
				jodes.add(toAdd);
			}
		}
	}

	private ExtendedNodeList(List<ExtendedNode> jodes) {
		this.jodes = jodes;
	}

	/**
	 * @return the first node in this list. Will throw an exception of the list is empty.
	 */
	public ExtendedNode first() {
		if (jodes.isEmpty())
			throw new JinqException("There is no first node");
		return item(0);
	}

	/**
	 * @param filter
	 *            the filter to apply to this list
	 * @return the first node after filtering this list
	 */
	public ExtendedNode first(JodeFilter filter) {
		return this.filter(filter).first();
	}
	
	/**
	 * @param filter
	 *            the filter to apply to this list
	 * @return the first node after filtering this list
	 */
	public ExtendedNode first(String name) {
		return this.filter(name).first();
	}

	/**
	 * 
	 * @param nodeName
	 *            the name of the only node to match
	 * @return
	 */
	public ExtendedNode single(String nodeName) {
		ExtendedNodeList lst = this.filter(nodeName);
		if (lst.getLength() != 1)
			throw new JinqException("The call to 'single' did not return 1 result.");
		return lst.item(0);
	}

	public ExtendedNode single(JodeFilter filter) {
		ExtendedNodeList lst = this.filter(filter);
		if (lst.getLength() != 1)
			throw new JinqException("The call to 'single' did not return 1 result.");
		return lst.item(0);
	}

	public ExtendedNodeList filter(final String nodeName) {
		return this.filter(new JodeFilter() {
			@Override
			public boolean accept(Jode j) {
				return j.name().equals(nodeName);
			}
		});
	}

	public ExtendedNodeList filter(JodeFilter filter) {
		List<ExtendedNode> result = new ArrayList<ExtendedNode>();
		for (ExtendedNode j : this) {
			if (filter.accept(new Jode(j))) {
				result.add(j);
			}
		}
		return new ExtendedNodeList(result);
	}

	@Override
	public int getLength() {
		return jodes.size();
	}

	@Override
	public ExtendedNode item(int arg0) {
		return jodes.get(arg0);
	}

	/**
	 * Alias for 'item(index)' because that's stupid...
	 * 
	 * @param i
	 *            the index to return
	 * @return the node at index i.
	 */
	public ExtendedNode get(int i) {
		return item(i);
	}

	@Override
	public Iterator<ExtendedNode> iterator() {
		return jodes.iterator();
	}
}
