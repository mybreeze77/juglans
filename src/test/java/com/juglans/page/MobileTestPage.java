package com.juglans.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileTestPage extends BasePage<MobileTestPage> {

	public static final String PAGE_URL = "NO NEED";
	
	@Override
	protected void isLoaded() {
		btn1.isEnabled();
	}
	
	@FindBy(name = "1") 
	public WebElement btn1;
	
	@FindBy(name = "2") 
	public WebElement btn2;
	
	@FindBy(name = "3") 
	public WebElement btn3;
	
	@FindBy(name = "plus") 
	public WebElement plus;
	
}
