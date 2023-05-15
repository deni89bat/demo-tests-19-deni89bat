package com.demoqa.tests;

import com.demoqa.pages.RegistrationModal;
import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AutomationPracticeFormWithPageObjectsTestRandomData extends RemoteTestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationModal registrationModal = new RegistrationModal();
    RandomUtils randomUtils = new RandomUtils();
    String  firstName = randomUtils.generateFirstName(),
            lastName = randomUtils.generateLastName(),
            userEmail = randomUtils.generateEmail(),
            gender = randomUtils.generateGender(),
            phoneNumber = randomUtils.generatePhoneNumber(),
            dayOfBirthDate = randomUtils.generateDay(),
            monthOfBirthDate = randomUtils.generateMonth(),
            yearOfBirthDate = randomUtils.generateYear(),
            subject = randomUtils.generateSubject(),
            hobbie = randomUtils.generateHobbie(),
            picture = randomUtils.generatePicture(),
            currentAddress = randomUtils.generateCurrentAddress(),
            stateSelect = randomUtils.generateState(),
            city = randomUtils.generateCity(stateSelect);

    @Test
    @Tag("remote")
    @DisplayName("Successful registration")
    void successfulRegistrationTest() {


       step("Открытие формы", ()-> {
           registrationPage.openPage()
                   .removeFooter();
       } );


        step("Заполнение формы", ()-> {
            registrationPage.setFirstNameInput(firstName)
                    .setLastNameInput(lastName)
                    .setUserEmail(userEmail)
                    .setGender(gender)
                    .setUserPhoneNumber(phoneNumber)
                    .setBirthDate(dayOfBirthDate, monthOfBirthDate, yearOfBirthDate)
                    .setSubject(subject)
                    .setHobbie(hobbie)
                    .setAndUploadPicture(picture)
                    .setCurrentAddress(currentAddress)
                    .setStateCityInput(stateSelect)
                    .setCity(city)
                    .pushSubmitButton();
        } );

        step("Проверка формы", ()-> {
            registrationModal.verifyModalAppears()
                    .verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", userEmail)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", phoneNumber)
                    .verifyResult("Date of Birth", dayOfBirthDate + " " + monthOfBirthDate + "," + yearOfBirthDate)
                    .verifyResult("Subjects", subject)
                    .verifyResult("Hobbies", hobbie)
                    .verifyResult("Picture", picture.substring(4))
                    .verifyResult("Address", currentAddress)
                    .verifyResult("State and City", stateSelect + " " + city);
        } );


    }

}
