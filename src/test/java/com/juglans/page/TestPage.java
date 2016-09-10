package com.juglans.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestPage extends BasePage<TestPage> {

	public static final String PAGE_URL = "http://www.github.com";
	
	@Override
	protected void isLoaded() {
		search.isEnabled();
	}
	
	@FindBy(name = "q") 
	public WebElement search;
	
	@FindBy(xpath = "//div[contains(@role,'banner')]//a[@class='header-logo-invertocat']")
	public WebElement icon;
	
	@FindBy(linkText = "Pull requests") 
	public WebElement pullRequest;
	
	@FindBy(xpath = "//form[@action='/join']/button")
	public WebElement signUp;
	
	public void searchOperation(String message) {
		search.sendKeys(message);
		search.sendKeys(Keys.ENTER);
		this.waitElementInDom(By.name("q"), 5);
	}
	
}
