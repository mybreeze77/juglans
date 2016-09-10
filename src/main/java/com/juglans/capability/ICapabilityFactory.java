package com.juglans.capability;

import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;

public interface ICapabilityFactory {

	public DesiredCapabilities generateCapability() throws IOException;
	
}
