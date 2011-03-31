package JsonClient.Java.logging;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Static class for creating logs.
 * 
 * @author justin nelson
 * 
 */
public class Log {

	static {
		DOMConfigurator.configure("files/log_config.xml");
	}

	/**
	 * Gives you a logger for the class that called it.
	 * 
	 * @return a logger
	 */
	private static Logger getLogger() {
		// Grabs the stacktrace element a few up the stack.
		// 0 is the call to getStackTrace
		// 1 is this method
		// 2 is the wrapper method around this log method
		// 3 is the method we want
		StackTraceElement trace = Thread.currentThread().getStackTrace()[3];
		return Logger.getLogger(trace.getClassName());
	}

	/**
	 * Logs a message
	 * 
	 * @param message
	 */
	public static void trace(Object message) {
		getLogger().trace(message);
	}

	/**
	 * Logs a message
	 * 
	 * @param message
	 */
	public static void debug(Object message) {
		getLogger().debug(message);
	}

	/**
	 * Logs a message
	 * 
	 * @param message
	 */
	public static void info(Object message) {
		getLogger().info(message);
	}

	/**
	 * Logs a message
	 * 
	 * @param message
	 */
	public static void warn(Object message) {
		getLogger().warn(message);
	}

	/**
	 * Logs a message
	 * 
	 * @param message
	 * @param error
	 */
	public static void warn(Object message, Exception error) {
		getLogger().warn(message, error);
	}

	/**
	 * Logs a message
	 * 
	 * @param message
	 */
	public static void error(Object message) {
		getLogger().error(message);
	}

	/**
	 * Logs a message
	 * 
	 * @param message
	 * @param error
	 */
	public static void error(Object message, Exception error) {
		getLogger().error(message, error);
	}

}
