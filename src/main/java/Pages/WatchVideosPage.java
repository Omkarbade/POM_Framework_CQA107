package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WatchVideosPage extends LoginPage{
    @FindBy(xpath = "//span[text()='Watch']")
    WebElement watchBtn;
    @FindBy(xpath = "//div [@id=watch_feed]")
    WebElement clickwatchBtn;

    public void watchVideos() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            password.sendKeys(prop.getProperty("password"));
            wait.until(ExpectedConditions.visibilityOfAllElements(loginBtn));
            loginBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(homeBtn));
            homeBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(watchBtn));
            watchBtn.click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (int i = 1; i < 10; i++) {
                js.executeScript("window.scrollBy(0, 1000)");
                Thread.sleep(3000);
            }
            for (int i = 1; i < 10; i++) {
                js.executeScript("window.scrollBy(0, -1000)");
                Thread.sleep(3000);
            }
            wait.until(ExpectedConditions.visibilityOfAllElements(clickwatchBtn));
            clickwatchBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(homeBtn));
            homeBtn.click();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
