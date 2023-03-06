package com.browserstack.api.tests.reqres;

import com.browserstack.api.base.Specifications;
import com.browserstack.api.data.reqres.UserData;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.restassured.AllureRestAssured;
import org.testng.annotations.Test;

import java.util.List;

import static com.browserstack.api.base.Specifications.requestSpecification;
import static com.browserstack.api.base.Specifications.responseSuccessfulSpecification;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class APIsimpleTest {
    private final static String URL = "https://reqres.in/";

    @Test(description = "Checking user emails endings ('@reqres.in' -> expected '@reqres.in')", priority = 1)
    @Owner("Taras Zelenskyi")
    @Description("Checking that every users email ends with '@reqres.in'. Test will pass.")
    public void checkEmailEnding() {
        Specifications.installSpecification(requestSpecification(URL), responseSuccessfulSpecification());
        List<UserData> users = given()
                .filter(new AllureRestAssured())
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        users.forEach(x -> assertTrue(x.getAvatar().contains(x.getId().toString())));
        assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));
    }

    @Test(description = "Checking user emails endings ('@gmail.com' -> expected '@reqres.in')", priority = 0)
    @Owner("Taras Zelenskyi")
    @Description("Checking that every users email ends with '@gmail.com'. Test will fail.")
    public void checkEmailEndingFailing() {
        Specifications.installSpecification(requestSpecification(URL), responseSuccessfulSpecification());
        List<UserData> users = given()
                .filter(new AllureRestAssured())
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        users.forEach(x -> assertTrue(x.getAvatar().contains(x.getId().toString())));
        assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@gmail.com")));
    }
}
