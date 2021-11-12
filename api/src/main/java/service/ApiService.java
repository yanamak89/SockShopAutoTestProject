package service;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiService {

    //Token in the separate variable


    public RequestSpecification setup() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());
    }

    public String login(){
        //auth logic
        return "token";
    }
}
