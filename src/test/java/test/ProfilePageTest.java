package test;

import Base.Base;
import Pages.ProfilePage;
import Utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ProfilePageTest extends Base {
    public static Logger log = LogManager.getLogger(Utility.class);
    public ProfilePageTest() {
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

    //upload photo on profile.
    @Test
    public void UploadProfilephoto() {
        log.info("********Run the Upload Profile Photo Test*******");
        String url=prop.getProperty("baseURL");
        driver.get(url);
        ProfilePage pro = new ProfilePage();
        pro.UploadProfilephoto();
    }
    //upload cover photo on user profile
    @Test
    public void Coverphoto() {
        log.info("******Run the Upload Cover Photo Test");
        String url=prop.getProperty("baseURL");
        driver.get(url);
        ProfilePage pro = new ProfilePage();
        pro.coverphoto();
    }
    @Test
    public void LikeBtn() {
        log.info("******Run the Like photo/video test*****");
        String url=prop.getProperty("baseURL");
        driver.get(url);
        ProfilePage like = new ProfilePage();
        like.Like_photo();
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
