package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GoogleSearchPage;

import java.awt.event.KeyEvent;
import java.security.Key;

public class GoogleSearchTest {

    private static WebDriver driver = null;
    public static void main(String[] args) {
        googlesearch();
    }
    public static void googlesearch(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://www.google.com/");
      //  driver.findElement(By.name("q")).sendKeys("Selenium");
        GoogleSearchPage.textbox_search(driver).sendKeys("Selenium");

        //driver.findElement(By.name("btnk")).click();
        GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);
        driver.close();
        System.out.println("Test pass successfully");
    }
}
