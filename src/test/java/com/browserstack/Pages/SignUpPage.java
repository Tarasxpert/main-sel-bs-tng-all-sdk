package com.browserstack.Pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SignUpPage {
    @Step("Заполняем форму")
    public SignUpPage Fullfill (String name, String company, String phone, String email, String password){
        $(By.name("fullname")).setValue(name);
        $(By.name("company")).setValue(company);
        $(By.name("phone")).setValue(phone);
        $(By.name("email")).setValue(email);
        $(By.name("password")).setValue(password);
        return this;
    }
    @Step("Отмечаем чекбокс \"I accept...\"")
    public SignUpPage Checkbox(){
        $(By.cssSelector("#mainControllerContext > div.split-signup-page-content > table > tbody > tr:nth-child(1) > td.split-signup-page-content-primary > div > form > table > tbody > tr > td:nth-child(1) > input")).click();
        return this;
    }
    @Step("Жмём кпоку Next")
    public SignUpPage NextButton(){
        $(By.id("signup_register_next_button")).click();
        return this;
    }
    @Step("Проверяем, содержится ли в тексте строка \"{text}\"")
    public SignUpPage CheckIfTextHave(String text){
        $(By.id("error_text")).shouldHave(Condition.text(text));
        return this;
    }
}
