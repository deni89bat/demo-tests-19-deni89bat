package com.demoqa.tests;

import com.demoqa.pages.RegistrationModal;
import com.demoqa.pages.RegistrationPage;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormWithPageObjectsTestRandomData extends TestBase {
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
    void successfulRegistrationTest() {


        registrationPage.openPage()
                .removeFooter()
                .setFirstNameInput(firstName)
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
    }

}
