package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import static Base.Base.driver;
import static Base.Base.prop;

/*create class and define webelements with xpath.
*create method and inside method define automation script.
 */

public class CoverPhoto {
    @FindBy(id = "email")
    WebElement emailId;

    @FindBy(name = "pass")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginBtn;

    @FindBy(xpath = "//span[contains(text(),'Omkar Bade')]")
    WebElement nameBtn;

    @FindBy(xpath = "//span[contains(text(),'Edit Cover Photo')]")
    WebElement AddCovPhoto;

    @FindBy(xpath = "(//div[contains(@class,'i85zmo3j alzwoclg jl2a5g8c cgu29s5g sl27f92c aeinzg81')])[2]")
    WebElement UploadPhoto;

    @FindBy(xpath = "(//span[@class='b6ax4al1 lq84ybu9 hf30pyar om3e55n1 oshhggmv qm54mken'][normalize-space()='Save changes'])[2]")
    WebElement save_changes;

    public CoverPhoto() {
        PageFactory.initElements(driver, this);
    }

    public void coverphoto() {
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            Thread.sleep(1000);
            password.sendKeys(prop.getProperty("password"));
            Thread.sleep(1000);
            loginBtn.click();
            Thread.sleep(500);
            nameBtn.click();
            Thread.sleep(2000);
            AddCovPhoto.click();
            Thread.sleep(1000);
            UploadPhoto.click();
            Thread.sleep(2000);
            //driver.switchTo().frame(1);
            Runtime.getRuntime().exec("C:\\Users\\OMKAR BADE\\Desktop\\CoverPhoto.exe").waitFor(15, TimeUnit.SECONDS);
            Thread.sleep(1000);
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);

            Alert confirmationAlert = driver.switchTo().alert();
            confirmationAlert.accept();
            save_changes.click();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
