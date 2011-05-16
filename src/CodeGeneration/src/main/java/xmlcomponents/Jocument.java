package xmlcomponents;

import org.w3c.dom.Document;

import xmlcomponents.complex.ExtendedDocument;

/**
 * Simple wrapper for a Document
 * 
 * @author Justin
 * 
 */
public class Jocument extends Jode {

	private ExtendedDocument d;

	public Jocument(Document d) {
		this(new ExtendedDocument(d));
	}

	protected Jocument(ExtendedDocument d) {
		super(d);
		this.d = d;
	}

	public ExtendedDocument extend() {
		return d;
	}

	public static Jocument load(String fileLocation) {
		return new Jocument(ExtendedDocument.load(fileLocation));
	}
}
