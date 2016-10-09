package com.juglans.util;

import java.util.Map;

import com.juglans.driver.DriverLauncher;

/**
 * Context utility to manage parameters from TestNG
 * @author Junlong Wu
 *
 */
public class ContextUtil {

	private ContextUtil(){};
	
	public static Map<String, Object> getAllParameters() {
		return DriverLauncher.getCurrentSession();
	}
	
	public static String getParameter(String key) {
		return (String)getAllParameters().get(key);
	}
	
	public static String getBrowserName() {
		return (String)DriverLauncher.get("browserName");
	}
	
	public static String getPlatformName() {
		return (String)DriverLauncher.get("platformName");
	}
	
	public static String getPlatformVersion() {
		return (String)DriverLauncher.get("platformVersion");
	}
	
	public static String getAppPackage() {
		return (String)DriverLauncher.get("appPackage");
	}
	
	public static String getApp() {
		return (String)DriverLauncher.get("app");
	}
	
	public static String getAppActivity() {
		return (String)DriverLauncher.get("appActivity");
	}
	
	public static String getDeviceName() {
		return (String)DriverLauncher.get("deviceName");
	}
	
}
