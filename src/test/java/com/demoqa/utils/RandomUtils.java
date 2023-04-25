package com.demoqa.utils;


import com.github.javafaker.Faker;

import java.util.Locale;

// Class for fake data generating
public class RandomUtils {
    private static final Faker faker = new Faker(new Locale("en"));

    static String[]
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


    static public String generateFirstName() {
        return faker.name().firstName();
    }

    static public String generateLastName() {
        return faker.name().lastName();
    }

    static public String generateEmail() {
        return faker.internet().emailAddress();
    }

    static public String generateGender() {
        return faker.options().option(gender);
    }

    static public String generatePhoneNumber() {
        return faker.number().digits(10);
    }

    static public String generateDay() {
        return String.valueOf(faker.number().numberBetween(1, 31));
    }

    static public String generateMonth() {
        return faker.options().option(month);
    }

    static public String generateYear() {
        return String.valueOf(faker.number().numberBetween(1907, 2015));
    }

    static public String generateSubject() {
        return faker.options().option(subject);
    }

    static public String generateHobbie() {
        return faker.options().option(hobbie);
    }

    static public String generatePicture() {
        return faker.options().option(picture);
    }

    static public String generateCurrentAddress() {
        return faker.address().fullAddress();
    }

    static public String generateState() {
        return faker.options().option(state);
    }

    public static String generateCity(String state) {
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
