package utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Utility class for excel file.
public class ExcelUtil  {
    static XSSFWorkbook workBook;
    static XSSFSheet sheet ;


    //class constructor
    public ExcelUtil(String ExcelPath, String sheetName) {
        try {
            workBook = new XSSFWorkbook(ExcelPath);
            sheet = workBook.getSheet(sheetName);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getRowCount();
		getCellDataString(0,0);
       // getCellDataNumber(1,1);  //
    }

    //method : get row count 3
    public static int getRowCount() {
        int rowCount = 0;
        try {
            //call row count function.
            rowCount = sheet.getPhysicalNumberOfRows();
            System.out.println("No of Rows :" +rowCount);

        }catch(Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return rowCount;
    }

    /// method : get column count
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


}
