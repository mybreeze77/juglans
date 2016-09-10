package com.juglans.test;

import java.lang.reflect.Method;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.juglans.log.LogAction;
import com.juglans.page.TestPage;
import com.juglans.util.CSVDataProvider;

public class Example {

	@DataProvider
    public Iterator<Object> provider(Method method){
        return CSVDataProvider.getInstance(Example.class, method, "example.csv");
    }
	
	@Test(invocationCount = 1, threadPoolSize = 5)
	public void testMethod1() {
		TestPage page = new TestPage();
		page.setUrl(TestPage.PAGE_URL).get();
		LogAction.logScreenshot();
		
		page.searchOperation("testng");
		LogAction.logHighlight("Search is completed!");
		
		LogAction.logScreenshot();
	}

	@Test(invocationCount = 1, threadPoolSize = 5, dataProvider = "provider", dataProviderClass = Example.class)
	public void testMethod2(int id, String name) {
		String idName = id + "-" + name;
		LogAction.logStep(idName);
	}
	
	@Test(invocationCount = 1, threadPoolSize = 5)
	public void testMethod3() {
		TestPage page = new TestPage();
		page.setUrl(TestPage.PAGE_URL).get();
		page.waitElementBeClickable(page.signUp, 10);
	}
	
}
