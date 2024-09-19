package reporting;

import com.aventstack.extentreports.ExtentReports;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class Setup implements ITestListener {
    public static ExtentReports extentReports;
    public void onStart(ITestContext context) {
        String fileName = ExtentReportmanager.getReportnameWithTimeStamp();
        String fullpath = System.getProperty("user.dir")+ "\\reports\\"+ fileName;
        extentReports = ExtentReportmanager.createInstance(fileName,"Test Api Automation ","Test execution");
    }

    public void onFinish(ITestContext context) {
        if(extentReports != null){
            extentReports.flush();
        }

    }
}
