package com.kyattonippu.pages.components;

import com.codeborne.selenide.Condition;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModalWindow {

    public static void verifyThatModalWindowAppears() {
        $(".modal-dialog").should(Condition.appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public static void verifyResult(Map<String, String> valuesMap) {
        valuesMap.forEach((key, value) -> $(".table-responsive")
                .$(byText(key))
                .parent()
                .shouldHave(text(value)));
    }

    public static void closeResultModalWindow() {
        $("#closeLargeModal").click();
    }
}