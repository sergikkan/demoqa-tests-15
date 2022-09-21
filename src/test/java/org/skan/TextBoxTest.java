package org.skan;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.holdBrowserOpen=true;
        Configuration.pageLoadTimeout=150000;
        Configuration.browserSize="1920x1080";
        //Configuration.timeout=60000;
    }

    @AfterAll
    static void tearDown(){

    }

    @Test
    void fillFormTest(){
        open("/text-box");
        $("#userName").setValue("Sergey");
        $("#userEmail").setValue("Sergey@google.com");
        $("#currentAddress").setValue("Adress1");
        $("#permanentAddress").setValue("Adress24");
        $("#submit").click();

        $("#output #name").shouldHave(Condition.text("Sergey"));
        $("#output #email").shouldHave(Condition.text("Sergey@google.com"));
        $("#output #currentAddress").shouldHave(Condition.text("Adress1"));
        $("#output #permanentAddress").shouldHave(Condition.text("Adress24"));


    }
}
