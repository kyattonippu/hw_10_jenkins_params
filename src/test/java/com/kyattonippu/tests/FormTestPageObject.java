package com.kyattonippu.tests;
import static com.kyattonippu.utils.RandomTestData.*;
import static io.qameta.allure.Allure.step;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

@Owner("kyattonippu")
@Feature("Students registration form")
@Story("Fill registration form")
@Severity(SeverityLevel.BLOCKER)
@Link(value = "Practice Form", url = "https://demoqa.com/automation-practice-form")
@DisplayName("Fill students registration form with generated data")
@Tag("registrationPage")
public class FormTestPageObject extends TestBase {

    private final Map<String, String> resultValues = new HashMap<>() {{
        put("Student Name", firstName + " " + lastName);
        put("Student Email", userEmail);
        put("Gender", gender);
        put("Mobile", userNumber);
        put("Date of Birth", day + " " + month + "," + year);
        put("Subjects", subjects);
        put("Hobbies", hobby);
        put("Picture", image);
        put("Address", currentAddress);
        put("State and City", state + " " + city);
    }};

    @Test
    @Tag("remote")
    void fullFormTest() {
        step("Open students registration form", () -> {
            registrationPage.openPage()
                    .removeBannerAndFooter();
        });

        step("Fill students registration form", () -> {
            step("Fill common data", () -> {
                registrationPage.typeFirstName(firstName)
                        .typeLastName(lastName)
                        .typeUserEmail(userEmail)
                        .chooseGender(gender)
                        .typeUserNumber(userNumber);
            });
            step("Set birth date", () -> registrationPage.setBirthDate(day, month, year));
            step("Set subjects", () -> registrationPage.typeSubjects(subjects));
            step("Set hobbies", () -> registrationPage.setHobbies(hobby));
            step("Upload image", () -> registrationPage.uploadFile(image));
            step("Set address", () -> {
                registrationPage.typeAddress(currentAddress)
                        .selectState(state)
                        .selectCity(city);
            });
            step("Submit form", () -> registrationPage.submit());
        });

        step("Verify successful form submit", () -> {
            registrationPage
                    .checkThatResultsBlockAppears()
                    .checkResultValues(resultValues)
                    .closeResultModalWindow();
        });
    }
}
