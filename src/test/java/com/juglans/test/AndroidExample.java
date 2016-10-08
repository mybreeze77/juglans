package com.juglans.test;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.juglans.log.LogAction;
import com.juglans.page.MobileTestPage;

public class AndroidExample {

	@Test(invocationCount = 1, threadPoolSize = 5)
	public void testMethod() throws MalformedURLException {
		MobileTestPage page = new MobileTestPage();
		page.btn1.click();
		page.plus.click();
		page.btn3.click();
		LogAction.logScreenshot();
	}
	
}
