package com.resumelibrary.utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.util.IOUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.awt.Color;
import java.io.*;
import java.util.Iterator;

public class ExcelUtil {
    private static final Logger logger = LogManager.getLogger(ExcelUtil.class);
    int insertImageCount = 0;
    String fileType = ".xlsx";

    public synchronized void createFailedExcel(String buildId) {
        logger.info("[--->in createFailedExcel<----]");

        try {
            String filename = "FailedScenarios_" + buildId + fileType;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("RLRegression");
            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("S.No");
            rowhead.createCell(1).setCellValue("Build No");
            rowhead.createCell(2).setCellValue("Vertical");
            rowhead.createCell(3).setCellValue("Scenario");
            rowhead.createCell(4).setCellValue("Tags");
            rowhead.createCell(5).setCellValue("Failed Step");
            rowhead.createCell(6).setCellValue("Skip Test");
            rowhead.createCell(7).setCellValue("Failed Reason");
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            logger.info("[--->Created excel file successfully for the build:" + buildId + "<----]");
        } catch (Exception e) {
            logger.info("[--->Failed to Created excel file for the build:" + buildId + "<----]");
            e.printStackTrace();
        }
    }

    public synchronized void addRowsFailedExcel(FailedScenarioPojo failedScenario, String skipTest) {
        logger.info("[--->in addRowsFailedExcel<---]");
        try {

                String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaStackBuildId");
                String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
                FileInputStream myxls = new FileInputStream("FailedScenarios_" + buildId + fileType);
                HSSFWorkbook studentsSheet = new HSSFWorkbook(myxls);
                HSSFSheet worksheet = studentsSheet.getSheet("RLRegression");

                int lastRow = worksheet.getLastRowNum();
                Row row = worksheet.createRow(++lastRow);
                row.createCell(0).setCellValue(lastRow);
                row.createCell(1).setCellValue(buildId);
                row.createCell(2).setCellValue(getVerticalName(failedScenario.getTagDetails()));
                row.createCell(3).setCellValue(failedScenario.getScenarioName());
                row.createCell(4).setCellValue(failedScenario.getTagDetails());
                row.createCell(5).setCellValue(failedScenario.getStepDescription());
                row.createCell(6).setCellValue(skipTest);
                row.createCell(7).setCellValue(failedScenario.getFailedReason());

                myxls.close();
                FileOutputStream output_file = new FileOutputStream("FailedScenarios_" + buildId + ".xlsx");
                studentsSheet.write(output_file);
                output_file.close();
                logger.info("[--->written into excel file successfully for the failed scenario:" + failedScenario.getScenarioName() + "<-----]");

        } catch (Exception e) {
            logger.info("[--->failed to write into excel file for the failed scenario:" + failedScenario.getScenarioName() + "<-------]");
            e.printStackTrace();
        }
    }

    public synchronized void addRowsFailedExcelWithRetry(FailedScenarioPojo failedScenario) {
        logger.info("[--->in addRowsFailedExcelWithRetry<----]");
        try {
            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaStackBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            FileInputStream myxls = new FileInputStream("FailedScenarios_" + buildId + fileType);

            HSSFWorkbook rlRgressionheet = new HSSFWorkbook(myxls);
            HSSFSheet worksheet = rlRgressionheet.getSheet("RLRegression");

            int lastRow = worksheet.getLastRowNum();
            Row row = worksheet.createRow(++lastRow);
            row.createCell(0).setCellValue(lastRow);
            row.createCell(1).setCellValue(buildId);
            row.createCell(2).setCellValue(getVerticalName(failedScenario.getTagDetails()));
            row.createCell(3).setCellValue(failedScenario.getScenarioName());
            row.createCell(4).setCellValue(failedScenario.getTagDetails());
            row.createCell(5).setCellValue(failedScenario.getStepDescription());
            row.createCell(6).setCellValue(failedScenario.getFailedReason());
            row.createCell(7).setCellValue(failedScenario.getFailedReason());
            myxls.close();
            FileOutputStream output_file = new FileOutputStream("FailedScenarios_" + buildId + ".xlsx");

            rlRgressionheet.write(output_file);

            output_file.close();
            logger.info(" --->written into excel file successfully for the failed scenario:" + failedScenario.getScenarioName());
        } catch (Exception e) {
            logger.info("--->failed to write into excel file for the failed scenario:" + failedScenario.getScenarioName());
            e.printStackTrace();
        }
    }

    public boolean checkScenarioExist(String scenarioName) throws IOException {
        logger.info("[--->in checkScenarioExist<----]");
        boolean existScenario = false;
        String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaStackBuildId");
        String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
        FileInputStream myxls = new FileInputStream("FailedScenarios_" + buildId + fileType);

        HSSFWorkbook rlRgressionheet = new HSSFWorkbook(myxls);
        HSSFSheet worksheet = rlRgressionheet.getSheet("RLRegression");

        Iterator<Row> rows = worksheet.rowIterator();
        while (rows.hasNext()) {
            HSSFRow row = (HSSFRow) rows.next();
            Iterator<Cell> cells = row.cellIterator();
            while (cells.hasNext()) {
                HSSFCell cell = (HSSFCell) cells.next();
                if (cell.toString().equalsIgnoreCase(scenarioName)) {
                    existScenario = true;
                    break;
                }
            }
        }
        return existScenario;
    }

    public synchronized void removePassedScenario(String scenarioName) {
        logger.info("[--->in removePassedScenario<----]");
        try {
            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaStackBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            FileInputStream myxls = new FileInputStream("FailedScenarios_" + buildId + fileType);
            HSSFWorkbook rlRgressionheet = new HSSFWorkbook(myxls);
            HSSFSheet worksheet = rlRgressionheet.getSheet("RLRegression");
            Iterator<Row> rows = worksheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator<Cell> cells = row.cellIterator();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    if (cell.getStringCellValue().contains(scenarioName)) {
                        worksheet.removeRow(row);
                        break;
                    }

                }
            }
        } catch (Exception e) {
            logger.info("[--->failed to remove from excel file for the passed scenario:" + scenarioName + "<---]");
            e.printStackTrace();
        }
    }

    public String getVerticalName(String tags) {
        logger.info("[--->in getVerticalName<---]");
        if (tags.contains("@Search")) {
            return "Search";
        } else if (tags.contains("@Partnerships")) {
            return "Partnerships";
        } else if (tags.contains("@Traffic")) {
            return "Traffic";
        } else if (tags.contains("@Candidate")) {
            return "Candidate";
        } else if (tags.contains("@Recruiters")) {
            return "Recruiters";
        } else {
            return "Not matching with any vertical";
        }
    }

    private void insertImageToCell(Workbook workbook, String fileType, int rowNum, Drawing drawing,
                                   byte[] inputImageBytes) throws IOException {
        if (insertImageCount <= 20) {
            //Loading image from application resource
            //InputStream is = ExcelUtil.class.getClassLoader().getResourceAsStream(imageName);

            //Converting input stream into byte array
            //   byte[] inputImageBytes = IOUtils.toByteArray(is);
            int inputImagePictureID = workbook.addPicture(inputImageBytes, Workbook.PICTURE_TYPE_PNG);


            ClientAnchor anchor = null;
            //Creating the client anchor based on file format
            // if (fileType.equals("xls")) {
            anchor = new HSSFClientAnchor();
            // } else {
            //    anchor = new XSSFClientAnchor();
            //}
            anchor.setCol1(0);
            anchor.setRow1(0);
            Picture pict = drawing.createPicture(anchor, inputImagePictureID);

            pict.resize();
        } else {

            logger.info("[--->Failure count more than 20 Skipped to add image in excel sheet <---]");
        }
        insertImageCount++;
    }

    public synchronized void createSummarySheet(VerticalScenarioCountPojo verticalScenarioCountPojo) {
        logger.info("[--->in addRowsFailedExcel<---]");
        final String series1 = "Test Passed";
        final String series2 = "Test Failed";

        try {
            Cell cell=null;
            DefaultCategoryDataset my_pie_chart_data = new DefaultCategoryDataset();
            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaStackBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            HSSFWorkbook rlRegressionSheet = new HSSFWorkbook();
            HSSFSheet rlExecutionSummarySheet = rlRegressionSheet.createSheet("RLExecutionSummary");
            rlRegressionSheet.setSheetOrder("RLExecutionSummary", 0);
            HSSFRow rowhead = rlExecutionSummarySheet.createRow((short) 0);

            cell= rowhead.createCell(0);
            cell.setCellValue("S.No");
            changeCellBackgroundColor(cell,rlRegressionSheet,"header","bold");
            cell=rowhead.createCell(1);
            cell.setCellValue("Vertical Name");
            changeCellBackgroundColor(cell,rlRegressionSheet,"header","bold");
            cell=rowhead.createCell(2);
            cell.setCellValue("Passed");
            changeCellBackgroundColor(cell,rlRegressionSheet,"header","bold");
            cell=rowhead.createCell(3);
            cell.setCellValue("Failed");
            changeCellBackgroundColor(cell,rlRegressionSheet,"header","bold");
            cell=rowhead.createCell(4);
            cell.setCellValue("Total");
            changeCellBackgroundColor(cell,rlRegressionSheet,"header","bold");
            cell=rowhead.createCell(5);
            cell.setCellValue("Pass Percentage %");
            changeCellBackgroundColor(cell,rlRegressionSheet,"header","bold");
           int lastRow = rlExecutionSummarySheet.getLastRowNum();
            Row row = rlExecutionSummarySheet.createRow(++lastRow);

            cell= row.createCell(0);
            cell.setCellValue(lastRow);
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            cell= row.createCell(1);
            cell.setCellValue("Candidate");
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            cell= row.createCell(2);
            cell.setCellValue(verticalScenarioCountPojo.getPassedCandidateCount());
            changeCellBackgroundColor(cell,rlRegressionSheet,"green","bold");
            cell= row.createCell(3);
            cell.setCellValue(verticalScenarioCountPojo.getFailedCandidateCount());
            changeCellBackgroundColor(cell,rlRegressionSheet,"red","bold");
            double totalCandidate = verticalScenarioCountPojo.getPassedCandidateCount() + verticalScenarioCountPojo.getFailedCandidateCount();
            my_pie_chart_data.setValue(verticalScenarioCountPojo.getPassedCandidateCount(), series1, "Candidate Passed");
            my_pie_chart_data.setValue(verticalScenarioCountPojo.getFailedCandidateCount(), series2, "Candidate Failed");
            double passCandidate = verticalScenarioCountPojo.getPassedCandidateCount() / totalCandidate;
            double passPercentageCandidate = passCandidate * 100;
            cell= row.createCell(4);
            cell.setCellValue(totalCandidate);
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            cell= row.createCell(5);
            cell.setCellValue(passPercentageCandidate);
            changeCellBackgroundColor(cell,rlRegressionSheet,"green","bold");
            lastRow = rlExecutionSummarySheet.getLastRowNum();
            row = rlExecutionSummarySheet.createRow(++lastRow);


            cell= row.createCell(0);
            cell.setCellValue(lastRow);
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            cell= row.createCell(1);
            cell.setCellValue("Recruiters");
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            cell= row.createCell(2);
            cell.setCellValue(verticalScenarioCountPojo.getPassedRecruitersCount());
            changeCellBackgroundColor(cell,rlRegressionSheet,"green","bold");
            cell= row.createCell(3);
            cell.setCellValue(verticalScenarioCountPojo.getFailedRecruitersCount());
            changeCellBackgroundColor(cell,rlRegressionSheet,"red","bold");
            double totalRecruiters = verticalScenarioCountPojo.getPassedRecruitersCount() + verticalScenarioCountPojo.getFailedRecruitersCount();
            my_pie_chart_data.setValue(verticalScenarioCountPojo.getPassedRecruitersCount(), series1, "Recruiters Passed");
            my_pie_chart_data.setValue(verticalScenarioCountPojo.getFailedRecruitersCount(), series2, "Recruiters Failed");
            double passRecruiters = verticalScenarioCountPojo.getPassedRecruitersCount() / totalRecruiters;
            double passPercentageRecruiters = passRecruiters * 100;
            cell= row.createCell(4);
            cell.setCellValue(totalRecruiters);
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            cell= row.createCell(5);
            cell.setCellValue(passPercentageRecruiters);
            changeCellBackgroundColor(cell,rlRegressionSheet,"green","bold");
            lastRow = rlExecutionSummarySheet.getLastRowNum();
            row = rlExecutionSummarySheet.createRow(++lastRow);


            cell= row.createCell(0);
            cell.setCellValue(lastRow);
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            cell= row.createCell(1);
            cell.setCellValue("Search");
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            cell= row.createCell(2);
            cell.setCellValue(verticalScenarioCountPojo.getPassedSearchCount());
            changeCellBackgroundColor(cell,rlRegressionSheet,"green","bold");
            cell= row.createCell(3);
            cell.setCellValue(verticalScenarioCountPojo.getFailedSearchCount());
            changeCellBackgroundColor(cell,rlRegressionSheet,"red","bold");
            double totalSearch = verticalScenarioCountPojo.getPassedSearchCount() + verticalScenarioCountPojo.getFailedSearchCount();
            my_pie_chart_data.setValue(verticalScenarioCountPojo.getPassedSearchCount(), series1, "Search Passed");
            my_pie_chart_data.setValue(verticalScenarioCountPojo.getFailedSearchCount(), series2, "Search Failed");
            double passSearch = verticalScenarioCountPojo.getPassedSearchCount() / totalSearch;
            double passPercentageSearch = passSearch * 100;
            cell= row.createCell(4);
            cell.setCellValue(totalSearch);
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            cell= row.createCell(5);
            cell.setCellValue(passPercentageSearch);
            changeCellBackgroundColor(cell,rlRegressionSheet,"green","bold");
            lastRow = rlExecutionSummarySheet.getLastRowNum();
            row = rlExecutionSummarySheet.createRow(++lastRow);


            cell= row.createCell(0);
            cell.setCellValue(lastRow);
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            cell= row.createCell(1);
            cell.setCellValue("Traffic");
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            cell= row.createCell(2);
            cell.setCellValue(verticalScenarioCountPojo.getPassedTrafficCount());
            changeCellBackgroundColor(cell,rlRegressionSheet,"green","bold");
            cell= row.createCell(3);
            cell.setCellValue(verticalScenarioCountPojo.getFailedTrafficCount());
            changeCellBackgroundColor(cell,rlRegressionSheet,"red","bold");
            double totalTraffic = verticalScenarioCountPojo.getPassedTrafficCount() + verticalScenarioCountPojo.getFailedTrafficCount();
            my_pie_chart_data.setValue(verticalScenarioCountPojo.getPassedTrafficCount(), series1, "Traffic Passed");
            my_pie_chart_data.setValue(verticalScenarioCountPojo.getFailedTrafficCount(), series2, "Traffic Failed");
            double passTraffic = verticalScenarioCountPojo.getPassedTrafficCount() / totalTraffic;
            double passPercentageTraffic = passTraffic * 100;
            cell= row.createCell(4);
            cell.setCellValue(totalTraffic);
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            cell= row.createCell(5);
            cell.setCellValue(passPercentageTraffic);
            changeCellBackgroundColor(cell,rlRegressionSheet,"green","bold");
           lastRow = rlExecutionSummarySheet.getLastRowNum();
            row = rlExecutionSummarySheet.createRow(++lastRow);


            cell= row.createCell(0);
            cell.setCellValue(lastRow);
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            cell= row.createCell(1);
            cell.setCellValue("Partnerships");
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
             cell= row.createCell(2);
            cell.setCellValue(verticalScenarioCountPojo.getPassedPartnershipsCount());
            changeCellBackgroundColor(cell,rlRegressionSheet,"green","bold");
            cell= row.createCell(3);
            cell.setCellValue(verticalScenarioCountPojo.getFailedPartnershipsCount());
            changeCellBackgroundColor(cell,rlRegressionSheet,"red","bold");
            double totalPartnerships = verticalScenarioCountPojo.getPassedPartnershipsCount() + verticalScenarioCountPojo.getFailedPartnershipsCount();
            my_pie_chart_data.setValue(verticalScenarioCountPojo.getPassedPartnershipsCount(), series1, "Partnerships Passed");
            my_pie_chart_data.setValue(verticalScenarioCountPojo.getFailedPartnershipsCount(), series2, "Partnerships Failed");
            double passPartnerships = verticalScenarioCountPojo.getPassedPartnershipsCount() / totalPartnerships;
            double passPercentagePartnerships = passPartnerships * 100;
            cell= row.createCell(4);
            cell.setCellValue(totalPartnerships);
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            cell= row.createCell(5);
            cell.setCellValue(passPercentagePartnerships);
            changeCellBackgroundColor(cell,rlRegressionSheet,"green","bold");
            lastRow = rlExecutionSummarySheet.getLastRowNum();
            row = rlExecutionSummarySheet.createRow(++lastRow);


             cell= row.createCell(0);
            cell.setCellValue("Total");
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
            int totalPassed = verticalScenarioCountPojo.getPassedPartnershipsCount() + verticalScenarioCountPojo.getPassedTrafficCount() + verticalScenarioCountPojo.getPassedSearchCount() + verticalScenarioCountPojo.getPassedRecruitersCount() + verticalScenarioCountPojo.getPassedCandidateCount();
            int totalFailed = verticalScenarioCountPojo.getFailedPartnershipsCount() + verticalScenarioCountPojo.getFailedTrafficCount() + verticalScenarioCountPojo.getFailedSearchCount() + verticalScenarioCountPojo.getFailedRecruitersCount() + verticalScenarioCountPojo.getFailedCandidateCount();
            int totalExecutionCount = (int) (totalPartnerships + totalCandidate + totalRecruiters + totalSearch + totalTraffic);
            double totalPassPercentage = (passPercentageCandidate + passPercentageRecruiters + passPercentageSearch + passPercentageTraffic + passPercentagePartnerships) /5;
            cell= row.createCell(2);
            cell.setCellValue(totalPassed);
            changeCellBackgroundColor(cell,rlRegressionSheet,"green","bold");
            cell= row.createCell(3);
            cell.setCellValue(totalFailed);
            changeCellBackgroundColor(cell,rlRegressionSheet,"red","bold");
            cell= row.createCell(4);
            cell.setCellValue(totalExecutionCount);
            changeCellBackgroundColor(cell,rlRegressionSheet,"data","bold");
           cell= row.createCell(5);
            cell.setCellValue(totalPassPercentage);
            changeCellBackgroundColor(cell,rlRegressionSheet,"green","bold");

            /* Create a logical chart object with the chart data collected */
            JFreeChart myPieChart = ChartFactory.createBarChart("RL Execution", "Vertical Name", "Execution Count", my_pie_chart_data, PlotOrientation.HORIZONTAL, true, true, false);
            myPieChart.setBackgroundPaint(Color.white);
            final CategoryPlot plot = myPieChart.getCategoryPlot();
            plot.setBackgroundPaint(Color.lightGray);
            plot.setDomainGridlinePaint(Color.white);
            plot.setRangeGridlinePaint(Color.white);
            final BarRenderer renderer = (BarRenderer) plot.getRenderer();
            renderer.setDrawBarOutline(false);

            final GradientPaint gp0 = new GradientPaint(
                    0.0f, 0.0f, Color.green,
                    0.0f, 0.0f, Color.lightGray
            );
            final GradientPaint gp1 = new GradientPaint(
                    0.0f, 0.0f, Color.red,
                    0.0f, 0.0f, Color.lightGray
            );

            renderer.setSeriesPaint(0, gp0);
            renderer.setSeriesPaint(1, gp1);

            /* Specify the height and width of the Pie Chart */
            int width = 640; /* Width of the chart */
            int height = 480; /* Height of the chart */
            float quality = 1; /* Quality factor */
                /* We don't want to create an intermediate file. So, we create a byte array output stream
                and byte array input stream
                And we pass the chart data directly to input stream through this */
            /* Write chart as JPG to Output Stream */
            ByteArrayOutputStream chart_out = new ByteArrayOutputStream();
            ChartUtilities.writeChartAsJPEG(chart_out, quality, myPieChart, width, height);
            /* We now read from the output stream and frame the input chart data */
            InputStream feed_chart_to_excel = new ByteArrayInputStream(chart_out.toByteArray());
            byte[] bytes = IOUtils.toByteArray(feed_chart_to_excel);
            /* Add picture to workbook */
            int my_picture_id = rlRegressionSheet.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            /* We can close Piped Input Stream. We don't need this */
            feed_chart_to_excel.close();
            /* Close PipedOutputStream also */
            chart_out.close();
            /* Create the drawing container */
            HSSFPatriarch drawing = rlExecutionSummarySheet.createDrawingPatriarch();
            /* Create an anchor point */
            ClientAnchor my_anchor = new HSSFClientAnchor();
            /* Define top left corner, and we can resize picture suitable from there */
            my_anchor.setCol1(8);
            my_anchor.setRow1(5);
            /* Invoke createPicture and pass the anchor point and ID */
            HSSFPicture my_picture = drawing.createPicture(my_anchor, my_picture_id);
            /* Call resize method, which resizes the image */
            my_picture.resize();
            /* Close the FileInputStream */

            FileOutputStream output_file = new FileOutputStream("ExecutionSummary_" + buildId + fileType);
            rlRegressionSheet.write(output_file);
            output_file.close();
            logger.info("[--->written execution summary in to excel file successfully<-----]");
        } catch (Exception e) {
            logger.info("[--->failed written execution summary in to excel file: " + e.getMessage() + "<-----]");
            e.printStackTrace();
        }
    }
    public void changeCellBackgroundColor(Cell cell, HSSFWorkbook my_workbook,String color,String bold) {
        HSSFCellStyle my_style = my_workbook.createCellStyle();
        my_style.setBorderBottom(BorderStyle.THIN);
        my_style.setBorderLeft(BorderStyle.THIN);
        my_style.setBorderRight(BorderStyle.THIN);
        my_style.setBorderTop(BorderStyle.THIN);
        my_style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        HSSFFont my_font = my_workbook.createFont();
        if(bold.equalsIgnoreCase("bold")) {
            my_font.setBold(true);
            my_font.setFontHeight((short)190);
        }
        if (color.equalsIgnoreCase("red")) {
            my_style.setFillForegroundColor(IndexedColors.RED.getIndex());
             my_font.setColor(IndexedColors.WHITE.getIndex());
        }else if(color.equalsIgnoreCase("header")){
             my_style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
              my_font.setColor(IndexedColors.DARK_BLUE.index);
        }else if(color.equalsIgnoreCase("green")){
            my_style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
             my_font.setColor(IndexedColors.DARK_BLUE.index);
        }else if(color.equalsIgnoreCase("data")){
            my_style.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
            //my_font.setColor(IndexedColors.WHITE.index);
       }
             my_style.setFont(my_font);
              cell.setCellStyle(my_style);
    }


}