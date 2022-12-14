package test;

import Base.Base;
import Pages.LoginPage;
import Pages.MarketPlace;
import utility.Utility;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(utility.Listeners.class)
public class MarketPlaceTest extends Base {
    public MarketPlaceTest() {
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

    ///Market place test
    @Test
    public void MarketPlacePost() {
        log.info("*****Start the market place page test*****");
        LoginP = new LoginPage();
        LoginP.loginUser();
        MarketPlace market =new MarketPlace();
        market.marketPlace();
        String homePageTitle = LoginPage.verifyHomePage();
        assertEquals(homePageTitle, "(1) Facebook Marketplace | Facebook");

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
