import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Listeners({SoftAsserts.class})
public class RadioButtonTests {



    @BeforeTest
    public void test2config () {

//        CheckboxTests and RadioButtonTests classes should have config method with baseurl *
//        Save failed test screenshots in 'RadioButtonFailedTests’ folder *
        Path root = Paths.get(".").normalize().toAbsolutePath();
        Configuration.reportsFolder = root + "\\RadioButtonFailedTests";
        Configuration.savePageSource = false;
        Configuration.assertionMode = SOFT;
        baseUrl = "https://demoqa.com/radio-button" ;

    }

    @BeforeMethod
    public void test2Method() {
//        Navigate to the https://demoqa.com/radio-button from RadioButtonTests class
        open(baseUrl);

    }
//    Create a method in to select ‘Yes’ option
//    Invoke failed testng soft assertion

    @Test

    public void test2_try1 () {
        System.out.println("test2_try1");
        $("label.custom-control-label[for='yesRadio']").scrollIntoView(true);
        $("label.custom-control-label[for='yesRadio']").click();
        $("span.text-success").shouldHave(Condition.text("No")) ;

    }

//    Create a method to check that ‘No’ option is available (failed case)


    @Test
    public void test2_try2 () {
        System.out.println("test2_try2");
        $("#noRadio").shouldNotBe(Condition.disabled);

    }

    @AfterTest
    public void terminate() {
        System.out.println("Closed browser after RadioButtonTests ");
    }

}
