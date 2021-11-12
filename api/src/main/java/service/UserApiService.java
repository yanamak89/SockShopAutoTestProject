package service;

import assertions.AssertableResponce;
import io.qameta.allure.Step;
import payload.UserPayload;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class UserApiService extends ApiService {

    @Step
    public AssertableResponce registerNewUser(UserPayload userPayload) {
        log.info("About to create new user {}", userPayload);

        Response response = setup()
                .body(userPayload)
                .when()
                .post("/register");
        return new AssertableResponce(response);
    }
}

