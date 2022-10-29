package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static Base.Base.*;
import static org.testng.Assert.assertEquals;

public class ProfilePage {

    @FindBy(xpath = "(//span[contains(text(),'Omkar Bade')])[1]")
    WebElement nameBtn;

    @FindBy(xpath = "//div[@aria-label='Update profile picture']")
    WebElement uploadphoto;

    @FindBy(xpath = "//span[contains(text(),'Upload Photo')]")
    WebElement addphoto;

    @FindBy(xpath = "//span[contains(text(),'Save')]")
    WebElement save;

    @FindBy(xpath = "//span[contains(text(),'Edit Cover Photo')]")
    WebElement AddCovPhoto;

    @FindBy(xpath = "//span[normalize-space()='Upload photo']")
    WebElement UploadPhoto;

    @FindBy(xpath = "(//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft'][normalize-space()='Save changes'])[2]")
    WebElement save_changes;
    @FindBy(xpath = "(//p[@class='x1mh8g0r xat24cr x11i5rnm xdj266r'])[1]")
    WebElement comment;
    @FindBy(xpath = "(//span[contains(text(),'Like')])[1]")
    WebElement LikeBtn;

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    WebDriverWait wait = new WebDriverWait(driver, 90);

    //Method : Upload profile photo.

    public void UploadProfilephoto() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(nameBtn));
            nameBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(uploadphoto));
            uploadphoto.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(addphoto));
            addphoto.click();
            Runtime.getRuntime().exec("C:\\Users\\OMKAR BADE\\IdeaProjects\\POM_Framework\\profileUpload.exe").waitFor(20, TimeUnit.SECONDS);
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            wait.until(ExpectedConditions.visibilityOfAllElements(save));
            save.click();
            Thread.sleep(5000);
            driver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //method : Upload cover photo on profile.
    public void coverphoto() {
        try {

            wait.until(ExpectedConditions.visibilityOfAllElements(nameBtn));
            nameBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(AddCovPhoto));
            AddCovPhoto.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(uploadphoto));
            UploadPhoto.click();
            Runtime.getRuntime().exec("C:\\Users\\OMKAR BADE\\IdeaProjects\\POM_Framework\\CoverPhoto.exe").waitFor(20, TimeUnit.SECONDS);

            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            wait.until(ExpectedConditions.visibilityOfAllElements(save_changes));
            save_changes.click();
            Thread.sleep(35000);
            driver.navigate().refresh();
//            int x = nameBtn.getLocation().getX();
//            int y =nameBtn.getLocation().getY();
//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("window.scrollBy(" + x + ", " + y + ")");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ///Method : Comment on photo.
    public void comment_photo() {
        try {
            String random= Utility.RandomString();
            wait.until(ExpectedConditions.visibilityOfAllElements(nameBtn));
            nameBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(comment));
            comment.click();
            comment.sendKeys(random);
//            comment.sendKeys("good");
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
//            String PostTime =  Utility.Verifyrandomcomment();
//            assertEquals(PostTime, "1 m");
            String comment=Utility.verifycomment();
            Assert.assertEquals(comment,random );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method : Like A photo or Video.
    public void Like_photo() {
        try {

            wait.until(ExpectedConditions.visibilityOfAllElements(nameBtn));
            nameBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(LikeBtn));
            String like =LikeBtn.getAttribute("style");

            switch (like) {
                case "color: rgb(32, 120, 244);":
                    System.out.println("post is already liked");

                    break;

                default:
                    LikeBtn.click();
                    System.out.println("post is liked");
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

