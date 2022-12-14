package Base;

import Pages.LoginPage;
import utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;



public class Base {
    protected static WebElement element;
    public static WebDriver driver;
    protected static FileInputStream file;
    public static FileInputStream excelfile;
    public static Properties prop;
    public static Utility utility;



    public static LoginPage LoginP;
    public static String message;
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

    //create base constructor and set config properties path by using fileo.
    public  Base(){
        try {
            prop = new Properties();
            file = new FileInputStream(".\\src\\main\\resources\\config.properties");
            prop.load(file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
