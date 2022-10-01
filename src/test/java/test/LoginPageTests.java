package test;

import Base.Base;
import Pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends Base {
    public LoginPageTests() {
        super();
    }

 //initialize browser method.
    @SuppressWarnings("static-access")
    @BeforeMethod
    public void triggerDriver(){
        try {
            utility.initializeDriver(prop.getProperty("browser"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
///Test for Read Excel sheet data
    @Test
    public void validateInvalidLoginCredTest() {
        LoginP=new LoginPage();
        message=LoginP.validateInvalidLoginCred();
        // assertEquals(message,"The password that you've entered is incorrect. Forgotten password?");

    }

    // close browser method.
    @SuppressWarnings("static-access")
    @AfterMethod
    public void terminateDriver() {
        try {
            Thread.sleep(4000);
            utility.closeDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
