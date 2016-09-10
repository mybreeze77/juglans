package com.juglans.log;

import java.io.File;
import java.util.UUID;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;

import com.juglans.driver.DriverLauncher;

public class LogScreenshot extends BaseLog {

	public LogScreenshot() {
		super();
	}
	
	public String capture() {
		TakesScreenshot screenshot = (TakesScreenshot) new Augmenter().augment(DriverLauncher.webdriver());
        File file = new File(UUID.randomUUID().toString());
        File screenhot = screenshot.getScreenshotAs(OutputType.FILE);
        screenhot.renameTo(file);
		return String.format("<img src='%s' />", file.getAbsolutePath());
	}
	
}
