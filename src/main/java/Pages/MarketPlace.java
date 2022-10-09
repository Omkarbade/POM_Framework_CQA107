package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MarketPlace extends LoginPage{

    @FindBy(xpath = "//span[text()='Marketplace']")
    WebElement marketplacebtnbtn;

    public void marketPlace() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            password.sendKeys(prop.getProperty("password"));
            wait.until(ExpectedConditions.visibilityOfAllElements(loginBtn));
            loginBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(homeBtn));
            homeBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(marketplacebtnbtn));
            marketplacebtnbtn.click();

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
