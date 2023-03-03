package com.browserstack.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;


public class AgencyHubPage {

    private static AgencyHubLocators AgencyHub = new AgencyHubLocators();
    public static AgencyHubPage agencyhpage(){
        return page(AgencyHubPage.class);
    }
    @Step("Единственное действие")
    public AgencyHubPage JoinWaitListButton(){
        $(By.xpath("/html/body/div/form/div[2]/div[2]/input")).click();
        return this;
    }
    @Step("Вводим мейл")
    public AgencyHubPage EnterEmail(String mail){
        sleep(10000);
        $(By.name("email")).click();
        $(By.name("email")).setValue(mail);
        return this;
    }

    @Step("Чекаем interactible")
    public AgencyHubPage CheckInteractible(){
        $(By.name("email")).shouldNotBe(Condition.interactable).hover();
        return this;
    }

    @Step("Чекаем картинку")
    public AgencyHubPage CheckImageOnAgencyHub(){
        $(By.xpath("/html/body/div[2]/section/div[1]/div/img")).shouldBe(Condition.visible);
        return this;
    }
    @Step("Сверяем тайтл страницы AgencyHub")
    public AgencyHubPage AgencyHubTitleCheck(String AgencyHubTitleToCheck){
        AgencyHub.AgencyHubPageTitle.shouldHave(Condition.ownText(AgencyHubTitleToCheck));
        return this;
    }

    @Step("Вводим email")
    public AgencyHubPage AgencyHubEmail(String email){
        List<SelenideElement> list = $$x("//iframe[contains(@title, 'Form')]");
        switchTo().frame(list.get(0));
        $x("//input[@type='email']").setValue(email);
        return this;
    }

    @Step("Жмём кнопку 'Join Waitlist")
    public AgencyHubPage JoinWaitlistButton(){
        List<SelenideElement> list = $$x("//iframe[contains(@title, 'Form')]");
        switchTo().frame(list.get(0));
        $x("//input[@type='submit']").click();
        return this;
    }
}
