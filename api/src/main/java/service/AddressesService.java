package service;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import payload.AddressesPayload;
import payload.CardsPayload;

@Slf4j
public class AddressesService extends ApiService{

    @Step
    public Response addingNewUserAddress(AddressesPayload addressesPayload) {
        return setup()
                .body(addressesPayload)
                .when()
                .post("/addresses");
    }


}
