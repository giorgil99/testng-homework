import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Test
public class FactoryTest {

    public static String firstName;
    public static String lastName;
    public static int gender;
    public static String mobileNumber;
    public  int main ;


    public FactoryTest(int i) {
        main=i;

    }


    @BeforeMethod
    public void manufacturer() {
        if (main == 0) {
            System.out.println(main);
            firstName = "King";
            lastName = "Aragorn";
            gender = 0;
            mobileNumber = "1111111111";
//            main++;

        } else if (main == 1) {
            System.out.println(main);
            firstName = "Wizard";
            lastName = "Gandalf";
            gender = 0;
            mobileNumber = "2222222222";
//            main++;

        } else {
            System.out.println(main);
            firstName = "Elf ";
            lastName = "Arwen";
            gender = 1;
            mobileNumber = "3333333333";
        }


    }


    @Test()
    public void dataTest() throws InterruptedException {
        Configuration.startMaximized = true;
        Configuration.browser = "Edge";
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
    public void endTest2 (){
        System.out.println("<<<<TestEnd>>>>");
    }
}

