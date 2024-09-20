package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Setup implements ITestListener {
    public static ExtentReports extentReports;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public void onStart(ITestContext context) {
        String fileName = ExtentReportmanager.getReportnameWithTimeStamp();
        String folderPath = System.getProperty("user.dir") + File.separator +"reports" + File.separator;
        String fullpath = folderPath + fileName;

        File reportDir = new File(folderPath);
        if (!reportDir.exists()) {
            boolean created = reportDir.mkdirs();  // Create the directory
            if (created) {
                System.out.println("Reports folder created successfully: " + folderPath);
            } else {
                System.out.println("Failed to create reports folder: " + folderPath);
            }
        } else {
            System.out.println("Reports folder already exists: " + folderPath);
        }
        System.out.println("Report folder path: " + folderPath);
        System.out.println("Full report path: " + fullpath);
        // Create the reports directory if it doesn't exist
        extentReports = ExtentReportmanager.createInstance(fullpath,"Test Api Automation ","Test execution");
    }

    public void onFinish(ITestContext context) {
        if(extentReports != null){
            extentReports.flush();
        }
    }
    public void onTestStart(ITestResult result) {
    ExtentTest test =  extentReports.createTest("Test Name "+result.getTestClass().getName()+"  - "+result.getMethod().getMethodName());
    extentTest.set(test);
    }
}
