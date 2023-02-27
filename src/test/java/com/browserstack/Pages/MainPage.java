package com.browserstack.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import com.browserstack.cloudcampaignPagesTest;

import static com.codeborne.selenide.Selenide.*;


public class MainPage {
    private static MainPageLocators MainPage = new MainPageLocators();

    @Step("Открываем страницу SignUp")
    public static SignUpPage signup(){
        //open("/");
        $(By.cssSelector("body > div.header.w-nav > div.header-container.w-container > div.header-wrapper > div.split-content.header-left > a:nth-child(2)")).pressEnter();
        return page(SignUpPage.class);
    }
    @Step("Открываем главную страницу")
    public MainPage OpenPage(){
        open("/");
        return this;
    }

    @Step("Сверяем название Тайтла")
    public MainPage CheckTitle(String Title_to_check){
        MainPage.MainPageTitle.shouldHave(Condition.ownText(Title_to_check));
        return this;
    }

    @Step("Раскрываем вкладку 'Solutions' на главной странице")
    public MainPage Solutions(){
        MainPage.SolutionsDropdownMenu.hover();
        return this;
    }

    @Step("Кликаем по 'Agency Hub' в 'Solutions'")
    public AgencyHubPage OpenAgencyhubPage(){
        MainPage.AgencyHub.hover().click();
        return page(AgencyHubPage.class);
    }
}
