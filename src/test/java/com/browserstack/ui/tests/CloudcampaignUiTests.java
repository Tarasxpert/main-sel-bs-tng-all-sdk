package com.browserstack.ui.tests;

import com.browserstack.ui.base.BrowserStackDriver;
import com.browserstack.ui.pages.CloudcampaignCRMDashboardPage;
import com.browserstack.ui.pages.CloudcampaignCRMLoginPage;
import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CloudcampaignUiTests extends BrowserStackDriver {
    private final static String EMAIL = "tzelenskyi@cloudcampaign.com";
    private final static String PASSWORD = "19E*r3cq";

    @BeforeMethod
	public void SetUp() {
        Configuration.baseUrl = "https://app.qa.cloudcampaign.com";
        Configuration.reportsFolder = "target/allure-results";
        driver.manage().window().maximize();
        addListener("AllureSelenide", new AllureSelenide());
    }

    @Test(description= "Login test in https://app.qa.cloudcampaign.com/login")
    @Owner("Taras Zelenskyi")
    @Description("No")
    public void loginTest() {
        open("/");
        CloudcampaignCRMLoginPage cloudcampaignCRMLoginPage = new CloudcampaignCRMLoginPage();
        cloudcampaignCRMLoginPage.inputEmail(EMAIL);
        cloudcampaignCRMLoginPage.inputPassword(PASSWORD);
        cloudcampaignCRMLoginPage.clickLoginButtton();
        CloudcampaignCRMDashboardPage cloudcampaignCRMDashboardPage = new CloudcampaignCRMDashboardPage();
        assertTrue(cloudcampaignCRMDashboardPage.isDisplayedDashboardButton());
    }

    @Test(description= "Login test in https://app.qa.cloudcampaign.com/login")
    @Owner("Taras Zelenskyi")
    @Description("не валидный")
    public void incorrectLoginTest() {
        open("/");
        CloudcampaignCRMLoginPage cloudcampaignCRMLoginPage = new CloudcampaignCRMLoginPage();
        cloudcampaignCRMLoginPage.inputIncorrectEmailField(EMAIL);
    }

    @Test(description = "d", enabled = true)
    @Owner("")
    @Description("d")
    public void checkAdminUserRoleTest() {
        open("/");
        CloudcampaignCRMLoginPage cloudcampaignCRMLoginPage = new CloudcampaignCRMLoginPage();
        cloudcampaignCRMLoginPage.inputEmail(EMAIL);
        cloudcampaignCRMLoginPage.inputPassword(PASSWORD);
        cloudcampaignCRMLoginPage.clickLoginButtton();
        CloudcampaignCRMDashboardPage cloudcampaignCRMDashboardPage = new CloudcampaignCRMDashboardPage();
        cloudcampaignCRMDashboardPage.clickUserAccountNameButton();
        cloudcampaignCRMDashboardPage.clickToAccountSettingsButton();
        assertEquals(cloudcampaignCRMDashboardPage.getTextFromUserRoleText(), "Role: admin");
    }
}