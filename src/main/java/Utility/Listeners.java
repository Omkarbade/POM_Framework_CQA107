package Utility;

import Base.Base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

public class Listeners implements ITestListener {
  Base base =new Base();

  @Override
  public void onTestStart(ITestResult result) {
    System.out.println("");
  }
  @Override
  public void onTestSuccess(ITestResult result) {
    System.out.println("");
  }
  @Override
  public void onTestFailure(ITestResult result) {
    String testName = result.getName();
    base.getScreenShots("LoginPageTest");
  }
  @Override
  public void onTestSkipped(ITestResult result) {
    System.out.println("");
  }
  @Override
  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    System.out.println("");
  }
  @Override
  public void onStart(ITestContext context) {
    System.out.println("");
  }
  @Override
  public void onFinish(ITestContext context) {
    System.out.println("");
  }

}
