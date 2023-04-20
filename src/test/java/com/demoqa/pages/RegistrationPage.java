package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();

    //Senide elements / locator / etc
    SelenideElement formHeaderText = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            gender = $("#genterWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            userPhoneNumber = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbieInput = $("#hobbiesWrapper"),
            picture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateCityInput = $("#stateCity-wrapper"),
            state = $("#state"),
            city = $("#city"),
            submitButton = $("#submit");

    //Actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formHeaderText.shouldHave(text("Student Registration Form"));
        return this;
    }

    public RegistrationPage removeFooter() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }


    public RegistrationPage setFirstNameInput(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setLastNameInput(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserPhoneNumber(String value) {
        userPhoneNumber.setValue(value);
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbie(String hobbie) {
        hobbieInput.$(byText(hobbie)).click();
        return this;
    }

    public RegistrationPage setAndUploadPicture(String value) {
        picture.uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public RegistrationPage setStateCityInput(String value) {
        state.click();
        stateCityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        stateCityInput.$(byText(value)).click();
        return this;
    }

    public void pushSubmitButton() {
        submitButton.click();
    }


}
