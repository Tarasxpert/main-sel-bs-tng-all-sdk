package com.browserstack.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class CloudcampaignCRMLoginPage {
    private final SelenideElement emailField = $x("//*[@id=\"email\"]");
    private final SelenideElement incorrectEmailField = $x("//*[@id=\"emailtest\"]");
    private final SelenideElement passwordField = $x("//*[@id=\"password_input\"]");
    private final SelenideElement loginButton = $x("//*[@id=\"signup_button_text\"]");

    @Step("Open login page")
    public void openPage() {open("/");}

    @Step("Typing in (correct) email")
    public void inputEmail(String email) {
        emailField.setValue(email);
    }

    @Step("Typing in password")
    public void inputPassword(String password) {
        passwordField.setValue(password);
    }

    @Step("Clicking 'Login button'")
    public void clickLoginButtton() {
        loginButton.click();
    }

    @Step("Typing in (correct) email to an unexisting field ('emailtest' instead of 'email')")
    public void inputIncorrectEmailField(String email) {
        incorrectEmailField.setValue(email);
    }
}