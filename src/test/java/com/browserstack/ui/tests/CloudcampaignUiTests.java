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

    @Test(description= "Login test in https://app.qa.cloudcampaign.com", priority = 1)
    @Owner("Taras Zelenskyi")
    @Description("Logging in to CRM using existing credentials and checking if dashboard is displayed and visible.")
    public void loginTest() {
        CloudcampaignCRMLoginPage cloudcampaignCRMLoginPage = new CloudcampaignCRMLoginPage();
        cloudcampaignCRMLoginPage.openPage();
        cloudcampaignCRMLoginPage.inputEmail(EMAIL);
        cloudcampaignCRMLoginPage.inputPassword(PASSWORD);
        cloudcampaignCRMLoginPage.clickLoginButtton();
        CloudcampaignCRMDashboardPage cloudcampaignCRMDashboardPage = new CloudcampaignCRMDashboardPage();
        assertTrue(cloudcampaignCRMDashboardPage.isDisplayedDashboardButton());
    }

    @Test(description= "Login test in https://app.qa.cloudcampaign.com", priority = 0)
    @Owner("Taras Zelenskyi")
    @Description("Trying to log in to CRM using existing credentials," +
            "but trying to input an email to an unexisting field ('emailtest'). This will lead us to TestFail")
    public void incorrectLoginTest() {
        CloudcampaignCRMLoginPage cloudcampaignCRMLoginPage = new CloudcampaignCRMLoginPage();
        cloudcampaignCRMLoginPage.openPage();
        cloudcampaignCRMLoginPage.inputIncorrectEmailField(EMAIL);
    }

    @Test(description = "Checking if our account role is admin", priority = 1)
    @Owner("Taras Zelenskyi")
    @Description("Logging in to CRM using existing credentials and checking if our account role is admin")
    public void checkAdminUserRoleTest() {
        CloudcampaignCRMLoginPage cloudcampaignCRMLoginPage = new CloudcampaignCRMLoginPage();
        cloudcampaignCRMLoginPage.openPage();
        cloudcampaignCRMLoginPage.inputEmail(EMAIL);
        cloudcampaignCRMLoginPage.inputPassword(PASSWORD);
        cloudcampaignCRMLoginPage.clickLoginButtton();
        CloudcampaignCRMDashboardPage cloudcampaignCRMDashboardPage = new CloudcampaignCRMDashboardPage();
        cloudcampaignCRMDashboardPage.clickUserAccountNameButton();
        cloudcampaignCRMDashboardPage.clickToAccountSettingsButton();
        assertEquals(cloudcampaignCRMDashboardPage.getTextFromUserRoleText(), "Role: admin");
    }
}