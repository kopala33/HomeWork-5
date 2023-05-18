import Utils.ChromeRunner;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ElitTest extends ChromeRunner {

    @Test(priority = 0)
    public void elitEleqtronics() {

        /**
         * გახსენით ee.ge - ს ლინკი
         * ტესტ მეთოდი 1 - დადებითი მნიშვნელობები
         * გადადით რეგისტრაციის გვერდზე
         * შეამოწმეთ რომ ნამდვილად რეგისტრაციის გვერდზე ხართ
         * შეავსეთ სახელის ველი, დარწმუნდით რომ მონაცემი ჩაიწერა ანუ ველი არ არის ცარიელი
         * შეავსეთ გვარის ველი, დარწმუნდით რომ მონაცემი ჩაიწერა ანუ ველი არ არის ცარიელი
         * შეავსეთ მეილის ველი სწორი მნიშვნელობით , დარწმუნდით რომ მონაცემი ჩაიწერა ანუ
         * ველი არ არის ცარიელი
         * შეავსეთ პაროლის ველი
         * შეავსეთ გაიმეორეთ პაროლის ველი
         * შეამოწმეთ რომ რეგისტრაციის ღილაკი არის Enabled
         */


        $(byText("რეგისტრაცია")).click();
        $(byText("სწრაფი რეგისტრაცია")).shouldBe(Condition.visible);
        sleep(3000);
        $("#firstName").setValue("Data");
        $("#firstName").shouldNotBe(Condition.empty); // ესეთი თანმიმდევრობითაც შეიძლება
        sleep(3000);
        $("#lastName").setValue("kopala");
        $("#lastName").shouldNotBe(Condition.empty);
        sleep(3000);
        $("#email").setValue("shxamiani@gmail.com").shouldBe(Condition.visible); // და ესეც
        sleep(3000);
        $("#password").setValue("12345678").shouldBe(Condition.visible);
        sleep(1000);
        $("#confirmPassword").setValue("12345678").shouldBe(Condition.visible);
        sleep(1000);
        $("#singup").shouldBe(Condition.enabled);
        sleep(1000);

    }

    @Test(priority = 1)
    public void elitTest2() {

        /**
         * ტესტ მეთოდი 2 - ნეგატიური მნიშვნელობები
         * გადადით რეგისტრაციის გვერდზე
         * შეამოწმეთ რომ ნამდვილად რეგისტრაციის გვერდზე ხართ
         * შეამოწმეთ რომ 'რეგისტრაცია' ღილაკი არის Disabled
         * შეამოწმეთ ველების მანდატორობა, ველში დაკლიკების შემდეგ სხვა ველზე
         * დაკლიკებით გამოაქვს შეტყობინება, შეამოწმეთ ხუთივე ველის შეტყობინება
         * ელ-ფოსტის ველში ჩაწერეთ არასწორი მეილის ფორმატით მნიშვნელობა, შეამოწმეთ რომ არ ქრება შეტყობინება
         * შეამოწმეთ პაროლის ველი 6 სიმბოლოზე ნაკლების შეყვანის შემთხვევაშ არ უნდა გაქრეს შეტყობინება
         * გაიმეორეთ პაროლის ველში პაროლის ველისგან განსხვავებული მნიშვნელობის
         * ჩაწერისას არ უნდა გაქრეს შეტყობინება
         */


        open("https://ee.ge/registration");
        $(byText("სწრაფი რეგისტრაცია")).shouldBe(Condition.visible);
        $("#singup").shouldBe(Condition.disabled);
        $("#firstName").click();
        $("#lastName").click();
        $(byText("სახელი სავალდებულოა")).shouldBe(Condition.visible);
        $("#email").click();
        $(byText("გვარი სავალდებულოა")).shouldBe(Condition.visible);
        $("#password").click();
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        $("#confirmPassword").click();
        $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);
        $("#email").click();
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);

        $(byId("email")).setValue("rogorxart");
        $(byId("firstName")).click();
        $(byText("ელ. ფოსტა სავალდებულოა")).shouldBe(Condition.visible);
        $(byId("password")).setValue("12345");
        $(byId("confirmPassword")).click();
        $(byText("პაროლი სავალდებულოა.")).shouldBe(Condition.visible);
        $(byId("password")).setValue("123333");
        $(byId("confirmPassword")).setValue("dddttt");
        $(byId("firstName")).click();
        $(byText("პაროლის გამეორება სავალდებულოა")).shouldBe(Condition.visible);


    }


}
