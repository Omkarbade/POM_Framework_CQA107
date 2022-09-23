package test;

import Base.Base;
import Pages.CoverPhoto;
import Pages.ProfilePhoto;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Base.Base.*;

public class CoverPhotoTest extends Base {
    public CoverPhotoTest() {
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
    public void upcoverphoto() {
        String url=prop.getProperty("baseURL");
        driver.get(url);
        CoverPhoto pro = new CoverPhoto();
        pro.coverphoto();
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