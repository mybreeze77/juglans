# juglans
Front-End UI Automation framework based on Selenium 3.0 and TestNG. This project is developed as a "Project of Concept" to provide convenience and reusability in UI Automation. Remember, it's an experimental project. So don't just clone and use it directly. Try to change something and practise by yourselves.

Advantage:

- Separate the dynamic paramters into TestNG profile. For example, if user wants to execute the same test plan in different browser, he can just change the parameter in TestNG XML/YAML. No any code changes.
- Page Object is wrapped to bring reusability.
- A CSV provider is provided, which allows user to manage test data easily. No any code changes.


Support Matrix:

- Java 8
- Selenium 3.0.0-beta3
- TestNG 6.9.10
- Chrome/Firefox/IE Driver/Android

## How to write Page Object

The project has encapsulated Page Object based on LoadableComponent. We can write our own page object as below example.

    public class TestPage extends BasePage<TestPage> {
    
    	//The page URL
    	public static final String PAGE_URL = "http://www.github.com";
    	
    	@Override
    	protected void isLoaded() {
    		search.isEnabled();
    		//Code slice to determine if page is totally loaded
    	}
    	
    	//Web element in this page
    	@FindBy(name = "q") 
    	public WebElement search;
    	
    	//Method in this page
    	public void searchOperation(String message) {
    		search.sendKeys(message);
    		search.sendKeys(Keys.ENTER);
    		this.waitElementInDom(By.name("q"), 5);
    	}
    }

## Data provider
We keep native TestNG dataprovider feature in the framework. Moreover, we provide an additional CSV provider, which allows user to manage test data easily. Below is the example.

CSV File (example.csv):
> 1,justin,2.0

In Test Plan:

	@DataProvider
	public Iterator<Object> provider(Method method){
	    return CSVDataProvider.getInstance(Example.class, method, "example.csv");
	}

	@Test(dataProvider = "provider", dataProviderClass = Example.class)
	public void testMethod(int id, String name, double height) {
		LogAction.logHightlight("ID is: " + id);
		LogAction.logHightlight("Name is: " + name);
		LogAction.logHightlight("Height is: " + height);
		//Omit other codes
	}

## Start Testing
As the normal TestNG suite, we need to write an XML/YAML file as the entry of the test suite, which provides basic and specific parameters. Below is the example.

	<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
	<suite name="test suite" parallel="methods" verbose="1" thread-count="10" data-provider-thread-count="10">
	
		<listeners>
			<listener class-name="com.juglans.capability.SeleniumHandler"></listener>
		</listeners>
	
		<parameter name="browserName" value="chrome" />
		<!-- <parameter name="gridHubUrl" value="http://remote.grid.hub.url:4444/wd/hub"></parameter>-->
	
		<test name="test" >
			<classes>
			   <class name="com.juglans.test.Test" />
			</classes>
		</test>
		
	</suite>

Or (YAML):

	name: test suite
	parallel: methods
	verbose: 1
	threadCount: 10 
	parameters: { browserName: chrome }
	listeners:
	  - com.juglans.capability.SeleniumHandler
	tests:
	  - name: test
	    classes: 
	      - com.juglans.test.Test

A sample test plan can be like below. Again, try to write more by yourselves.

	public class Test {
	
		@DataProvider
	    public Iterator<Object> provider(Method method){
	        return CSVDataProvider.getInstance(Test.class, method, "test.csv");
	    }
		
		@Test(dataProvider = "provider", dataProviderClass = Test.class)
		public void testMethod(String name) {
			Assertion assertion = new Assertion();
	
			TestPage page = new TestPage();
			page.setUrl(TestPage.PAGE_URL).get();
			LogAction.logScreenshot();
			
			page.searchOperation("testng");
			LogAction.logHighlight("Search is completed!");
			
			assertion.assertEquals(name, page.title.getText());
		}
	}

## Mobile Testing
Currently, Android (Native App and Web) is supported in this project. Before starting mobile testing, you need to prepare environment with [Appium](http://appium.io/), and corresponding Android SDK or real device.

Feel free to run *com.juglans.test.AndroidExample* to experience it.


## Development
Clone this project and execute *gradle build*.

Any suggestion and idea are welcomed. :)