package org.skan.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement genderElement = $("#genterWrapper");
    SelenideElement phoneInput = $("#userNumber");
    //SelenideElement firstNameInput = $("#firstName");
    public void openPage (){
        open("/automation-practice-form");

    }

    public void setFirstName(String name){
        firstNameInput.setValue(name);
    }

    public void setLastName(String name){
        lastNameInput.setValue(name);
    }

    public void setEmail(String email){
        emailInput.setValue(email);
    }

    public void setGender(String value){
        genderElement.$(byText(value)).click();
    }

    public void setPhone(String value){
        phoneInput.setValue(value);
    }

    public void setDateOfBirth(String name){
        $("#firstName").setValue(name);
    }
}
