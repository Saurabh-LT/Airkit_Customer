package com.resumelibrary.utilities;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.List;

public class WebDocUtil {
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(WebDocUtil.class);
    String GREEN_BACKGROUND = "\033[42m";
    String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    String RED_BOLD_BRIGHT = "\033[1;91m";
    String ANSI_RESET = "\u001B[0m";
    String GREEN_BOLD_BRIGHT = "\033[1;92m";
    String WHITE_BOLD_BRIGHT = "\033[1;97m";
    int failureDocs = 0;

    public static void main(String ar[]) throws IOException {

        XWPFDocument document = new XWPFDocument();
        FileOutputStream out = new FileOutputStream(new File("createdocument.docx"));
        document.write(out);
        out.close();
        System.out.println("createdocument.docx written successully");
    }

    public void writeFailedScenarioInDoc(List<ScenarioStepResults> resultLis, String testName) {
        if (failureDocs <= 20) {
            XWPFDocument document = new XWPFDocument();
            String buildIdFromConfig = PropertyFileReader.getInstance().getProperty("lambdaStackBuildId");
            String buildId = WebURLHelper.getParameterFromEnvOrSysParam("BUILD_NUMBER", buildIdFromConfig);
            try {

                FileOutputStream out = new FileOutputStream(new File("FailedScenarioDoc_" + buildId + "/" + testName + ".docx"));

                for (int i = 0; i < resultLis.size(); i++) {
                    String steDetails = "";
                    XWPFParagraph p1 = document.createParagraph();
                    if (resultLis.get(i).getScenarioName().equalsIgnoreCase(testName)) {
                        XWPFRun r1 = p1.createRun();
                        steDetails = "[--->Step " + (i + 1) + ": " + resultLis.get(i).getStepDocResult() + "<---]\n\r\n";
                        r1.setText(steDetails);
                        r1.addBreak();
                        if (resultLis.get(i).getStepResult().contains("FAILED")) {
                            steDetails = "[--->" + "Failed Reason:\r\n\n" + resultLis.get(i).getFailedReason() + " <---]";
                            r1.setText(steDetails);
                            r1.addBreak();
                            try {
                                InputStream is = new ByteArrayInputStream(resultLis.get(i).getBaos().toByteArray());
                                r1.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, "new", Units.toEMU(300), Units.toEMU(500));
                            } catch (Exception e) {
                                LOGGER.info(" [--->Unable to add screenshot into doc, with error message:" + e.getMessage() + "<---]");
                            }
                        }
                    }
                }
                document.write(out);
                out.close();
                System.out.println("createdocument.docx written successully");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            LOGGER.info("[--->Failure count more than 20 Skipped to create failure doc <---]");
        }
        failureDocs++;
    }

    public void createFolder(String buildId) {
        File f = new File("FailedScenarioDoc_" + buildId);
        if (f.exists()) {
            f.delete();
        }
        f.mkdir();
    }
}