package CIAPI.Java.logging;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

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

	public static void trace(Object message) {
		getLogger().trace(message);
	}

	public static void debug(Object message) {
		getLogger().debug(message);
	}

	public static void info(Object message) {
		getLogger().info(message);
	}

	public static void warn(Object message) {
		getLogger().warn(message);
	}

	public static void warn(Object message, Exception error) {
		getLogger().warn(message, error);
	}

	public static void error(Object message) {
		getLogger().error(message);
	}

	public static void error(Object message, Exception error) {
		getLogger().error(message, error);
	}

}
