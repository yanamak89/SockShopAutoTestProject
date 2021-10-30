package registerTests;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payload.UserPayload;

public class RegisterTests {

    @BeforeClass
    static void setUp(){
        RestAssured.baseURI = "http://localhost:80";

    }

    @Test
    public void testCanRegisterNewUserWithValidCredentials() {
        //given
        UserPayload userPayload = new UserPayload()
                .username(RandomStringUtils.randomAlphabetic(6))
                .password("12345")
                .email("demo@email.com");

        //expect
        registerNewUser(userPayload)
                .then()
                .body("id", Matchers.not(Matchers.isEmptyString()));

    }

    @Test
    public void testCanNotCreateSameUserTwice(){
        //given
        UserPayload userPayload = new UserPayload()
                .username(RandomStringUtils.randomAlphabetic(6))
                .password("12345")
                .email("demo@email.com");

        //when
        registerNewUser(userPayload)
                .then()
                .body("id", Matchers.not(Matchers.isEmptyString()));

        //then
        registerNewUser(userPayload)
                .then().statusCode(500);

    }

    private RequestSpecification setup(){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
    private Response registerNewUser(UserPayload userPayload){
        return setup()
                .body(userPayload)
                .when()
                .post("/register");
    }
}
