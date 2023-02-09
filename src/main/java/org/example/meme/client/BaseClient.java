package org.example.meme.client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.meme.constant.Props;

public abstract class BaseClient {
    static RequestSpecification settings;

    static {
        settings = new RequestSpecBuilder()
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .setBaseUri(Props.ENVIRONMENT)
                .build();

        RestAssured.requestSpecification = settings;
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}
