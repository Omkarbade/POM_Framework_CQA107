package test;

import Base.Base;
import Pages.LoginPage;
import Pages.ProfilePage;
import net.bytebuddy.utility.RandomString;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(utility.Listeners.class)
public final class ProfilePageTest extends Base {
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
    @Test(priority = 1)
    public void UploadProfilephoto() {
        log.info("********Run the Upload Profile Photo Test*******");
        LoginP = new LoginPage();
        LoginP.loginUser();
        ProfilePage pro = new ProfilePage();
        pro.UploadProfilephoto();
        String PostTime =  Utility.Verify_profileImage();
        assertEquals(PostTime, "1 m");
    }
    //upload cover photo on user profile
    @Test(priority = 2)
     public void Coverphoto() {
        log.info("******Run the Upload Cover Photo Test");
        LoginP = new LoginPage();
        LoginP.loginUser();
        ProfilePage pro = new ProfilePage();
        pro.coverphoto();
        String PostTime =  Utility.Verify_profileCover();
        assertEquals(PostTime, "1 m");
    }

    ///comment on photo or video test.
    @Test(priority = 3)
    public void comment() {
        log.info("******Run the comment on  photo/video test*****");
        LoginP = new LoginPage();
        LoginP.loginUser();
        ProfilePage comm = new ProfilePage();
        comm.comment_photo();

    }

    //Like the video or photo.

    @Test(priority = 4)
    public void LikeBtn() {
        log.info("******Run the Like photo/video test*****");
        LoginP = new LoginPage();
        LoginP.loginUser();

        ProfilePage like = new ProfilePage();
        like.Like_photo();
        String homePageTitle = LoginPage.verifyHomePage();
        assertEquals(homePageTitle, "Facebook");
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
