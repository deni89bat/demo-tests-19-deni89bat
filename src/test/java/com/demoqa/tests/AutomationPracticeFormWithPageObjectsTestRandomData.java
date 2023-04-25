package com.demoqa.tests;

import com.demoqa.pages.RegistrationModal;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import static com.demoqa.utils.RandomUtils.*;

public class AutomationPracticeFormWithPageObjectsTestRandomData extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationModal registrationModal = new RegistrationModal();

    @Test
    void successfulRegistrationTest() {

        String firstName = generateFirstName(),
                lastName = generateLastName(),
                userEmail = generateEmail(),
                gender = generateGender(),
                phoneNumber = generatePhoneNumber(),
                dayOfBirthDate = generateDay(),
                monthOfBirthDate = generateMonth(),
                yearOfBirthDate = generateYear(),
                subject = generateSubject(),
                hobbie = generateHobbie(),
                picture = generatePicture(),
                currentAddress = generateCurrentAddress(),
                stateSelect = generateState(),
                city = generateCity(stateSelect);

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
