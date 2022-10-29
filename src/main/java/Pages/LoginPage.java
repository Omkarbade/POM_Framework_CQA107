package Pages;
import Base.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;

//create class and its extends base class

public class LoginPage extends Base {

    @FindBy(name = "email")
    WebElement emailId;

    @FindBy(name = "pass")
    WebElement password;

    @FindBy(name = "login")
    WebElement loginBtn;

    @FindBy(xpath = "//a[@aria-label='Home']")
    static
    WebElement homeBtn;

    @FindBy(className = "_9ay7")
    WebElement ErrorMsg;
    private Alert email;

    //create constructor initialize web elements use pagefactory class.
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    // to check user able to login or not.
    public void loginUser() {
        try {
            emailId.sendKeys(prop.getProperty("emailId"));
            Thread.sleep(2000);
            password.sendKeys(prop.getProperty("password"));
            Thread.sleep(2000);
            loginBtn.click();
            Thread.sleep(1000);
//            homeBtn.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Method: login into facebok with data using xlsx sheet
     */
//    @SuppressWarnings("static-access")
//    public String loginUsingXlsx() {
//        List<List<String>> values = new LinkedList<List<String>>();
//        try {
//            values.addAll(utility.excelReader());
//            email.sendKeys(values.get(0).get(0));
//            password.sendKeys(values.get(0).get(1));
//            loginBtn.click();
//        } catch (Exception e) {
//
//            e.printStackTrace();
//        }
//        return message;
//    }

    /**
     * Method: login into facebok with data using excel sheet.
     */
        public String validateInvalidLoginCred() {
            try {
                List<List<String>> values = new LinkedList<List<String>>();
                values.addAll(utility.excelReader());
                Thread.sleep(2000);
                System.out.println("username "+values.get(0).get(0));
                System.out.println("password "+values.get(0).get(1));
                Thread.sleep(1000);
                email.sendKeys(values.get(0).get(0));
                Thread.sleep(1000);
                password.sendKeys(values.get(0).get(1));
                Thread.sleep(2000);
                loginBtn.click();
                message = ErrorMsg.getText();
                System.out.println(message);

            } catch (Exception e) {

            }
            return message;
        }
        // its verify homepage title and its return title.
        public static String verifyHomePage() {
            String homePageTitle = driver.getTitle();
            return homePageTitle;
        }

    }

