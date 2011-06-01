package CIAPI.Java.xmlcomponents;

/**
 * The idea is to catch all xml exceptions and wrap them in Jinq exceptions so people don't have to
 * worry about exception handling
 * 
 * @author Justin Nelson
 * 
 */
public class JinqException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public JinqException() {
		super();
	}

	public JinqException(String message) {
		super(message);
		System.out.println("");
	}

	public JinqException(String message, Jode cause) {
		this(message + ": caused By - " + cause.toString());
	}

	public JinqException(String message, JodeList cause) {
		this(message + ": caused By - " + cause.toString());
	}

	public JinqException(String message, Jocument cause) {
		this(message + ": caused By - " + cause.toString());
	}

	public JinqException(String message, Jattr cause) {
		this(message + ": caused By - " + cause.toString());
	}

	public JinqException(Exception e) {
		super(e);
	}
}
