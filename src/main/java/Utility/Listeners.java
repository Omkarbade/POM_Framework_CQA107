package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

//create I listeners and there override methods
public class Listeners implements ITestListener {
  Utility utils =new Utility();


  public void onTestStart(ITestResult result) {
    System.out.println("");
  }

  public void onTestSuccess(ITestResult result) {
    System.out.println("");
  }

  public void onTestFailure(ITestResult result) {
    String testName = result.getName();
    try {
      Utility.getScreenShots();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public void onTestSkipped(ITestResult result) {
    System.out.println("");
  }

  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    System.out.println("");
  }

  public void onStart(ITestContext context) {
    System.out.println("");
  }

  public void onFinish(ITestContext context) {
    System.out.println("");
  }

}
