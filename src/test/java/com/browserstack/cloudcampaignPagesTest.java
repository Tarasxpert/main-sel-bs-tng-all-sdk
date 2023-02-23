package com.browserstack;

import com.browserstack.Pages.MainPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class cloudcampaignPagesTest extends BrowserStackTest {

	@BeforeTest
	public void SetUp() {
		Configuration.baseUrl = "https://www.cloudcampaign.com/";
		SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
	}
	@Test
	@Owner("Taras Zelenskyi")
	@Description("Поиск Логотипа на главной странице с ЗАВЕДОМО ложным (неполным) Xpath. Тест неминуемо упадёт.")
	public void LogoIsDisplayedOnMainPage() throws Exception {

		open("/");
		sleep(2000);

		String selectedProduct = $(By.xpath("//*[@id=\"1\"]/p")).text();
		$(By.xpath("/html/body/div[1]/div[2]/div[2]/div[1]/a/img")).shouldNotBe(Condition.hidden);
		sleep(2000);

	}

	@Test
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
