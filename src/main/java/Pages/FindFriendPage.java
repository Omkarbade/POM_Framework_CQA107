package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFriendPage extends LoginPage{
    @FindBy(xpath = "//span[text()='Find friends']")
    WebElement findfriedBtn;
    @FindBy(xpath = "//span[text()='Suggestions']")
    WebElement suggestionsBtn;

     // Method: To Find Friend in facebook
    public void FindFriend() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(homeBtn));
            homeBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(findfriedBtn));
            findfriedBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(suggestionsBtn));
            suggestionsBtn.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
