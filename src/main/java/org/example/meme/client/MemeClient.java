package org.example.meme.client;

import io.restassured.response.ValidatableResponse;
import org.example.meme.dto.Meme;

import static io.restassured.RestAssured.given;

public class MemeClient extends BaseClient {
    private static final String MEME = "meme";

    public static ValidatableResponse getMemes() {
        return given()
                .when()
                .get(MEME)
                .then();
    }

    public static ValidatableResponse getMeme(int id) {
        return given()
                .when()
                .get(MEME + "/{id}", id)
                .then();
    }

    public static ValidatableResponse postMeme(Meme meme) {
        return given()
                .when()
                .body(meme)
                .post(MEME)
                .then();
    }

    public static ValidatableResponse putMeme(int id, Meme meme) {
        return given()
                .when()
                .body(meme)
                .put(MEME + "/{id}", id)
                .then();
    }

    public static ValidatableResponse deleteMeme(int id) {
        return given()
                .when()
                .delete(MEME + "/{id}", id)
                .then();
    }
}
