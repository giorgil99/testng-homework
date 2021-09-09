import org.testng.ISuite;
import org.testng.ISuiteListener;

public class LocalISuitListener implements ISuiteListener {


    @Override
    public void onStart(ISuite suite){

        System.out.println("test is running");
    }


    @Override
    public void onFinish(ISuite suite) {

        System.out.println("onFinish: after suite completes");
        System.out.println(suite.getAllInvokedMethods());
        System.out.println("invoked method count "+suite.getAllInvokedMethods().size());
    }


}
