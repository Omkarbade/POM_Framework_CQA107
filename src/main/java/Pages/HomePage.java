package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

import java.util.concurrent.TimeUnit;

import static Base.Base.driver;
import static Base.Base.prop;


public class HomePage {
    @FindBy(id = "email")
    WebElement emailId;
    @FindBy(name = "pass")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginBtn;

    @FindBy(xpath = "//span[contains(text(),'Omkar Bade')]")
    WebElement nameBtn;

    @FindBy(xpath = "(//span[contains(text(),'Like')])[1]")
    WebElement LikeBtn;
//    @FindBy(xpath = "(//div[contains(text(),'Write a comment…')])[1]")
//    WebElement comment;

    @FindBy(xpath = "(//p[@class='x1mh8g0r xat24cr x11i5rnm xdj266r'])[1]")
    WebElement comment;

    @FindBy(xpath = "//a[@aria-label='Home']")
    WebElement HomeBtn;

    @FindBy(xpath = "//span[contains(text(),'Photo/video')]")
    WebElement pho_vidBtn;

    @FindBy(xpath = "//span[contains(text(),'Add photos/videos')]")
    WebElement addph_viddBtn;

    @FindBy(xpath = "//span[contains(text(),'Post')]")
    WebElement postBtn;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }
 WebDriverWait wait = new WebDriverWait(driver,50);


    //Post the video
    public void post_video() {
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            password.sendKeys(prop.getProperty("password"));
            wait.until(ExpectedConditions.visibilityOfAllElements(loginBtn));
            loginBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(HomeBtn));
            HomeBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(pho_vidBtn));
            pho_vidBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(addph_viddBtn));
            addph_viddBtn.click();
            //driver.switchTo().frame(1);
            Runtime.getRuntime().exec("C:\\Users\\OMKAR BADE\\Desktop\\uploadvideo.exe").waitFor(15, TimeUnit.SECONDS);
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            wait.until(ExpectedConditions.visibilityOfAllElements(postBtn));
            postBtn.click();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void post_photo() {
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            wait.until(ExpectedConditions.visibilityOfAllElements(password));
            password.sendKeys(prop.getProperty("password"));
            wait.until(ExpectedConditions.visibilityOfAllElements(loginBtn));
            loginBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(HomeBtn));
            HomeBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(pho_vidBtn));
            pho_vidBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(addph_viddBtn));
            addph_viddBtn.click();
            //driver.switchTo().frame(1);
            Runtime.getRuntime().exec("C:\\Users\\OMKAR BADE\\Desktop\\CoverPhoto.exe").waitFor(15, TimeUnit.SECONDS);
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            wait.until(ExpectedConditions.visibilityOfAllElements(postBtn));
            postBtn.click();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
