package com.browserstack.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.http.ContentType;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ReqresTest {
    private final static String url = "https://reqres.in/";

    @Test
    public void checkAvatarAndIdTest(){
        List<UserData> users = given().filter(new AllureRestAssured())
                .when()
                .contentType(ContentType.JSON)
                .get(url+"api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        //users.forEach(x-> AssertJUnit.assertTrue(x.getAvatar().contains(x.getId().toString())));

        //AssertJUnit.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("@reqres.in")));

        List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
        List<String> ids = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());

        for (int i = 0; i< avatars.size(); i++){
            AssertJUnit.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }
}