package org.skan.pages;

import com.codeborne.selenide.SelenideElement;
import org.skan.pages.components.CalendarComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    private CalendarComponent calendarComponent=new CalendarComponent();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderElement = $("#genterWrapper"),
            phoneInput = $("#userNumber");

    public RegistrationFormPage openPage (){
        open("/automation-practice-form");
        return this;
    }

    public RegistrationFormPage setFirstName(String name){
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationFormPage setLastName(String name){
        lastNameInput.setValue(name);
        return this;
    }

    public RegistrationFormPage setEmail(String email){
        emailInput.setValue(email);
        return this;
    }

    public RegistrationFormPage setGender(String value){
        genderElement.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setPhone(String value){
        phoneInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day,month,year);
        return this;
    }
}
