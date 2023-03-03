package com.browserstack.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class CloudcampaignCRMDashboardPage {
    private final SelenideElement dashboardButton = $x("//div[@id = \"controls_dashboard\"]");
    private final SelenideElement userAccountNameButton = $x("//span[@class=\"inverse\"]");
//    private final SelenideElement userRoleText = $x("//form[@id=\"user_settings_section\"]/table/tbody/tr[3]/td[2]/span");
    private final ElementsCollection userDropdownMenuButton = $$x("//ul[@id = \"user_settings_menu\"]");
    private final ElementsCollection userInfoList = $$x("//form[@id=\"user_settings_section\"]/table/tbody/tr");



    public boolean isDisplayedDashboardButton() {
       return dashboardButton.isDisplayed();
    }

    public void clickUserAccountNameButton() {
        userAccountNameButton.click();
    }

    public void clickToAccountSettingsButton() {
        userDropdownMenuButton.findBy(Condition.text("Account Settings")).click();
    }

//    public String getTextFromUserRoleText() {
//        return userRoleText.getText();
//    }

    public String getRole() {
        return userInfoList.findBy(Condition.text("admin")).getText();
    }
}