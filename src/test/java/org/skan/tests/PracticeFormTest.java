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
                .setBirthDate("22", "May","1990")
                .setSubject("Maths")
                .chooseHobbies("Sports")
                .uploadImage("src/test/resources/testpicture.jpeg")
                .setAddress("some address")
                .selectState("NCR")
                .selectCity("Delhi")
                .checkResultsTableVisible()
                .checkResult("Student Name", "Sergey Kan")
                .checkResult("Student Email", "Sergey@google.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "7123477777")
                .checkResult("Date of Birth", "22 May,1990")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "testpicture.jpeg")
                .checkResult("Address", "some address")
                .checkResult("State and City", "NCR Delhi");

    }
}
