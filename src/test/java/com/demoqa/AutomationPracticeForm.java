package com.demoqa;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.Keys.CONTROL;

public class AutomationPracticeForm extends TestBase {
    @Test
    void fillAndCheckAutoPracticeForm() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
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
        $("#uploadPicture").uploadFromClasspath("01.jpg");
        $("#currentAddress").setValue("Gotham");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();
        $(".table").shouldHave(text("Bruce Wayne"),
                text("nobodyKnows@whoIm.com"),
                text("Male"),
                text("1234567890"),
                text("01 January,1999"),
                text("Maths"),
                text("Sports, Reading, Music"),
                text("01.jpg"),
                text("Gotham"),
                text("NCR Delhi"));

    }
}
