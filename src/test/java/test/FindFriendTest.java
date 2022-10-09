package test;

import Base.Base;
import Pages.FindFriendPage;
import Pages.MarketPlace;
import Utility.Utility;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

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

        FindFriendPage friend =new FindFriendPage();
        friend.FindFriend();
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
