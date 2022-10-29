package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;


public class MarketPlace extends LoginPage{

    @FindBy(xpath = "//span[text()='Marketplace']")
    WebElement marketplacebtnbtn;

    @FindBy(xpath = "(//input[@placeholder='Search Marketplace'])[1]")
    WebElement SearchBtn;

    //Method : Marketplace ie user see the product for buy or sell.
    public void marketPlace() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(homeBtn));
            homeBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(marketplacebtnbtn));
            marketplacebtnbtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(SearchBtn));
            SearchBtn.click();
            SearchBtn.sendKeys("Bike");
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (int i = 1; i < 10; i++) {
                //scroll down on the webpage
                js.executeScript("window.scrollBy(0, 500)");
                Thread.sleep(3000);
            }
            for (int i = 1; i < 10; i++) {
                //scroll up on the webpage
                js.executeScript("window.scrollBy(0, -500)");
                Thread.sleep(3000);
            }
            homeBtn.click();


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
