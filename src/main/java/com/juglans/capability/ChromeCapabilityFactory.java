package com.juglans.capability;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.juglans.util.FileUtil;
import com.juglans.util.OSUtil;

/**
 * Only supports Windows and Mac currently
 * @author Junlong Wu
 *
 */
public class ChromeCapabilityFactory implements ICapabilityFactory {

	public DesiredCapabilities generateCapability() throws IOException {
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setCapability("acceptSslCerts", true);
		configureDriver();
		return cap;
	}
	
	private void configureDriver() throws IOException {
		File file = null;
		if (OSUtil.isWindows()) {
			file = FileUtil.copyFile("/webdriver/chromedriver.exe");
		} else if (OSUtil.isMacOS() || OSUtil.isMacOSX()) {
			file = FileUtil.copyFile("/webdriver/chromedriver");
			file.setExecutable(true);
		}
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}
	
}
