package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtility {


    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int sutunSayisi){
        ArrayList<ArrayList<String>> tablo=new ArrayList<>();

        Sheet sheet=null;
        try {
            FileInputStream inputStream=new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet=workbook.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());;
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {  //her bir satırı

            ArrayList<String> satir=new ArrayList<>();
            for (int j = 0; j < sutunSayisi; j++) {  // sutun sayısı kadar dolas
                satir.add(sheet.getRow(i).getCell(j).toString());
            }

            tablo.add(satir);
        }

        return tablo;
    }

    public static void writeToExcel(String path, ArrayList<String> list, int listSize,String listName) {

        File file = new File(path);

        if (!file.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet(listName);

            Row newRow = sheet.createRow(0);
            Cell cell = newRow.createCell(1);
            cell.setCellValue(listName);
            for (int i = 0; i < listSize; i++) {
                newRow = sheet.createRow(i+1);
                Cell cell1 = newRow.createCell(0);
                cell1.setCellValue(i+1);
                Cell cell2 = newRow.createCell(1);
                cell2.setCellValue(list.get(i));
            }


            try {
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }
        } else {

            FileInputStream inputStream=null;
            Workbook workbook=null;
            Sheet sheet=null;

            try {
                inputStream = new FileInputStream(path);
                workbook = WorkbookFactory.create(inputStream);
                sheet = workbook.getSheetAt(0);
            } catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }

            int lastRowIndex = sheet.getPhysicalNumberOfRows();
            Row newRow = sheet.createRow(lastRowIndex+2);
            Cell cell = newRow.createCell(1);
            cell.setCellValue(listName);

            for (int i = 0; i < listSize; i++) {
                newRow = sheet.createRow(lastRowIndex+3+i);
                Cell cell1 = newRow.createCell(0);
                cell1.setCellValue(i+1);
                Cell cell2 = newRow.createCell(1);
                cell2.setCellValue(list.get(i));
            }


            try {
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
            } catch (Exception ex) {
                System.out.println("ex.getMessage() = " + ex.getMessage());
            }
        }

    }


}
