package com.org.base;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class CommonUtil {

    private final String outputFilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\OutputData.xlsx";

    public void writeExcelDat(ArrayList arrayList) throws IOException {
        int indexNo;
        FileInputStream inputStream = new FileInputStream(new File(outputFilePath));
        XSSFWorkbook objWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet objSheet = objWorkbook.createSheet();

        for (int i = 0; i < arrayList.size()/3; i++) {
            Row row = objSheet.createRow(i);
            indexNo = 3 * i;
            for (int j = 0; j < 3; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue((String) arrayList.get(indexNo+j));
            }
        }
        inputStream.close();
        FileOutputStream fos = new FileOutputStream(new File(outputFilePath));
        objWorkbook.write(fos);
        fos.close();
        }
    }
