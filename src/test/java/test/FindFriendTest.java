package test;

import Base.Base;
import Pages.FindFriendPage;
import Pages.LoginPage;
import org.testng.annotations.Listeners;
import utility.Utility;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Listeners(utility.Listeners.class)
public class FindFriendTest extends Base {
    public FindFriendTest() {
        super();
    }
    final static Logger log = Logger.getLogger(Utility.class);

    //initialize driver
    @SuppressWarnings("static-access")
    @BeforeMethod
    public void triggerDriver(){
        try {
            utility.initializeDriver(prop.getProperty("browser"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

// Method: find the friend test.
    @Test
    public void findfriend() {
        log.info("*****Start the find friend test*****");
        LoginP = new LoginPage();
        LoginP.loginUser();
        FindFriendPage friend =new FindFriendPage();
        friend.FindFriend();
        String homePageTitle = LoginPage.verifyHomePage();
        assertEquals(homePageTitle, "Friends | Facebook");
    }


    //close driver.
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
