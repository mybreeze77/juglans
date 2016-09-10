package com.juglans.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.juglans.driver.DriverLauncher;
import com.juglans.exception.PageNotCorrectException;

/**
 * Page Object wrapper extends LoadableComponent
 * @author Junlong Wu
 *
 * @param <T> can be concrete page
 */
public class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {
	
	protected final WebDriver driver = DriverLauncher.webdriver();
	
    public BasePage() {
		super();
		PageFactory.initElements(driver, this);
	}

    private String url = null;
    
	public String getUrl() {
		return url;
	}

	@SuppressWarnings("unchecked")
	public T setUrl(String url) {
		this.url = url;
		return (T)this;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
    public void refresh() {
    	driver.navigate().refresh();
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public T get() {
    	driver.get(url);
    	waitForLoad(driver);
    	try {
    		isLoaded();
    		return (T)this;
    	} catch (Exception e) {
    		throw new PageNotCorrectException();
    	}
    	
    }
    
    /**
     * Leverage status of document.readyState to decide if page is loaded.
     * If massive AJAX is using, this method cannot guarantee page is totally loaded.
     * We can use isLoaded() method as a supplier.
     * @param driver
     */
	private void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}
	
	public void waitElementInDom(By by, long waitSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void waitElementBeVisible(By by, long waitSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitElementBeClickable(WebElement element, long waitSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitElementBeSelected(WebElement element, long waitSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
	}
    
}
