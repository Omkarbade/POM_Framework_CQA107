package Pages;
import Base.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;


public class LoginPage extends Base {

    @FindBy(id = "email")
    WebElement emailId;

    @FindBy(name = "pass")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginBtn;

    @FindBy(xpath = "//a[@aria-label='Home']")
    WebElement homeBtn;

    @FindBy(className = "_9ay7")
    WebElement ErrorMsg;
    private Alert email;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void loginUser() {
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            Thread.sleep(2000);
            password.sendKeys(prop.getProperty("password"));
            Thread.sleep(2000);
            loginBtn.click();
            homeBtn.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method: login into facebok with data using xlsx sheet
     */
    @SuppressWarnings("static-access")
    public String loginUsingXlsx() {
        List<List<String>> values = new LinkedList<List<String>>();
        try {
            values.addAll(utility.excelReader());
            email.sendKeys(values.get(0).get(0));
            password.sendKeys(values.get(0).get(1));
            loginBtn.click();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return message;
    }


        public String validateInvalidLoginCred() {
            try {
                List<List<String>> values = new LinkedList<List<String>>();
                values.addAll(utility.excelReader());
                email.sendKeys(values.get(1).get(0));
                password.sendKeys(values.get(1).get(1));
                Thread.sleep(2000);
                loginBtn.click();
                message = ErrorMsg.getText();
                System.out.println(message);
            } catch (Exception e) {

            }
            return message;
        }
        public String verifyHomePage() {
            String homePageTitle = driver.getTitle();
            return homePageTitle;
        }

    }

