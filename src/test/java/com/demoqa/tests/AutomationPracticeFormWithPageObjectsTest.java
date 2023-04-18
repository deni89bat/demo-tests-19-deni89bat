package com.demoqa.tests;

import com.demoqa.pages.RegistrationModal;
import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

public class AutomationPracticeFormWithPageObjectsTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationModal registrationModal = new RegistrationModal();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstNameInput("Bruce")
                .setLastNameInput("Wayne")
                .setUserEmail("nobodyKnows@whoIm.com")
                .setGender("Male")
                .setUserPhoneNumber("1234567890")
                .setBirthDate("6", "June", "2000")
                .setSubject("Arts")
                .setHobbies(true, false, true)
                .setAndUploadPicture("img/01.jpg")
                .setCurrentAddress("Gotham")
                .setStateCityInput("NCR")
                .setCity("Delhi")
                .pushSubmitButton();

        registrationModal.verifyModalAppears()
                .verifyResult("Student Name", "Bruce Wayne")
                .verifyResult("Student Email", "nobodyKnows@whoIm.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "06 June,2000")
                .verifyResult("Subjects", "Arts")
                .verifyResult("Hobbies", "Sports, Music")
                .verifyResult("Picture", "01.jpg")
                .verifyResult("Address", "Gotham")
                .verifyResult("State and City", "NCR Delhi");
    }
}
