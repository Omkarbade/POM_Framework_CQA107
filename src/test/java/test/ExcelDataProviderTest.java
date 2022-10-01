package test;

import Base.Base;
import Utility.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import static Base.Base.driver;

public class ExcelDataProviderTest extends Base {

    //initialize driver
@BeforeMethod
public void triggerDriver(){
    try {
        utility.initializeDriver(prop.getProperty("browser"));
    }catch (Exception e){
        e.printStackTrace();
    }
}

    @Test(dataProvider = "testData")
    public void test1(String username, String password) throws Exception {

        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath( "//input[@id='email']")).sendKeys(username);
        driver.findElement(By.name("pass")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.name("login")).click();

    }

    @DataProvider(name = "testData")
    public  Object[][] getData() {
        String excelPath = ".\\src\\main\\resources\\repository\\LoginTestData.xlsx";
        Object data[][] = testData(excelPath, "LoginTestData");
        return data;
    }
///get the data from excel sheet.
    public Object[][] testData(String excelPath, String sheetName) {
        ExcelUtil excel = new ExcelUtil(excelPath, sheetName);

        int rowCount = excel.getRowCount();
        int colCount = excel.getColumnCount();

        Object data[][] = new Object[rowCount-1][colCount];

        for(int i=1; i< rowCount; i++) {
            for(int j=0; j<colCount; j++) {

                String cellData = excel.getCellDataString(i, j);
                //System.out.println(cellData + " " );
                data[i-1][j] = cellData;
            }
            System.out.println();
        }
        return data;
    }

    // close driver
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
