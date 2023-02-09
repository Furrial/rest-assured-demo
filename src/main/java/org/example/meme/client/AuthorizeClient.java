package org.example.meme.client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class AuthorizeClient extends BaseClient {

    private static final String AUTHORIZE = "/authorize";

    public static ValidatableResponse postAuthorization(String name) {
        return given()
                .when()
                .body("{\"name\": \"" + name + "\"}")
                .post(AUTHORIZE)
                .then();
    }


    public static ValidatableResponse getIsAlive(String token) {
        return given()
                .when()
                .get(AUTHORIZE + "/" + token)
                .then();
    }

    public static void authorize(String name) {
        String token = AuthorizeClient.postAuthorization(name)
                .statusCode(200).extract().body().jsonPath().getString("token");

        RequestSpecification authorized = new RequestSpecBuilder()
                .addRequestSpecification(settings) //not lost previously added spec
                .addHeader("Authorization", token)
                .build();

        RestAssured.requestSpecification = authorized;
    }
}
