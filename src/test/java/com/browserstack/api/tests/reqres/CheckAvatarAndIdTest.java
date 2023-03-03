package com.browserstack.api.tests.reqres;

import com.browserstack.api.base.Specifications;
import com.browserstack.api.data.reqres.UserData;
import io.qameta.allure.restassured.AllureRestAssured;
import org.testng.annotations.Test;

import java.util.List;

import static com.browserstack.api.base.Specifications.requestSpecification;
import static com.browserstack.api.base.Specifications.responseSuccessfulSpecification;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class CheckAvatarAndIdTest {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndEndingEmail() {
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
}
