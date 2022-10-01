package test;

import Base.Base;
import Pages.Comment;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class CommentTest extends Base {
    public CommentTest() {
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
        Comment com = new Comment();
        com.commentphoto();
    }

    //close driver
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
