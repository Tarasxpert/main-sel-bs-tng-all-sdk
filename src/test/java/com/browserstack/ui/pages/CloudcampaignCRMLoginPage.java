package com.browserstack.ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CloudcampaignCRMLoginPage {
    private final SelenideElement emailField = $x("//*[@id=\"email\"]");
    private final SelenideElement incorrectEmailField = $x("//*[@id=\"emailtest\"]");
    private final SelenideElement passwordField = $x("//*[@id=\"password_input\"]");
    private final SelenideElement loginButton = $x("//*[@id=\"signup_button_text\"]");

    public void inputEmail(String email) {
        emailField.setValue(email);
    }

    public void inputPassword(String password) {
        passwordField.setValue(password);
    }

    public void clickLoginButtton() {
        loginButton.click();
    }

    public void inputIncorrectEmailField(String email) {
        incorrectEmailField.setValue(email);
    }
}