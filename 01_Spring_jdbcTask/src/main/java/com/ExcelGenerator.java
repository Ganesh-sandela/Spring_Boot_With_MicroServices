package com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenerator {

    public  void generateexcl(List<Book> bb) throws IOException {

        Workbook book = new XSSFWorkbook();
        Sheet sheet = book.createSheet("Books-Data");

        // Create header row
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("sl.no");
        header.createCell(1).setCellValue("bname");
        header.createCell(2).setCellValue("bprice");
        int dataindex=1;
        for(Book b:bb) {
        	Row datarow=sheet.createRow(dataindex);
        	datarow.createCell(0).setCellValue(b.getBid());
        	datarow.createCell(1).setCellValue(b.getBname());
        	datarow.createCell(2).setCellValue(b.getBprice());
        	
        	dataindex++;
        	
        }
        

        File file = new File("Books.xlsx");
        FileOutputStream fos = new FileOutputStream(file);

        book.write(fos);

        fos.close();
        book.close();

        System.out.println("Excel file created successfully!");
    }

  
   
}
