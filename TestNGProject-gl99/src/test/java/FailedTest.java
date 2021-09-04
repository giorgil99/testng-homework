import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class FailedTest {
    public static int startSeconds ;
    @BeforeTest(groups ={"FrontEnd"})
    public static void dateSetter() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ss");
        String a = dtf.format(LocalDateTime.now());
        startSeconds =Integer.parseInt(a);
    }

//  Create one test method that should fail 5 times and

    @Test(groups ={"FrontEnd"},retryAnalyzer = localRetry.class )
    public  void  erroredTest () throws InterruptedException {
        Thread.sleep(1000);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd");
        String day = dtf1.format(LocalDateTime.now());
        int b = Integer.parseInt(day) ;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ss");
        String a = dtf.format(LocalDateTime.now());


        int EndSeconds =Integer.parseInt(a);
        int diffTime =EndSeconds - startSeconds ;
        System.out.println(startSeconds);
        System.out.println(EndSeconds);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(7, diffTime);
        softAssert.assertAll();


    }


}
