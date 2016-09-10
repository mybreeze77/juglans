package com.juglans.log;

import org.testng.Reporter;

/**
 * Log Action to display log message in HTML report
 * @author Junlong Wu
 *
 */
public class LogAction {

	public static void logStep(String content) {
		Reporter.log(new LogStep(content).getContentWithTime("yyyy/MM/dd HH:mm:ss"));
	}
	
	public static void logInfo(String content) {
		Reporter.log(new LogInfo(content).getContent());
	}
	
	public static void logWarning(String content) {
		Reporter.log(new LogWarning(content).getContent());
	}
	
	public static void logError(String content) {
		Reporter.log(new LogError(content).getContent());
	}
	
	public static void logHidden(String content) {
		Reporter.log(new LogHidden(content).getContent());
	}
	
	public static void logHighlight(String content) {
		Reporter.log(new LogHighlight(content).getContent());
	}
	
	public static void logScreenshot() {
		Reporter.log(new LogScreenshot().capture());
	}
	
}
