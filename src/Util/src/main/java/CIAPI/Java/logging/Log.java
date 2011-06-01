package CIAPI.Java.logging;

import java.io.File;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Static class for creating logs.
 * 
 * @author justin nelson
 * 
 */
public class Log {

	private static boolean skipLogging = false;
	private static final boolean debug = true;
	private static final boolean trace = true;

	static {
		String desiredLogger = "files/log_config/log_config.xml";
		File f = new File(desiredLogger);
		if (f.exists()) {
			DOMConfigurator.configure(desiredLogger);
		} else {
			skipLogging = true;
			System.out
					.println("Not logging any thing :( - couldn't find log file at: "
							+ desiredLogger);
		}
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
		if (trace && !skipLogging)
			getLogger().trace(message);
	}

	/**
	 * Logs a message
	 * 
	 * @param message
	 */
	public static void debug(Object message) {
		if (debug && !skipLogging)
			getLogger().debug(message);
	}

	/**
	 * Logs a message
	 * 
	 * @param message
	 */
	public static void info(Object message) {
		if (!skipLogging)
			getLogger().info(message);
	}

	/**
	 * Logs a message
	 * 
	 * @param message
	 */
	public static void warn(Object message) {
		if (!skipLogging)
			getLogger().warn(message);
	}

	/**
	 * Logs a message
	 * 
	 * @param message
	 * @param error
	 */
	public static void warn(Object message, Exception error) {
		if (!skipLogging)
			getLogger().warn(message, error);
	}

	/**
	 * Logs a message
	 * 
	 * @param message
	 */
	public static void error(String message) {
		if (!skipLogging)
			getLogger().error(message);
	}

	/**
	 * Logs a message
	 * 
	 * @param message
	 * @throws T
	 */
	public static <T extends Throwable> void error(T message) throws T {
		if (!skipLogging)
			getLogger().error(message);
		throw message;
	}

	/**
	 * Logs a message
	 * 
	 * @param message
	 * @param error
	 */
	public static void error(Object message, Exception error) {
		if (!skipLogging)
			getLogger().error(message, error);
	}
}
