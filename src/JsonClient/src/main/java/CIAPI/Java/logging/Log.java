package CIAPI.Java.logging;

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
		StackTraceElement trace = Thread.currentThread().getStackTrace()[3];
		return Logger.getLogger(trace.getClassName());
	}

	/**
	 * Loggs a message
	 * 
	 * @param message
	 */
	public static void trace(Object message) {
		getLogger().trace(message);
	}

	/**
	 * Loggs a message
	 * 
	 * @param message
	 */
	public static void debug(Object message) {
		getLogger().debug(message);
	}

	/**
	 * Loggs a message
	 * 
	 * @param message
	 */
	public static void info(Object message) {
		getLogger().info(message);
	}

	/**
	 * Loggs a message
	 * 
	 * @param message
	 */
	public static void warn(Object message) {
		getLogger().warn(message);
	}

	/**
	 * Loggs a message
	 * 
	 * @param message
	 * @param error
	 */
	public static void warn(Object message, Exception error) {
		getLogger().warn(message, error);
	}

	/**
	 * Loggs a message
	 * 
	 * @param message
	 */
	public static void error(Object message) {
		getLogger().error(message);
	}

	/**
	 * Loggs a message
	 * 
	 * @param message
	 * @param error
	 */
	public static void error(Object message, Exception error) {
		getLogger().error(message, error);
	}

}
