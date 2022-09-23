package Utility;

import Base.Base;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static Base.Base.*;

public class Utility {
    public static Logger log = LogManager.getLogger(Utility.class);
    public static void initializeDriver(String browser) throws IOException {

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            driver.get(prop.getProperty("baseURL"));
        } else {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            driver.get(prop.getProperty("baseURL"));
        }
    }

    public static Object[][] getLoginData() {
        XSSFWorkbook xWorkbook = null;
        try {
            excelfile = new FileInputStream("C:\\Users\\OMKAR BADE\\IdeaProjects\\POM_Framework\\src\\main\\resources\\repository\\LoginTestData.xlsx");
            xWorkbook = new XSSFWorkbook(excelfile);


        } catch (Exception e) {
            e.printStackTrace();
        }
        XSSFSheet xSheet = xWorkbook.getSheet("LoginTestData");
        int lastRow = xSheet.getLastRowNum();
        Object[][] data = new Object[lastRow][2];
        int k = 0;
        for (int i = 0; i <= lastRow; i++) {
            String username = xSheet.getRow(i + 1).getCell(k).getStringCellValue();
            String password = xSheet.getRow(i + 1).getCell(k + 1).getStringCellValue();
            System.out.println("Row" + i + "Username:" + username);
            System.out.println("Row" + i + "Passsword:" + password);
            data[i][0] = username;
            data[i][1] = password;


        }
        return data;

    }

    public static List<List<String>> excelReader() throws IOException {
        List<List<String>> values = new LinkedList<List<String>>();
        File file = new File(System.getProperty("user.dir") + ".\\src\\main\\resources\\repository\\LoginTestData.xlsx");
        FileInputStream fis = new FileInputStream(file);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheet("LoginTestData");

        int rowCount = sheet.getLastRowNum();

        for (int i = 1; i <= rowCount; i++) {
            int cellCount = sheet.getRow(i).getLastCellNum();
            List<String> val = new LinkedList<String>();
            for (int j = 0; j < cellCount; j++) {
                val.add(sheet.getRow(i).getCell(j).getStringCellValue());

            }
            values.add(val);


        }
        return values;

    }

    public static void closeDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
}



