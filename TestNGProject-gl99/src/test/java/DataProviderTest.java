import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

// Implement same scenario using @DataProvider

public class DataProviderTest {

    @DataProvider(name = "filler")
    public Object[][] getDataFromDataprovider() {
        return new Object[][]
                {
                        {"Forrest", "Gump", 0, "1111111111"},
                        {"Dan", "Taylor",0, "2222222222"},
                        {"Jenny", " Curran", 1, "3333333333"}
                };

    }


    @Test(dataProvider = "filler")
    public void dataTest(String firstName, String lastName, Integer gender, String mobileNumber) throws InterruptedException {
        Configuration.startMaximized =true;
        Configuration.browser="Edge";
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").sendKeys(firstName);
        $("#lastName").sendKeys(lastName);
//        $("#gender-radio-"+"1").scrollIntoView(true);
//        $("#gender-radio-"+"1").click();
        $("div.custom-control.custom-radio.custom-control-inline", gender).click();
        $("#userNumber").sendKeys(mobileNumber);

        $("#submit").scrollIntoView(true);
        $("#submit").click();
        //        Validate the Student Name value dynamically
        // საიტი ხანდახან სკიპავს რომელიმე ტესტის ინსტანციას და გამოაქ ცარიელი სტრინგები
        // ამიტომ სჭირდება მცირე დრო ლოადისთვის
        Thread.sleep(200);
        System.out.println($("tbody > tr:nth-child(1) > td:nth-child(2)").getText());
        $("tbody > tr:nth-child(1) > td:nth-child(2)").shouldBe(Condition.text(firstName + " " + lastName));

    }
    @AfterTest
    public void endTest1 (){
        System.out.println("<<<<TestEnd>>>>");
    }
}


