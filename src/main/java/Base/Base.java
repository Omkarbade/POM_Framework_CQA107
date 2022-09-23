package Base;

import Pages.LoginPage;
import Utility.Utility;
import com.google.common.util.concurrent.Service;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.apache.log4j.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

//@Listeners(Listener.class)


public class Base {
    protected static WebElement element;
    public static WebDriver driver;
    protected static FileInputStream file;
    public static FileInputStream excelfile;
    public static Properties prop;
    public static Utility utility;
    protected static XSSFWorkbook xWorkbook;
    protected static XSSFSheet xsheet;
    protected static XSSFCell xCell;
    protected static XSSFRow xRow;
    protected static Object[][] data;


    public static LoginPage LoginP;
    protected static String message;
    final static String File_Path=System.getProperty("user.dir")+
            File.separator+"src"+
            File.separator+"main"+
            File.separator+"java"+
            File.separator+"resources"+
            File.separator+"repository"+
            File.separator+"LoginTestData.xlsx";

    static {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    public  Base(){
        try {
            prop = new Properties();
            file = new FileInputStream(".\\src\\main\\resources\\config.properties");
            prop.load(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void getScreenShots(String TestName) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("DD/MM/yyyy hh:mm:ss");
        String actualDate = formatter.format(date);
        TakesScreenshot screenshot = (TakesScreenshot)  driver;
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir") + "/Screenshot" + actualDate + ".png";
        File destFile = new File(destination);
        try {

            FileUtils.copyFile(srcFile, destFile);
        }catch( Exception e) {
            e.printStackTrace();
        }

    }

}
