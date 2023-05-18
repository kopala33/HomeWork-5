import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ElitSecondTest {

    @Test(priority = 2)
    public void secondProject() {

        /**
         * ტესტ მეთოდი 3
         * გადადით კალათაში და დარწმუნდით რომ ცარიელია
         * დასერჩეთ ნებისმიერი რაღაც რასაც შედეგი ექნება, მაგალითად კომპიუტერი,
         * ექნება, მაგალითად კომპიუტერი, პირეველივე შედეგი დაამატეთ კალათაში
         * გადადით კალათაში ნახეთ რომ კალათა აღარაა ცარიელი
         * წაშალეთ კალათიდან პროდუქტი
         * დარწმუნდით რომ კალათა კვლავ ცარიელია
         */


        open("https://ee.ge/registration");
        $(byAttribute("class", "cart")).click();
        sleep(2000);
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        sleep(2000);
        $("#search_list").setValue("კომპიუტერი");
        sleep(2000);
        $(".btn").click();
        sleep(2000);
        $(byText("დაამატე კალათში"), 0).click();
        sleep(2000);
        $(".cart").click();
        $(byText("დაამატე კალათში"), 0).shouldNotBe(Condition.empty);
        sleep(2000);
        $(".items", 0).click();
        sleep(2000);
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        sleep(2000);


    }

    @Test(priority = 3)
    public void elitTest4() {


        /**
         * ტესტ მეთოდი 4
         * გადადით კალათაში და დარწმუნდით რომ ცარიელია
         * გადადით შენახულ ნივთებში და დარწმუნდით რომ ცარიელია
         * დასერჩეთ ნებისმიერი რაღაც რასაც შედეგი ექნება, მაგალითად კომპიუტერი,
         * პირეველივე შედეგი დაამატეთ კალათაში
         * გადაით კალათაში და შეინახეთ მოცემული პროდუქტი
         * გადადით შენახულ ნივთებში და შეამოწმეთ რომ აღარაა ცარიელი
         * გადადით კალათაში და დარწუნდით რომ კალათიდან ავტოატურად წაიშალა პროდუქტი
         * გადადით შენახულ ნივთებში წაშალეთ შენახული პროდუქტი
         * დარწმუნდით რომ შენახული ნივთები ცარიელია
         */

        $(byAttribute("class", "cart")).click();
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        $(byText("შენახული ნივთები")).click();
        $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);
        $("#search_list").setValue("კომპიუტერი").click();
        sleep(1000);
        $(".btn").click();
        sleep(2000);
        $(byText("დაამატე კალათში"), 0).click();
        sleep(2000);
        $(".cart").click();
        sleep(2000);
        $(byText("შენახვა")).click();
        sleep(2000);
        $(byText("შენახული ნივთები")).shouldNotBe(Condition.empty);
        sleep(2000);
        $(byAttribute("class", "cart")).click();
        sleep(2000);
        $(byText("კალათა ცარიელია")).shouldBe(Condition.visible);
        sleep(2000);
        $(byText("შენახული ნივთები")).click();
        sleep(2000);
        $(byXpath("//i[@class='fa fa-times']")).click();
        sleep(2000);
        $(byText("ვერ მოიძებნა")).shouldBe(Condition.visible);
        sleep(2000);


    }

}
