package xmlcomponents;

import org.w3c.dom.Attr;

import xmlcomponents.complex.ExtendedAttr;

/**
 * Represents an over-simplified xml attribute
 * 
 * @author Justin Nelson
 * 
 */
public class Jattr {
	private ExtendedAttr a;

	/**
	 * Creates a new attribute wrapping the given attr
	 * 
	 * @param a
	 *            the attribute to wrap
	 */
	public Jattr(Attr a) {
		this(new ExtendedAttr(a));
	}

	protected Jattr(ExtendedAttr a) {
		this.a = a;
	}

	/**
	 * 
	 * @return the name of the attribute
	 */
	public String name() {
		return a.getNodeName();
	}

	/**
	 * @return the value of the attribute
	 */
	public String value() {
		return a.getNodeValue();
	}

	/**
	 * @return the node that owns this attribute
	 */
	public Jode parent() {
		return new Jode(a.getOwnerElement());
	}

	public ExtendedAttr extend() {
		return a;
	}
}
