package com.juglans.capability;

import java.util.Map;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener2;
import org.testng.ITestContext;
import org.testng.ITestResult;
import com.juglans.driver.DriverLauncher;

/**
 * Manage driver start and stop in TestNG method level
 * @author Junlong Wu
 *
 */
public class SeleniumHandler implements IInvokedMethodListener2 {

  public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
      DriverLauncher.setContext(getParams(context));
      String browserName = (String) context.getCurrentXmlTest().getParameter("browserName");
      DriverLauncher.start(browserName);
  }

  public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
      DriverLauncher.stop();
  }

  private Map<String, String> getParams(ITestContext context) {
	  Map<String, String> params = context.getCurrentXmlTest().getAllParameters();
	  return params;
  }

  public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
    // TODO Auto-generated method stub
  }

  public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
    // TODO Auto-generated method stub
  }

}
