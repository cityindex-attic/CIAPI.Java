package CIAPI.Java.xmlcomponents.complex;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.TypeInfo;

/**
 * Represents an attribute in the xml document
 * 
 * @author Justin Nelson
 * 
 */
public class ExtendedAttr extends ExtendedNode implements Attr {
	private Attr a;

	/**
	 * Creates a new ExtendedAttr out of a given Attr.
	 * 
	 * @param a
	 *            the Attr to use as a backing
	 */
	public ExtendedAttr(Attr a) {
		super(a);
		this.a = a;
	}

	@Override
	public String getName() {
		return a.getName();
	}

	@Override
	public ExtendedElement getOwnerElement() {
		return new ExtendedElement(a.getOwnerElement());
	}

	@Override
	public TypeInfo getSchemaTypeInfo() {
		return a.getSchemaTypeInfo();
	}

	@Override
	public boolean getSpecified() {
		return a.getSpecified();
	}

	@Override
	public String getValue() {
		return a.getValue();
	}

	@Override
	public boolean isId() {
		return a.isId();
	}

	@Override
	public void setValue(String value) throws DOMException {
		a.setValue(value);
	}
}
