package com.demoqa.utils;


import com.github.javafaker.Faker;

import java.util.Locale;

// Class for fake data generating
public class RandomUtils {
    private final Faker faker = new Faker(new Locale("en"));

    String[]
            gender = {"Male", "Female", "Other"},
            month = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November"},
            subject = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science", "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"},
            hobbie = {"Sports", "Reading", "Music"},
            picture = {"img/01.jpg", "img/02.jpg"},
            state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
            cityOfNCR = {"Delhi", "Gurgaon", "Noida"},
            cityOfUttarPradesh = {"Agra", "Lucknow", "Merrut"},
            cityOfHaryana = {"Karnal", "Panipat"},
            cityOfRajasthan = {"Jaipur", "Jaiselmer"};


    public String generateFirstName() {
        return faker.name().firstName();
    }

    public String generateLastName() {
        return faker.name().lastName();
    }

    public String generateEmail() {
        return faker.internet().emailAddress();
    }

    public String generateGender() {
        return faker.options().option(gender);
    }

    public String generatePhoneNumber() {
        return faker.number().digits(10);
    }

    public String generateDay() {
        return String.valueOf(faker.number().numberBetween(1, 31));
    }

    public String generateMonth() {
        return faker.options().option(month);
    }

    public String generateYear() {
        return String.valueOf(faker.number().numberBetween(1907, 2015));
    }

    public String generateSubject() {
        return faker.options().option(subject);
    }

    public String generateHobbie() {
        return faker.options().option(hobbie);
    }

    public String generatePicture() {
        return faker.options().option(picture);
    }

    public String generateCurrentAddress() {
        return faker.address().fullAddress();
    }

    public String generateState() {
        return faker.options().option(state);
    }

    public String generateCity(String state) {
        switch (state) {
            case "NCR": {
                return faker.options().option(cityOfNCR);
            }
            case "Uttar Pradesh": {
                return faker.options().option(cityOfUttarPradesh);
            }
            case "Haryana": {
                return faker.options().option(cityOfHaryana);
            }
            case "Rajasthan": {
                return faker.options().option(cityOfRajasthan);
            }
        }
        return null;
    }
}
