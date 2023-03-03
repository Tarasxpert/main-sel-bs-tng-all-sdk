package com.browserstack.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AgencyHubLocators {

    public SelenideElement AgencyHubPageTitle = $(By.cssSelector("head > title"));
}
