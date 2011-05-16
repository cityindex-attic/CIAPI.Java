package xmlcomponents;

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
	}

	public JinqException(String message, Jode cause) {
		super(message + ": caused By - " + cause.toString());
	}

	public JinqException(String message, JodeList cause) {
		super(message + ": caused By - " + cause.toString());
	}

	public JinqException(String message, Jocument cause) {
		super(message + ": caused By - " + cause.toString());
	}

	public JinqException(String message, Jattr cause) {
		super(message + ": caused By - " + cause.toString());
	}

	public JinqException(Exception e) {
		super(e);
	}
}
