import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class TestngListenersTest {

    public static int testNumber1 = 0 ;

    @Test(groups = {"ListenerTestGroup"})
    public void successTest() {
        System.out.println("successTest >>>>");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testNumber1, 0);
        testNumber1 ++ ;
        softAssert.assertAll();


    }

    @Test(groups = {"ListenerTestGroup"},priority = 1)
    public void  failedTEst() {
        System.out.println("failedTEst >>>>");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testNumber1, 0);
        softAssert.assertAll();
    }

    @Test(groups = {"ListenerTestGroup"},dependsOnMethods = {"failedTEst"},priority = 2)
    public void skippedTEst() {
        System.out.println("skippedTEst >>>>");

    }

    @Test(groups = {"ListenerTestGroup"},invocationCount = 10,successPercentage = 50,priority = 3)
    public void percentSFTest () {
        System.out.println("percentSFTest >>>>");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(testNumber1>=6);
        testNumber1 ++ ;
        System.out.println(testNumber1);
        softAssert.assertAll();



    }

    @Test(groups = {"DisabledGroup"},priority = 4)
    public void disabledTEst() {
        System.out.println("disabledTEst >>>>");


    }

}
