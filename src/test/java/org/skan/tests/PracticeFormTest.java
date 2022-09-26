package org.skan.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.skan.pages.RegistrationFormPage;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    @BeforeAll
    static void setUp(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.holdBrowserOpen=true;
        //Configuration.pageLoadTimeout=150000;
        Configuration.browserSize="1920x1080";
    }

    @Test
    void fillPracticeFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Sergey")
                .setLastName("Kan")
                .setEmail("Sergey@google.com")
                .setGender("Male")
                .setPhone("7123477777")
                .setBirthDate("22", "May","1990");
        $("#subjectsInput").setValue("Maths").pressEnter();
        $x("//label[@for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/testpicture.jpeg"));
        $("#currentAddress").setValue("some address");
        $("#react-select-3-input").setValue("NCR").pressTab();
        $("#react-select-4-input").setValue("Delhi").pressEnter().pressEnter();

        $("#example-modal-sizes-title-lg").shouldHave(Condition.text("Thanks for submitting the form"));
        $x("//tbody/tr[1]/td[2]").shouldHave(Condition.text("Sergey Kan"));
        $x("//tbody/tr[2]/td[2]").shouldHave(Condition.text("Sergey@google.com"));
        $x("//tbody/tr[3]/td[2]").shouldHave(Condition.text("Male"));
        $x("//tbody/tr[4]/td[2]").shouldHave(Condition.text("7123477777"));
        $x("//tbody/tr[5]/td[2]").shouldHave(Condition.text("22 May,1990"));
        $x("//tbody/tr[6]/td[2]").shouldHave(Condition.text("Maths"));
        $x("//tbody/tr[7]/td[2]").shouldHave(Condition.text("Sports"));
        $x("//tbody/tr[8]/td[2]").shouldHave(Condition.text("testpicture.jpeg"));
        $x("//tbody/tr[9]/td[2]").shouldHave(Condition.text("some address"));
        $x("//tbody/tr[10]/td[2]").shouldHave(Condition.text("NCR Delhi"));


    }
}
