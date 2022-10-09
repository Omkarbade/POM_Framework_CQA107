package Pages;

import Utility.Utility;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import static Base.Base.driver;
import static Base.Base.prop;

public class ProfilePage {
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

    @FindBy(xpath = "//span[contains(text(),'Edit Cover Photo')]")
    WebElement AddCovPhoto;

    @FindBy(xpath = "(//div[contains(@class,'i85zmo3j alzwoclg jl2a5g8c cgu29s5g sl27f92c aeinzg81')])[2]")
    WebElement UploadPhoto;

    @FindBy(xpath = "(//span[@class='b6ax4al1 lq84ybu9 hf30pyar om3e55n1 oshhggmv qm54mken'][normalize-space()='Save changes'])[2]")
    WebElement save_changes;
    @FindBy(xpath = "(//p[@class='x1mh8g0r xat24cr x11i5rnm xdj266r'])[1]")
    WebElement comment;

    @FindBy(xpath = "(//span[contains(text(),'Like')])[1]")
    WebElement LikeBtn;
public ProfilePage(){
    PageFactory.initElements(driver, this);
}
    WebDriverWait wait = new WebDriverWait(driver, 40);

    //Method : Upload profile photo.

    public void UploadProfilephoto() {
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            password.sendKeys(prop.getProperty("password"));
            loginBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(nameBtn));
            nameBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(uploadphoto));
            uploadphoto.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(addphoto));
            addphoto.click();
            Runtime.getRuntime().exec("C:\\Users\\OMKAR BADE\\Desktop\\profileUpload.exe");
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            wait.until(ExpectedConditions.visibilityOfAllElements(save));
            save.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method : Upload cover photo on profile.
    public void coverphoto() {
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            password.sendKeys(prop.getProperty("password"));
            loginBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(nameBtn));
            nameBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(AddCovPhoto));
            AddCovPhoto.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(uploadphoto));
            UploadPhoto.click();

            //driver.switchTo().frame(1);
            Runtime.getRuntime().exec("C:\\Users\\OMKAR BADE\\Desktop\\CoverPhoto.exe").waitFor(15, TimeUnit.SECONDS);

            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            wait.until(ExpectedConditions.visibilityOfAllElements(save_changes));
            save_changes.click();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ///Method : Comment on photo.
    public void comment_photo() {
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            password.sendKeys(prop.getProperty("password"));
            wait.until(ExpectedConditions.visibilityOfAllElements(loginBtn));
            loginBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(nameBtn));
            nameBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(comment));
            comment.click();
            Utility.RandomString();
//            comment.sendKeys("good");
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void Like_photo() {
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            password.sendKeys(prop.getProperty("password"));
            wait.until(ExpectedConditions.visibilityOfAllElements(loginBtn));
            loginBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(nameBtn));
            nameBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(comment));
            LikeBtn.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
