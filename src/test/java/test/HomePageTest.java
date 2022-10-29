package test;

import Base.Base;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.annotations.Listeners;
import utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Listeners(utility.Listeners.class)
public class HomePageTest extends Base {
    public static Logger log = LogManager.getLogger(Utility.class);
    public HomePageTest() {
        super();
    }

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
    ///Post video test
    @Test(priority = 4)
    public void post_vid() {
        log.info("*****Run post video test*****");

        LoginP = new LoginPage();
        LoginP.loginUser();
        HomePage vid = new HomePage();
        vid.post_video();
        String PostTime =  Utility.Verify_postvideo();
        assertEquals(PostTime, "1 m");
    }
    ///Post photo test
    @Test(priority = 3)
    public void post_image() {
        log.info("*****Run post image test*****");
        LoginP = new LoginPage();
        LoginP.loginUser();
        HomePage img = new HomePage();
        img.post_photo();
        String PostTime =  Utility.Verify_postImage();
        assertEquals(PostTime, "1 m");
    }
    //Post Image or Video Story
    @Test(priority = 2)
    public void Post_Story() {
        log.info("*****Run post story test*****");

        LoginP = new LoginPage();
        LoginP.loginUser();
        HomePage story = new HomePage();
        story.Add_Story();
        String homePageTitle = LoginPage.verifyHomePage();
        assertEquals(homePageTitle, "(1) Create stories | Facebook");
    }
    //post the text format story
    @Test(priority = 1)
    public void post_Story() {
        log.info("*****Run post story test*****");

        LoginP = new LoginPage();
        LoginP.loginUser();
        HomePage story = new HomePage();
        story.Add_Text_Story();
        String homePageTitle = LoginPage.verifyHomePage();
        assertEquals(homePageTitle, "Create stories | Facebook");
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
