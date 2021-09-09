import org.testng.ITestListener;
import org.testng.ITestResult;

public class LocalListenersTestNG implements ITestListener {

    public void onTestSuccess(ITestResult result) {
        System.out.println("TestngListener on TestSuccess: ");
        System.out.println("SUCCEED " +result.getName());
    }


    public void onTestFailure(ITestResult result) {
        System.out.println("TestngListener on TestFailure: ");
        System.out.println(  "FAILED " +result.getName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("TestngListener on TestSkipped : ");
        System.out.println("SKIPPED " +result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("TestngListener on testSuccessPercent: ");
        System.out.println("PASSED BY PERCENT  " +result.getName());
    }

}
