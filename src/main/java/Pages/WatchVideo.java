package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WatchVideo extends LoginPage{
    @FindBy(xpath = "//span[text()='Watch']")
    static
    WebElement watchBtn;
    @FindBy(xpath = "//input[@placeholder='Search videos']")
    static
    WebElement SearchBtn;

    /// Method : Watch video on facebook.
    public static void watchVideos() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        try {

            wait.until(ExpectedConditions.visibilityOfAllElements(watchBtn));
            watchBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(SearchBtn));
            SearchBtn.click();
            SearchBtn.sendKeys("Cricket");
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (int i = 1; i < 10; i++) {
                js.executeScript("window.scrollBy(0, 500)");
                Thread.sleep(3000);
            }
            for (int i = 1; i < 10; i++) {
                js.executeScript("window.scrollBy(0, -500)");
                Thread.sleep(3000);
            }
            wait.until(ExpectedConditions.visibilityOfAllElements(homeBtn));
            homeBtn.click();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
