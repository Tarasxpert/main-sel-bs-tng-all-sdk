package com.browserstack;

import com.browserstack.Pages.MainPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
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

import static com.codeborne.selenide.Selenide.*;

public class cloudcampaignPagesTest extends BrowserStackTest {

	@BeforeMethod
	public void SetUp() {
		Configuration.baseUrl = "https://www.cloudcampaign.com/";
		Configuration.reportsFolder = "${project.build.directory}/allure-results";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
	}

	@Test(description="Этот тест (для примера) пропускаем", enabled = false)
	@Owner("Taras Zelenskyi")
	@Description("Поиск Логотипа на главной странице с ЗАВЕДОМО ложным (неполным) Xpath. Тест неминуемо упадёт.")
	public void FakeTest() throws Exception {

		open("/");
		//sleep(2000);
		String selectedProduct = $(By.xpath("//*[@id=\"1\"]/p")).text();
		$(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/a/img")).shouldNotBe(Condition.hidden);
		//sleep(2000);
	}

	@Test(description="Ищем логотип на главной странице (с убитым в хлам Xpath)", enabled = false)
	@Owner("Taras Zelenskyi")
	@Description("Поиск Логотипа на главной странице с ЗАВЕДОМО ложным (неполным) Xpath. Тест неминуемо упадёт.")
	public void LogoIsDisplayedOnMainPage() throws Exception {

		open("/");
		//sleep(2000);
		String selectedProduct = $(By.xpath("//*[@id=\"1\"]/p")).text();
		$(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/a/img")).shouldNotBe(Condition.hidden);
		//sleep(2000);
	}


	@Test(description = "Чекаем текст ошибки при сайнапе")
	@Owner("Taras Zelenskyi")
	@Description("Выполняется проверка текста ошибки при попытке использования существующих данных для SignUp")
	public void SignUpErrorTextTest() throws Exception {

		open("/", MainPage.class)
				.signup()
				.Fullfill("Taras","TestIT","+380972599655","test@testqa.com","Nopassnoproblems99")
				.Checkbox()
				.NextButton()
				.CheckIfTextHave("Error: It seems there is");
	}
}
