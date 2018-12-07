package util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelUtil {

    private static FileInputStream fis;
    private static final String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\TestData.xlsx";

    public static Object[][] getData() throws Exception {
        String[][] dataArray;
        try {
            fis = new FileInputStream(filePath);
        } catch(FileNotFoundException e) {
            System.out.println("Coulnd not read excel file"); }

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Data");
            int rowNum = sheet.getLastRowNum();
            int colNum = sheet.getRow(0).getLastCellNum();

            dataArray = new String[rowNum][colNum];
            for(int i=0;i<rowNum;i++) {
                XSSFRow row = sheet.getRow(i + 1);
                for(int j =0;j<colNum;j++) {
                    XSSFCell cell = row.getCell(j);
                    System.out.println(cell.getStringCellValue());
                    dataArray[i][j] = cell.getStringCellValue();
                }
            }
            return dataArray;
        }
    }


