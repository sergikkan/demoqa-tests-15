package org.skan.pages;

import com.codeborne.selenide.SelenideElement;
import org.skan.pages.components.CalendarComponent;
import org.skan.pages.components.ResultsTableComponent;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private CalendarComponent calendarComponent=new CalendarComponent();
    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderElement = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            birthDateInput=$("#dateOfBirthInput"),
            subjectInput=$("#subjectsInput"),
            hobbiesElement=$("#hobbiesWrapper"),
            uploadInput = $("#uploadPicture"),
            addressInput=$("#currentAddress"),
            stateInput=$("#react-select-3-input"),
            cityInput=$("#react-select-4-input");

    public RegistrationFormPage openPage (){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
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
        birthDateInput.click();
        calendarComponent.setDate(day,month,year);
        return this;
    }

    public RegistrationFormPage setSubject(String value){
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationFormPage chooseHobbies(String value){
        hobbiesElement.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage uploadImage(String path){
        uploadInput.uploadFile(new File(path));
        return this;
    }

    public RegistrationFormPage setAddress(String value){
        addressInput.setValue(value);
        return this;
    }

    public RegistrationFormPage selectState(String value){
        stateInput.setValue(value).pressTab();
        return this;
    }

    public RegistrationFormPage selectCity(String value){
        cityInput.setValue(value).pressEnter().pressEnter();
        return this;
    }

    public RegistrationFormPage checkResultsTableVisible(){
        resultsTableComponent.checkVisible();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value){
        resultsTableComponent.checkResult(key, value);
        return this;
    }
}
