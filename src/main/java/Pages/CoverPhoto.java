package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static Base.Base.driver;
import static Base.Base.prop;

public class CoverPhoto {
    @FindBy(id = "email")
    WebElement emailId;

    @FindBy(name = "pass")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginBtn;

    @FindBy(xpath = "//span[contains(text(),'Omkar Bade')]")
    WebElement nameBtn;

    @FindBy(xpath = "//span[contains(text(),'Add Cover Photo')]")
    WebElement AddCovPhoto;

    @FindBy(xpath = "(//div[contains(@class,'i85zmo3j alzwoclg jl2a5g8c cgu29s5g sl27f92c aeinzg81')])[2]")
    WebElement UploadPhoto;


    public CoverPhoto() {
        PageFactory.initElements(driver, this);
    }

    public void coverphoto() {
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            Thread.sleep(2000);
            password.sendKeys(prop.getProperty("password"));
            Thread.sleep(2000);
            loginBtn.click();
            Thread.sleep(2000);
            nameBtn.click();
            Thread.sleep(2000);
            AddCovPhoto.click();
            Thread.sleep(2000);
            UploadPhoto.click();
            Thread.sleep(2000);
            //driver.switchTo().frame(1);
            Runtime.getRuntime().exec(System.getProperty("user.dir") +"C:\\Users\\OMKAR BADE\\Desktop\\CoverPhoto.exe").waitFor(15, TimeUnit.SECONDS);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
