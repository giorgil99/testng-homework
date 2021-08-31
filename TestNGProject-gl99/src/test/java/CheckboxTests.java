import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.testng.SoftAsserts;
import org.testng.annotations.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.codeborne.selenide.AssertionMode.SOFT;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;


@Listeners({SoftAsserts.class})
public class CheckboxTests {

    @BeforeTest

    public void test1config() {

//        CheckboxTests and RadioButtonTests classes should have config method with baseurl *
//        Save failed test screenshots in 'CheckboxFailedTests’ folder *
        Path root = Paths.get(".").normalize().toAbsolutePath();
        Configuration.reportsFolder = root + "\\CheckboxFailedTests";
        Configuration.savePageSource = false;
        Configuration.assertionMode = SOFT;
        baseUrl = "http://the-internet.herokuapp.com/checkboxes";

    }

    //    All tests should be started with new webdriver instance *
    @BeforeMethod
    public void test1Method() {
//        Navigate to the http://the-internet.herokuapp.com/checkboxes from CheckboxTests class
        open(baseUrl);

    }


    //    Create a method to uncheck checked checkbox
    //    Invoke failed testng soft assertion

    @Test

    public void test1_try1() {
        System.out.println("test1_try1");
        ElementsCollection list = $("#checkboxes").findAll("input[type=\"checkbox\"]");
        for (com.codeborne.selenide.SelenideElement selenideElement : list) {
            if (selenideElement.isSelected()) {
                selenideElement.click();
            }
        }

        list.get(list.size() - 1).shouldBe(Condition.selected);

    }

//    Create a method to check unchecked checkbox
//    Invoke failed testng soft assertion


    @Test

    public void test1_try2()  {
        System.out.println("test1_try2");
        ElementsCollection list = $("#checkboxes").findAll("input[type=\"checkbox\"]");
        for (com.codeborne.selenide.SelenideElement selenideElement : list) {
            if (!selenideElement.isSelected()) {
                selenideElement.click();
            }
        }

        list.get(list.size() - 1).shouldNotBe(Condition.selected);

    }

    @AfterTest
    public void terminate() {
//    closes browser after CheckboxTests
        webdriver().object().quit();
        System.out.println("Closed browser after CheckboxTests ");
    }
}
