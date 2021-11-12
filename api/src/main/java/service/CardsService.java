package service;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import payload.CardsPayload;

@Slf4j
public class CardsService extends ApiService{

    @Step
    public Response addACard(CardsPayload cardsPayload) {
        return setup()
                .body(cardsPayload)
                .when()
                .post("/cards");
    }

}
