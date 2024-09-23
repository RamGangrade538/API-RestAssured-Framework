package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.http.Header;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExtentReportmanager {
    public static  ExtentReports extentReports;
    public static ExtentReports createInstance(String filename , String DocumentTitle, String testExecution) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filename);
        extentSparkReporter.config().setDocumentTitle(DocumentTitle);
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setEncoding("utf-8");
        extentSparkReporter.config().setReportName("Test Execution: " + testExecution);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports;
    }

    public static String getReportnameWithTimeStamp(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String FormatedTime = dateTimeFormatter.format(localDateTime);
        String reportName = "TestRun_" + FormatedTime + ".html";
        return reportName ;
    }
    public static void logPassdetails(String log){
       Setup.extentTest.get().pass(MarkupHelper.createLabel(log , ExtentColor.GREEN));
    }
    public static void logFaildetails(String log){
        Setup.extentTest.get().fail(MarkupHelper.createLabel(log , ExtentColor.RED));
    }
    public static void logInfodetails(String log){
        Setup.extentTest.get().info(MarkupHelper.createLabel(log , ExtentColor.GREY));
    }
    public static void logWarningdetails(String log){
        Setup.extentTest.get().warning(MarkupHelper.createLabel(log , ExtentColor.YELLOW));
    }
    public static void logJson(String json){
        Setup.extentTest.get().info(MarkupHelper.createCodeBlock(json , CodeLanguage.JSON));
    }
    // for printing hreader
    public static void logHeader(List<io.restassured.http.Header>  headerList){
        String [] [] arrayHeader = headerList.stream()
                                    .map( header -> new String[]{ header.getName(),header.getValue()})
                                    .toArray(String [] [] :: new );
        Setup.extentTest.get().info(MarkupHelper.createTable(arrayHeader));
    }
}
