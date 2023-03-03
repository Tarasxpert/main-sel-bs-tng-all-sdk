package com.browserstack.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPageLocators {
    public SelenideElement MainPageTitle = $(By.cssSelector("head > title"));
    public SelenideElement SolutionsDropdownMenu = $(By.cssSelector("#w-dropdown-toggle-0 > div > span"));
    public SelenideElement AgencyHub = $(By.xpath("//*[@id=\"w-dropdown-list-0\"]/div/div[1]/div/ul/li[1]/a/div/div[1]"));

}
