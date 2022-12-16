package com.resumelibrary.utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.util.*;

public class ReadExcelData {
    private static final Logger logger = LogManager.getLogger(ReadExcelData.class);

    public List getTagNamesFromExcel() {
        logger.info("==== in getTagNamesFromExcel method ==== ");
        List tagNames = new ArrayList<String>();
        try {
            File file = new File("Scenarios2.xlsx");
            FileInputStream inputStream = new FileInputStream(file);
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet("Sheet4");
            int rowCount = sheet.getLastRowNum();
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(0);
                Map<String, String> rowData = new HashMap<>();
                for (int j = 0; j < 1; j++) {
                    String key = row.getCell(0).getStringCellValue();
                    String value = sheet.getRow(i).getCell(0).getStringCellValue();
                    tagNames.add(value);
                }
            }
            logger.info("==== tagNames from excel sheet ==== " + tagNames);
        } catch (Exception e) {
            logger.info("==== error while reading data from excel sheet ==== " + e.getMessage());
        }
        return tagNames;
    }
}