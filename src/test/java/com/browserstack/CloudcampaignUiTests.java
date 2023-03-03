package com.browserstack;

import com.browserstack.pages.CloudcampaignCRMDashboardPage;
import com.browserstack.pages.CloudcampaignCRMLoginPage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class CloudcampaignUiTests extends BrowserStackTest {
    private final static String EMAIL = "tzelenskyi@cloudcampaign.com";
    private final static String PASSWORD = "19E*r3cq";

    @BeforeMethod
	public void SetUp() {
        Configuration.baseUrl = "https://app.qa.cloudcampaign.com";
        Configuration.reportsFolder = "target/allure-results";
        driver.manage().window().maximize();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Test(description= "Login test in https://app.qa.cloudcampaign.com/login", enabled = false)
    @Owner("Taras Zelenskyi")
    @Description("No")
    public void loginTest() throws Exception {
        open("/");
        CloudcampaignCRMLoginPage cloudcampaignCRMLoginPage = new CloudcampaignCRMLoginPage();
        cloudcampaignCRMLoginPage.inputEmail(EMAIL);
        cloudcampaignCRMLoginPage.inputPassword(PASSWORD);
        cloudcampaignCRMLoginPage.clickLoginButtton();
        CloudcampaignCRMDashboardPage cloudcampaignCRMDashboardPage = new CloudcampaignCRMDashboardPage();
        Assert.assertTrue(cloudcampaignCRMDashboardPage.isDisplayedDashboardButton());
    }

    @Test(description= "Login test in https://app.qa.cloudcampaign.com/login", enabled = false)
    @Owner("Taras Zelenskyi")
    @Description("No")
    public void loginTest2() throws Exception {
        open("/");
        CloudcampaignCRMLoginPage cloudcampaignCRMLoginPage = new CloudcampaignCRMLoginPage();
        cloudcampaignCRMLoginPage.clickEmailButtton1();   }


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
        Assert.assertEquals(cloudcampaignCRMDashboardPage.getRole(), "admin");
    }
}