package com.browserstack.ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class CloudcampaignCRMDashboardPage {
    private final SelenideElement dashboardButton = $x("//div[@id = \"controls_dashboard\"]");
    private final SelenideElement userAccountNameButton = $x("//span[@class=\"inverse\"]");
    private final ElementsCollection userDropdownMenuButton = $$x("//ul[@id = \"user_settings_menu\"]" +
            "/li/a");
    private final ElementsCollection userInfoList = $$x("//form[@id=\"user_settings_section\"]" +
            "/table/tbody/tr");


    public boolean isDisplayedDashboardButton() {
        return dashboardButton.isDisplayed();
    }

    public void clickUserAccountNameButton() {
        userAccountNameButton.click();
    }

    public void clickToAccountSettingsButton() {
        userDropdownMenuButton.findBy(text("Account Settings")).click();
    }

    public String getTextFromUserRoleText() {
        return userInfoList.findBy(text("admin")).getText();
    }
}