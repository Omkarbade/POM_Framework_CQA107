package Utility;

import Base.Base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

import java.io.IOException;

//create I listeners and there override methods
public class Listeners implements ITestListener {
  Utility base =new Utility();

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
    try {
      base.getScreenShots();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
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
