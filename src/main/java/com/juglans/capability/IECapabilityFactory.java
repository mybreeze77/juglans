package com.juglans.capability;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.juglans.util.FileUtil;

/**
 * IE Driver Only supports Windows
 * @author Junlong Wu
 *
 */
public class IECapabilityFactory implements ICapabilityFactory {

	public DesiredCapabilities generateCapability() throws IOException {
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setBrowserName("internet explorer");
		cap.setCapability("acceptSslCerts", true);
		configureDriver();
		return cap;
	}
	
	private void configureDriver() throws IOException {
		File file = null;
		file = FileUtil.copyFile("/webdriver/IEDriverServer32.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	}
	
}
