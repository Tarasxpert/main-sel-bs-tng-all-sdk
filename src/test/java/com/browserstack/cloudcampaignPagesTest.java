package com.browserstack;

import com.browserstack.Pages.AgencyHubLocators;
import com.browserstack.Pages.AgencyHubPage;
import com.browserstack.Pages.MainPage;
import com.browserstack.Pages.MainPageLocators;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.browserstack.Pages.MainPage.signup;
import static com.codeborne.selenide.Selenide.*;

public class cloudcampaignPagesTest extends BrowserStackTest {

	@BeforeMethod
	public void SetUp() {
		driver.manage().window().maximize();
		Configuration.baseUrl = "https://www.cloudcampaign.com/";
		Configuration.reportsFolder = "${project.build.directory}/allure-results";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
	}

	private MainPageLocators MainPage = new MainPageLocators();
	private AgencyHubLocators AgencyHub = new AgencyHubLocators();
	private MainPage Mainpage = new MainPage();
	private AgencyHubPage Agencyhubpage = new AgencyHubPage();

	@Test(description="Заполнение non-editable поля", enabled = true, priority = 3)
	@Owner("Taras Zelenskyi")
	@Description("Проверка заполнения поля с статусом non-editable")
	public void AgencyHubTest_email() throws Exception {

		String AgencyHubTitleToCheck = "AgencyHub | Your Agency, Organized";
		Mainpage.OpenPage();
		Mainpage.Solutions();
		Mainpage.OpenAgencyhubPage();
		//Agencyhubpage.AgencyHubEmail("test@test.com");
		Agencyhubpage.JoinWaitlistButton();
	}

	@Test(description="Проверка названия страницы AgencyHub при переходе с главной страницы", enabled = false, priority = 2)
	@Owner("Taras Zelenskyi")
	@Description("Проверка названия страницы Agency Hub / Переход с главной страницы через выпадающее меню Solutions")
	public void AgencyHubTest() throws Exception {

		String AgencyHubTitleToCheck = "AgencyHub | Your Agency, Organized";
		Mainpage.OpenPage();
		Mainpage.Solutions();
		Mainpage.OpenAgencyhubPage();
		Agencyhubpage.AgencyHubTitleCheck(AgencyHubTitleToCheck);
	}


	@Test(description="Сверяем название главной страницы", enabled = false, priority = 1)
	@Owner("Taras Zelenskyi")
	@Description("Сверяем название сайта (Должно быть: \"{Title_to_check}\".")
	public void MainPageTitle() throws Exception {
		String Title_to_check = "White-label social media management for agencies | Cloud Campaign";
		Mainpage.OpenPage();
		Mainpage.CheckTitle(Title_to_check);
	}


	@Test(description = "Чекаем текст ошибки при сайнапе", enabled = false, priority = 0)
	@Owner("Taras Zelenskyi")
	@Description("Выполняется проверка текста ошибки при попытке использования существующих данных для SignUp")
	public void SignUpErrorTextTest() throws Exception {

		Mainpage.OpenPage();
				signup()
				.Fullfill("Taras","TestIT","+380972599655","test@testqa.com","Nopassnoproblems99")
				.Checkbox()
				.NextButton()
				.CheckIfTextHave("Error: It seems there is");
	}
}
