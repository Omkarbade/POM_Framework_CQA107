package Utility;

import Base.Base;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtil  {
    static XSSFWorkbook workBook;
    static XSSFSheet sheet ;


    public ExcelUtil(String ExcelPath, String sheetName) {
        try {
            workBook = new XSSFWorkbook(ExcelPath);
            sheet = workBook.getSheet(sheetName);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getRowCount();  //3
		getCellDataString(0,0);  //Username
       // getCellDataNumber(1,1);  //
    }

    public static int getRowCount() {
        int rowCount = 0;
        try {
            //call row count function.
            rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("No of Rows :" +rowCount); //2

        }catch(Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return rowCount;
    }

    public static int getColumnCount() {
        int colCount=0;
        try {
            //call column count function.
            colCount =sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println("No of Columns :" +colCount);

        }catch(Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return colCount;
    }

    //get cell data

    public static String getCellDataString(int rowNum, int colNum) {
        String cellData = null;
        try {
            //call function to get cell data.
            cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
            System.out.println(cellData);
        }catch(Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return cellData;
    }


//    public static void getCellDataNumber(int rowNum, int colNum) {
//        try {
//            //call function to get cell data.
//            double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
//            System.out.println(cellData);
//        }catch(Exception exp) {
//            System.out.println(exp.getMessage());
//            System.out.println(exp.getCause());
//            exp.printStackTrace();
//        }
//    }

}
