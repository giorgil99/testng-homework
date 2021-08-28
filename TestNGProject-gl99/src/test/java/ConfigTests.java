import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;


public class ConfigTests {
    @BeforeSuite

    public void testCfg() {
        System.out.println("Executed before suit ");
//        Change at least two Selenide default Configuration for all project tests *
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout= 500 ;
        Configuration.reopenBrowserOnFail = true;

    }



}
