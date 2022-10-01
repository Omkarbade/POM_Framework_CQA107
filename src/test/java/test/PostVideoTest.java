package test;

import Base.Base;
import Pages.PostVideo;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Base.Base.*;

public class PostVideoTest extends Base {
    public PostVideoTest() {
        super();
    }


    // initialize browser method
    @SuppressWarnings("static-access")
    @BeforeMethod
    public void triggerDriver(){
        try {
            utility.initializeDriver(prop.getProperty("browser"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // post the video/image.
    @Test
    public void post() {
        String url=prop.getProperty("baseURL");
        driver.get(url);
        PostVideo vid = new PostVideo();
        vid.postvideo_photo();
    }

    //close browser method.
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
