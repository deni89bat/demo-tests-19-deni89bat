package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {

        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        if (day.length() < 2) {
            String dayPickerLocator = String.format(".react-datepicker__day--00%s:not(.react-datepicker__day--outside-month)", day);
            $(dayPickerLocator).click();
        } else {
            String dayPickerLocator = String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
            $(dayPickerLocator).click();
        }


    }


}

