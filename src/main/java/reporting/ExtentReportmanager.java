package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportmanager {
    public static  ExtentReports extentReports;
    public static ExtentReports createInstance(String filename , String DocumentTitle, String testExecution){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filename);
        extentSparkReporter.config().setDocumentTitle(DocumentTitle);
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setEncoding("utf-8");
         extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        return extentReports ;
    }
    public static String getReportnameWithTimeStamp(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        String FormatedTime = dateTimeFormatter.format(localDateTime);
        String reportName = "Test" + FormatedTime + ".html";
        return reportName ;
    }
}
