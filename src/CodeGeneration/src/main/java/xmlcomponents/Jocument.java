package xmlcomponents;

import org.w3c.dom.Document;

import xmlcomponents.complex.ExtendedDocument;

/**
 * Simple wrapper for a Document
 * 
 * @author Justin Nelson
 * 
 */
public class Jocument extends Jode {

	private ExtendedDocument d;

	/**
	 * Creates a new Jocument wrapping the given document
	 * 
	 * @param d
	 *            the document to wrap
	 */
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

	/**
	 * Loads a Jocument from the given file locaton
	 * 
	 * @param fileLocation
	 *            the location to find the document file
	 * @return a new jocument representing the given file
	 */
	public static Jocument load(String fileLocation) {
		return new Jocument(ExtendedDocument.load(fileLocation));
	}
}
