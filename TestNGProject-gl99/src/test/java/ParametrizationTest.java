import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


// Fill First Name, Last Name , Gender and mobile number dynamically using @Parameters
// Each parameter should receive 3 different values
public class ParametrizationTest {
    @Parameters({"firstName", "lastName", "Gender", "mobileNumber"})
    @Test
    public void parametersTest(String firstName, String lastName, Integer gender, String mobileNumber) {
        Configuration.startMaximized = true;
        Configuration.browser = "Edge";

        open("https://demoqa.com/automation-practice-form");

        $("#firstName").sendKeys(firstName);
        $("#lastName").sendKeys(lastName);
        $("div.custom-control.custom-radio.custom-control-inline", gender).click();
        $("#userNumber").sendKeys(mobileNumber);

        $("#submit").scrollIntoView(true);
        $("#submit").click();

//        Validate the Student Name value dynamically

        $("tbody > tr:nth-child(1) > td:nth-child(2)").scrollIntoView(true);
        System.out.println($("tbody > tr:nth-child(1) > td:nth-child(2)").getText());
        $("tbody > tr:nth-child(1) > td:nth-child(2)").shouldBe(Condition.text(firstName + " " + lastName));

    }

    @AfterTest
    public void endTest0() {
        System.out.println("<<<<TestEnd>>>>");
    }
}
