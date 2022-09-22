package org.skan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class PracticeFormClass {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.holdBrowserOpen=true;
        Configuration.pageLoadTimeout=150000;
        Configuration.browserSize="1920x1080";
        //Configuration.timeout=60000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Sergey");
        $("#lastName").setValue("Kan");
        $("#userEmail").setValue("Sergey@google.com");
        $x("//label[@for='gender-radio-1']").click();
        $("#userNumber").setValue("7771234567");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--022:not(.react-datepicker__day--selected").click();
        $x("//label[@for='hobbies-checkbox-1']").click();

    }
}
