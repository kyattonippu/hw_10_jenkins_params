package com.kyattonippu.pages;

import com.codeborne.selenide.SelenideElement;
import com.kyattonippu.pages.components.CalendarComponent;
import com.kyattonippu.pages.components.ResultsModalWindow;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    CalendarComponent calendar = new CalendarComponent();
    ResultsModalWindow resultsModalWindow = new ResultsModalWindow();

    // locators & elements
    private final String FORM_TITLE = "Student Registration Form";

    private SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderRadio = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            checkboxHobbies = $("#hobbiesWrapper"),
            uploadFileButton = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            selectState = $("#state"),
            selectCity = $("#city"),
            StateOrCitySelector = $("#stateCity-wrapper"),
            submitButton = $("#submit");

    // actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));

        return this;
    }

    public RegistrationPage removeBannerAndFooter() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage typeUserEmail(String userEmail) {
        userEmailInput.setValue(userEmail);

        return this;
    }

    public RegistrationPage chooseGender(String gender) {
        userGenderRadio.$(byText(gender)).click();

        return this;
    }

    public RegistrationPage typeUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        CalendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage typeSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        checkboxHobbies.$(byText(hobbies)).click();

        return this;
    }

    public RegistrationPage uploadFile(String classpath) {
        uploadFileButton.uploadFromClasspath(classpath);

        return this;
    }

    public RegistrationPage typeAddress(String address) {
        addressInput.setValue(address);

        return this;
    }

    public RegistrationPage selectState(String state) {
        selectState.scrollIntoView(true);
        selectState.click();
        $(StateOrCitySelector).$(byText(state)).click();

        return this;
    }

    public RegistrationPage selectCity(String city) {
        selectCity.click();
        $(StateOrCitySelector).$(byText(city)).click();

        return this;
    }

    public RegistrationPage submit() {
        submitButton.scrollIntoView(true);
        submitButton.click();

        return this;
    }

    public RegistrationPage checkThatResultsBlockAppears() {
        ResultsModalWindow.verifyThatModalWindowAppears();
        return this;
    }

    public RegistrationPage checkResultValues(Map<String, String> valuesMap) {
        ResultsModalWindow.verifyResult(valuesMap);
        return this;
    }

    public void closeResultModalWindow() {
        ResultsModalWindow.closeResultModalWindow();
    }

}
