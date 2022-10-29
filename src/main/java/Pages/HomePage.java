package Pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import utility.Utility;

import java.awt.*;
import java.awt.event.KeyEvent;


import java.util.concurrent.TimeUnit;

import static Base.Base.driver;

public class HomePage {
    @FindBy(xpath = "(//span[contains(text(),'Omkar Bade')])[1]")
    WebElement nameBtn;

    @FindBy(xpath = "(//span[contains(text(),'Just now')])[1]")
    WebElement TimeBtn;
    @FindBy(xpath = "(//div[@class='x6s0dn4 xwnonoy xlid4zk x13tp074 x1qns1p2 xipx5yg x78zum5 x10w6t97 xl56j7k x1td3qas'])[1]")
    WebElement CreateStoryBtn;
    @FindBy(xpath = "//div[@aria-label='Share to Story']//div[@class='x1n2onr6 x1ja2u2z x78zum5 x2lah0s xl56j7k x6s0dn4 xozqiw3 x1q0g3np xi112ho x17zwfj4 x585lrc x1403ito x972fbf xcfux6l x1qhh985 xm0m39n x9f619 xn6708d x1ye3gou xtvsq51 x1r1pt67']")
    WebElement ShareToStory;

    @FindBy(xpath = "//div[contains(text(),'Create a Photo Story')]")
    WebElement CratePhotoStory;

    @FindBy(xpath = "//div[contains(text(),'Create a Text Story')]")
    WebElement CrateTextStory;
    @FindBy(xpath = "//label[@aria-label='Start typing']")
    WebElement TextField;
    @FindBy(xpath = "//a[@aria-label='Home']")
    WebElement HomeBtn;

    @FindBy(xpath = "//span[contains(text(),'Photo/video')]")
    WebElement pho_vidBtn;

    @FindBy(xpath = "//span[contains(text(),'Add photos/videos')]")
    WebElement addph_viddBtn;

    @FindBy(xpath = "//div[@aria-label='Post']//div[@class='x1n2onr6 x1ja2u2z x78zum5 x2lah0s xl56j7k x6s0dn4 xozqiw3 x1q0g3np xi112ho x17zwfj4 x585lrc x1403ito x972fbf xcfux6l x1qhh985 xm0m39n x9f619 xn6708d x1ye3gou xtvsq51 x1r1pt67']")
    WebElement postBtn;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }
 WebDriverWait wait = new WebDriverWait(driver,90);

    //Method : Post the video on facebook.
    public void post_video() {
        try {

            wait.until(ExpectedConditions.visibilityOfAllElements(pho_vidBtn));
            pho_vidBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(addph_viddBtn));
            addph_viddBtn.click();
            Runtime.getRuntime().exec("C:\\Users\\OMKAR BADE\\IdeaProjects\\POM_Framework\\uploadvideo.exe").waitFor(15, TimeUnit.SECONDS);
            Thread.sleep(5000);
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            wait.until(ExpectedConditions.visibilityOfAllElements(postBtn));
            wait.until(ExpectedConditions.elementToBeClickable(postBtn));
            postBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(nameBtn));
            Thread.sleep(3000);
            int x = nameBtn.getLocation().getX();
            int y =nameBtn.getLocation().getY();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(" + x + ", " + y + ")");
            nameBtn.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Method : Post the Photo on Facebook.
    public void post_photo() {
        try {

            wait.until(ExpectedConditions.visibilityOfAllElements(pho_vidBtn));
            pho_vidBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(addph_viddBtn));
            addph_viddBtn.click();
            Runtime.getRuntime().exec("C:\\Users\\OMKAR BADE\\IdeaProjects\\POM_Framework\\CoverPhoto.exe");
            Thread.sleep(5000);
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            wait.until(ExpectedConditions.visibilityOfAllElements(postBtn));
            wait.until(ExpectedConditions.elementToBeClickable(postBtn));
            postBtn.click();
            Thread.sleep(15000);
            wait.until(ExpectedConditions.visibilityOfAllElements(nameBtn));
            int x = nameBtn.getLocation().getX();
            int y =nameBtn.getLocation().getY();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(" + x + ", " + y + ")");
            nameBtn.click();
            Thread.sleep(30000);
            driver.navigate().refresh();
//            Thread.sleep(20000);
            wait.until(ExpectedConditions.visibilityOfAllElements(TimeBtn));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    ///  method: Add story
    public void Add_Story() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(CreateStoryBtn));
            CreateStoryBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(CratePhotoStory));
            CratePhotoStory.click();
            Runtime.getRuntime().exec("C:\\Users\\OMKAR BADE\\IdeaProjects\\POM_Framework\\CoverPhoto.exe").waitFor(30, TimeUnit.SECONDS);
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            wait.until(ExpectedConditions.elementToBeClickable(ShareToStory));
            ShareToStory.click();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    ///Method : Add text story on facebook.
    public void Add_Text_Story() {
        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(CreateStoryBtn));
            CreateStoryBtn.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(CrateTextStory));
            CrateTextStory.click();
            wait.until(ExpectedConditions.visibilityOfAllElements(TextField));
            TextField.click();
            TextField.sendKeys("Workout");
            wait.until(ExpectedConditions.visibilityOfAllElements(ShareToStory));
            ShareToStory.click();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
