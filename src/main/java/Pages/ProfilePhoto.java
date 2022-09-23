package Pages;

import Base.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class ProfilePhoto extends Base {

    @FindBy(id = "email")
    WebElement emailId;

    @FindBy(name = "pass")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginBtn;

    @FindBy(xpath = "//span[contains(text(),'Omkar Bade')]")
    WebElement nameBtn;

    @FindBy(xpath = "//div[@aria-label='Update profile picture']//i[@class='gneimcpu b0w474w7']")
    WebElement uploadphoto;

    @FindBy(xpath = "//span[contains(text(),'Upload Photo')]")
    WebElement addphoto;

    @FindBy (xpath = "//span[contains(text(),'Save')]")
    WebElement save;

    public ProfilePhoto() {
        PageFactory.initElements(driver, this);
    }

    public void UploadProfilephoto() {
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            Thread.sleep(2000);
            password.sendKeys(prop.getProperty("password"));
            Thread.sleep(2000);
            loginBtn.click();
            Thread.sleep(2000);
            nameBtn.click();
            Thread.sleep(2000);
            uploadphoto.click();
            Thread.sleep(2000);
            addphoto.click();
            Thread.sleep(2000);
            //driver.switchTo().frame(1);
         Runtime.getRuntime().exec(System.getProperty("user.dir") +"C:\\Users\\OMKAR BADE\\Desktop\\profileUpload.exe").waitFor(15, TimeUnit.SECONDS);
            Thread.sleep(2000);
            save.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

