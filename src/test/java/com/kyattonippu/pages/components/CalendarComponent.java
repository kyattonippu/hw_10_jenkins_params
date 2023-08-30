package com.kyattonippu.pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public static void setDate(String day, String month, String year) {
        $(".react-datepicker__month-dropdown-container").$(byText(month)).click();
        $(".react-datepicker__year-dropdown-container").$(byText(year)).click();
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
    }
}
