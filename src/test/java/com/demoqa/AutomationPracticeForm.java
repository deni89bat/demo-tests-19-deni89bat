package com.demoqa;

import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.Keys.*;
public class AutomationPracticeForm extends ConfigDemoQa {
    @Test
    void fillAndCheckAutoPracticeForm() {
        open("/automation-practice-form");

        $("#firstName").setValue("Bruce");
        $("#lastName").setValue("Wayne");
        $("#userEmail").setValue("nobodyKnows@whoIm.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").sendKeys(CONTROL + "A");
        $("#dateOfBirthInput").sendKeys("01.01.1999");
        $("#dateOfBirthInput").pressEnter();
        $("#subjectsInput").setValue("Maths");
        $("#subjectsInput").pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/data/01.jpg"));
        $("#currentAddress").setValue("Gotham");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        $(".table").shouldHave(text("Bruce Wayne"));
        $(".table").shouldHave(text("nobodyKnows@whoIm.com"));
        $(".table").shouldHave(text("Male"));
        $(".table").shouldHave(text("1234567890"));
        $(".table").shouldHave(text("01 January,1999"));
        $(".table").shouldHave(text("Maths"));
        $(".table").shouldHave(text("Sports, Reading, Music"));
        $(".table").shouldHave(text("01.jpg"));
        $(".table").shouldHave(text("Gotham"));
        $(".table").shouldHave(text("NCR Delhi"));
    }
}
