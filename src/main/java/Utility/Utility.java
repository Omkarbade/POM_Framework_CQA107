package utility;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static Base.Base.*;


public class Utility {
    public static Logger log = LogManager.getLogger(Utility.class);
    ///initiaize the web driver.
    public static void initializeDriver(String browser) throws IOException {

        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
            log.info("******Chrome Driver initialized******");

        } else {
            driver = new FirefoxDriver();
            log.info("******FireFox Driver initialized******");

        }
        driver.manage().deleteAllCookies();
        log.info("******Cookies Deleted******");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get(prop.getProperty("baseURL"));
    }

//Method : set excel file path and read the data from excel file.
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


    // method: read the excel file
    public static List<List<String>> excelReader() throws IOException {
        List<List<String>> values = new LinkedList<List<String>>();
       try {

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

       }
       catch (IOException e) {
           e.printStackTrace();
       }
        return values;
    }

    //Method :implement takescreen shot
    public static void getScreenShots() throws IOException {
        Date date = new Date();

        //Print actual date
        String date1 = date.toString();
        System.out.println("Date is: "+date1);

        String date2 = date1.replaceAll(":", "_");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir")+"\\Screenshot\\"+date2+"failed.png") ;
        FileHandler.copy(srcFile,destFile);
        log.info("******Screenshot taken successfully******");
        try {

            FileUtils.copyFile(srcFile, destFile);
        }catch( Exception e) {
            e.printStackTrace();
        }

    }
    //Method: Random string genrate
    public static String RandomString() {
        String randomString = null;
        try {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            randomString = "";
            int length = 5;
            //crate random string object.
            Random rand = new Random();
            //character array ie each index has a value.bcz fill that array random characters
            char[] text = new char[length];
            //add individual int character
            for (int i = 0; i < length; i++) {
                //genrate random index numbers.
                text[i] = characters.charAt(rand.nextInt(characters.length()));
            }
            //text array adding each char one by one to randomstring util array is done
            for (int i = 0; i < text.length; i++) {
                randomString += text[i];
            }
            System.out.println("Random-" +randomString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return randomString;
    }
    ///Method : verify posted comment on photo .

    public static String verifycomment() {
        WebElement comm=driver.findElement(By.xpath("(//ul)[3]/li[last()]/div/div/div/div/div/div/div/div/div/span/div/div"));

        String comment=comm.getText();
        System.out.println(comment);
        return comment;
    }


    ///Method : verify Profile Cover image time.
    public static String Verify_profileCover(){
        WebElement web = driver.findElement(By.xpath("//span[contains(text(),'1 m')]"));
        int x = web.getLocation().getX();
        int y = web.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + ", " + y + ")");

        String PostTime = web.getText();

        System.out.println(PostTime);
        return PostTime;
    }

    ///Method : verify Profile Cover image time.
    public static String Verify_profileImage(){
        WebElement web = driver.findElement(By.xpath("(//span[contains(text(),'1 m')])[1]"));
        int x = web.getLocation().getX();
        int y = web.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + ", " + y + ")");

        String PostTime = web.getText();

        System.out.println(PostTime);
        return PostTime;
    }
    ///Method : verify Posted image time.
    public static String Verify_postImage(){

        WebElement web = driver.findElement(By.xpath("(//span[contains(text(),'1 m')])[1]"));
        int x = web.getLocation().getX();
        int y = web.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + ", " + y + ")");
        String PostTime = web.getText();
        System.out.println(PostTime);
        return PostTime;
    }

    ///Method : verify Posted video image time.
    public static String Verify_postvideo(){
        WebElement web = driver.findElement(By.xpath("(//span[contains(text(),'1 m')])[1]")); //(//span[@class='xi7du73 x1n2onr6 x17ihmo5 x1pvdv19'])[1]
        int x = web.getLocation().getX();
        int y = web.getLocation().getY();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + ", " + y + ")");

        String PostTime = web.getText();

        System.out.println(PostTime);
        return PostTime;
    }


    //create close driver method which close driver after test execute.
    public static void closeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
        log.info("******Browser closed******");
    }

}



