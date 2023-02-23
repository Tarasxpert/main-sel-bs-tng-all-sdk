package com.browserstack.Pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    public static SignUpPage signup(){
        //open("/");
        $(By.cssSelector("body > div.header.w-nav > div.header-container.w-container > div.header-wrapper > div.split-content.header-left > a:nth-child(2)")).pressEnter();
        return page(SignUpPage.class);
    }
}
