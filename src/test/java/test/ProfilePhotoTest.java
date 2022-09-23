package test;

import Base.Base;
import Pages.ProfilePhoto;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfilePhotoTest extends Base {

        public ProfilePhotoTest() {
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
            public void UploadProfilephoto() {
                String url=prop.getProperty("baseURL");
                driver.get(url);
            ProfilePhoto pro = new ProfilePhoto();
            pro.UploadProfilephoto();
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


