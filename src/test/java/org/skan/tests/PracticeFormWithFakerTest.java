package org.skan.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.skan.pages.RegistrationFormPage;

public class PracticeFormWithFakerTest extends TestBase {

    @Test
    void fillPracticeFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(day, month,year)
                .setSubject(subject)
                .chooseHobbies(hobbies)
                .uploadImage("src/test/resources/"+image)
                .setAddress(address)
                .selectState(state)
                .selectCity(city)
                .checkResultsTableVisible()
                .checkResult("Student Name", firstName+" "+lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", day+" "+month+","+year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", image)
                .checkResult("Address", address)
                .checkResult("State and City", state+" "+city);

    }
}
