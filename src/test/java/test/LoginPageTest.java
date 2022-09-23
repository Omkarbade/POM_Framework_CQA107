package test;

import Base.Base;
import Pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Listeners()
public class LoginPageTest extends Base {
    public LoginPageTest() {
        super();
    }


  @SuppressWarnings("static-access")
    @BeforeMethod
    public void triggerDriver(){
        try {
            utility.initializeDriver(prop.getProperty("browser"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public  void chromeLogin() {

        String url=prop.getProperty("baseURL");
        driver.get(url);
    }
    @Test
    public  void validloginPageWithConfigDataTest() {
        LoginPage LoginP = new LoginPage();
        LoginP.loginUser();
        String homePageTitle = LoginP.verifyHomePage();
        assertEquals(homePageTitle, "Facebook");
        System.out.println(homePageTitle);
    }
    @Test
    public void validateInvalidLoginCredTest() {
        LoginP=new LoginPage();
        message=LoginP.validateInvalidLoginCred();
      //  assertEquals(message,"The password that you've entered is incorrect. Forgotten password?");

    }
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
