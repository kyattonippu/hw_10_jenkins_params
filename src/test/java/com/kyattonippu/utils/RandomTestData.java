package com.kyattonippu.utils;

import com.github.javafaker.Faker;

import java.util.Map;

public class RandomTestData {

    private static final Faker faker = new Faker();

    static Map<String, String[]> statesAndCitiesMap = Map.of(
            "NCR", new String[]{"Delhi", "Gurgaon", "Noida"},
            "Haryana", new String[]{"Karnal", "Panipat"},
            "Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"},
            "Rajasthan", new String[]{"Jaipur", "Jaiselmer"});

    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String userEmail = faker.internet().emailAddress();
    public static String currentAddress = faker.address().fullAddress();
    public static String userNumber = 8 + faker.phoneNumber().subscriberNumber(9);

    public static String gender = faker.options().option("Male", "Female", "Other");
    public static String month = faker.options().option("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December");
    public static String day = String.valueOf(faker.number().numberBetween(10, 28));
    public static String year = String.valueOf(faker.number().numberBetween(1940, 2005));
    public static String hobby = faker.options().option("Reading", "Sports", "Music");
    public static String subjects = faker.options().option("Accounting", "Maths", "Arts", "English", "Physics", "Chemistry", "Computer Science",
            "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology");
    public static String image = faker.options().option("testimage.jpg", "testimage2.png");
    public static String state = faker.options().option(statesAndCitiesMap.keySet().toArray()).toString();
    public static String city = faker.options().option(statesAndCitiesMap.get(state));
}
