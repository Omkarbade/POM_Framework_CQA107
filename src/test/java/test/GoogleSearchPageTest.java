package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPageObjects;

public class GoogleSearchPageTest {

   private static WebDriver driver = null;

    public static void main(String[] args) {
        googleSearchTest();
    }
    public static void googleSearchTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();

        GoogleSearchPageObjects searchPageObj = new GoogleSearchPageObjects();
        driver.get("https://google.com");
        searchPageObj.setTextInSearchBox("A B C D");
        searchPageObj.clickSearchButton();
        driver.close();
    }
}
