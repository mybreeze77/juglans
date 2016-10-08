package com.juglans.capability;

import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.juglans.util.ContextUtil;

/**
 * Android capability supports Appium
 * @author Junlong Wu
 *
 */
public class AndroidCapabilityFactory implements ICapabilityFactory {

	@Override
	public DesiredCapabilities generateCapability() throws IOException {
		DesiredCapabilities cap = DesiredCapabilities.android();
		cap.setCapability("platformName", "Android");
//		cap.setBrowserName(ContextUtil.getBrowserName());
		cap.setCapability("deviceName", ContextUtil.getDeviceName());
		cap.setCapability("platformVersion", ContextUtil.getPlatformVersion());
		cap.setCapability("appPackage", ContextUtil.getAppPackage());
		cap.setCapability("appActivity", ContextUtil.getAppActivity());
		return cap;
	}
	
}
