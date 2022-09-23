package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

import static Base.Base.driver;
import static Base.Base.prop;

public class Comment {
    @FindBy(id = "email")
    WebElement emailId;

    @FindBy(name = "pass")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginBtn;

    @FindBy(xpath = "//span[contains(text(),'Omkar Bade')]")
    WebElement nameBtn;


    @FindBy(xpath = "//p[@class='kmwttqpk kjdc1dyq l7ghb35v m8h3af8h']")
    WebElement comment;


    public Comment() {
        PageFactory.initElements(driver, this);
    }

    public void commentphoto() {
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            Thread.sleep(2000);
            password.sendKeys(prop.getProperty("password"));
            Thread.sleep(2000);
            loginBtn.click();
            Thread.sleep(2000);
            nameBtn.click();
            Thread.sleep(2000);
            comment.click();
            comment.sendKeys("good night");
            Robot r = new Robot();
            r.keyPress(KeyEvent.VK_ENTER);
            r.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
