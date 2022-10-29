package test;

import Base.Base;
import Pages.LoginPage;
import Pages.WatchVideo;
import org.testng.annotations.Listeners;
import utility.Utility;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
@Listeners(utility.Listeners.class)
public class WatchVideosTest extends Base {
    public WatchVideosTest() {
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
    ///Method : Watch the video
    @Test
    public void WatchPost() {
        log.info("*****Start the watch video page test*****");
        LoginP = new LoginPage();
        LoginP.loginUser();
        WatchVideo watch = new WatchVideo();
        WatchVideo.watchVideos();
        String homePageTitle = LoginPage.verifyHomePage();
        assertEquals(homePageTitle, "(1) Cricket videos on Facebook Watch | Facebook");
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
