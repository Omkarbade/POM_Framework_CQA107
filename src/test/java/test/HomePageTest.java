package test;

import Base.Base;
import Pages.HomePage;
import Pages.ProfilePage;
import Utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    // comment or like a photo or video.
    @Test
    public void commentphoto() {
        String url=prop.getProperty("baseURL");
        driver.get(url);
        log.info("***** run the comment on the photo test");
        ProfilePage com = new ProfilePage();
        com.comment_photo();
    }

    @Test
    public void post_vid() {
        log.info("*****Run post video image test*****");
        String url=prop.getProperty("baseURL");
        driver.get(url);
        HomePage vid = new HomePage();
        vid.post_video();
    }
    @Test
    public void post_image() {
        log.info("*****Run post video image test*****");
        String url=prop.getProperty("baseURL");
        driver.get(url);
        HomePage vid = new HomePage();
        vid.post_photo();
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
