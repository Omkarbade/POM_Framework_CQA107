package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

//create class and its extends base class
public class PostVideo extends Base {
    @FindBy(id = "email")
    WebElement emailId;

    @FindBy(name = "pass")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginBtn;

    @FindBy(xpath = "//a[@aria-label='Home']")
    WebElement HomeBtn;

    @FindBy(xpath = "//span[contains(text(),'Photo/video')]")
    WebElement pho_vidBtn;

    @FindBy(xpath = "//span[contains(text(),'Add photos/videos')]")
    WebElement addph_viddBtn;

    @FindBy(xpath = "//span[contains(text(),'Post')]")
    WebElement postBtn;

    //create constructor initialize web elements use pagefactory class.
    public PostVideo() {
        PageFactory.initElements(driver, this);
    }

    //create method and define automation script.

    public void postvideo_photo() {
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            Thread.sleep(2000);
            password.sendKeys(prop.getProperty("password"));
            Thread.sleep(2000);
            loginBtn.click();
            Thread.sleep(2000);
            HomeBtn.click();
            Thread.sleep(2000);
            pho_vidBtn.click();
            Thread.sleep(2000);
            addph_viddBtn.click();
            Thread.sleep(2000);
            //driver.switchTo().frame(1);
            Runtime.getRuntime().exec("C:\\Users\\OMKAR BADE\\Desktop\\uploadvideo.exe").waitFor(15, TimeUnit.SECONDS);
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            postBtn.click();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
