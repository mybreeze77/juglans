package com.juglans.driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.juglans.capability.AndroidCapabilityFactory;
import com.juglans.capability.ChromeCapabilityFactory;
import com.juglans.capability.FirefoxCapabilityFactory;
import com.juglans.capability.IECapabilityFactory;
import com.juglans.exception.WebDriverConfException;

/**
 * Launch concrete webdriver based on user's requirement.
 * Leverage ThreadLocal to manage sessions when executing multiple test cases.
 * @author Junlong Wu
 *
 */
public class DriverLauncher {

	public final static String INSTANCE = "instance";
	public final static String GRIDHUBURL = "gridHubUrl";

	private static ThreadLocal<Map<String, Object>> sessions = new InheritableThreadLocal<Map<String, Object>>();

	public static WebDriver webdriver() {
		WebDriver driver = (WebDriver) get(INSTANCE);
		if (driver == null) {
			throw new WebDriverException("Driver is not launched");
		}
		return driver;
	}

	public static String getBrowserName() {
		return (String) get("browserName");
	}
	
	public static String getPlatformName() {
		return (String) get("platformName");
	}

	public static void start(String browserName, String platformName) {
		put("browserName", browserName);
		put("platformName", platformName);
		DesiredCapabilities cap = null;
		WebDriver driver = null;
		try {
			if(platformName != null && platformName.equalsIgnoreCase("android")) {
				cap = new AndroidCapabilityFactory().generateCapability();
				driver = getRemoteGridUrl() != null ? new AndroidDriver<MobileElement>(new URL(getRemoteGridUrl()), cap) : null;
			} else if(browserName.equalsIgnoreCase("chrome")) {
				cap = new ChromeCapabilityFactory().generateCapability();
				driver = getRemoteGridUrl() != null ? new RemoteWebDriver(new URL(getRemoteGridUrl()), cap) : new ChromeDriver(cap);
			} else if(browserName.equalsIgnoreCase("firefox")) {
				cap = new FirefoxCapabilityFactory().generateCapability();
				driver = getRemoteGridUrl() != null ? new RemoteWebDriver(new URL(getRemoteGridUrl()), cap) : new FirefoxDriver(cap);
			} else if(browserName.equalsIgnoreCase("ie")) {
				cap = new IECapabilityFactory().generateCapability();
				driver = getRemoteGridUrl() != null ? new RemoteWebDriver(new URL(getRemoteGridUrl()), cap) : new InternetExplorerDriver(cap);
			}
		} catch (IOException e) {
			throw new WebDriverConfException("Check your driver path");
		}

		put(INSTANCE, driver);

	}

	public static void stop() {
		webdriver().quit();
	}

	public static Map<String, Object> getCurrentSession() {
		Map<String, Object> currentSession = sessions.get();
		if (currentSession == null) {
			currentSession = new HashMap<String, Object>();
			sessions.set(currentSession);
		}
		return currentSession;
	}

	public static Object get(String key) {
		return getCurrentSession().get(key);
	}

	public static void put(String key, Object value) {
		getCurrentSession().put(key, value);
	}

	private static void putAll(Map<String, ? extends Object> params) {
		getCurrentSession().putAll(params);
	}

	public static void setContext(Map<String, String> params) {
		putAll(params);
	}

	private static String getRemoteGridUrl() {
		Object url = get(GRIDHUBURL);
		return url != null ? (String)url : null;
	}
	
}
