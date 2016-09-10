package com.juglans.capability;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.juglans.util.FileUtil;
import com.juglans.util.OSUtil;

/**
 * Only supports Windows currently
 * @author Junlong Wu
 *
 */
public class FirefoxCapabilityFactory implements ICapabilityFactory {

	@Override
	public DesiredCapabilities generateCapability() throws IOException {
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setCapability("acceptSslCerts", true);
		cap.setCapability("marionette", true);
		configureDriver();
		return cap;
	}
	
	private void configureDriver() throws IOException {
		File file = null;
		if (OSUtil.isWindows()) {
			file = FileUtil.copyFile("/webdriver/geckodriver.exe");
		} else if (OSUtil.isMacOS() || OSUtil.isMacOSX()) {
			//TODO to be implemented
		}
		System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
	}

}
