package registerTests;

import baseTest.BaseTest;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ser.Serializers;
import io.restassured.RestAssured;
import lombok.Getter;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Tags;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.xml.dom.Tag;
import payload.UserPayload;
import responces.UserRegistrationResponse;
import service.UserApiService;

import static conditions.Conditions.bodyField;
import static conditions.Conditions.statusCode;
import static org.apache.http.HttpStatus.SC_INTERNAL_SERVER_ERROR;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.*;


public class RegisterTests {

    private final UserApiService userApiService = new UserApiService();

    @BeforeClass
    static void setUp() {
        RestAssured.baseURI = "http://localhost:80";
    }


    @Test
    public void testCanRegisterNewUserWithValidCredentials() {
        //given
        UserPayload userPayload = new UserPayload()
                .username(RandomStringUtils.randomAlphabetic(6))
                .password("12345")
                .email("demo@email.com");

        /**
         * Pojo - to get data from body and create separate class
         */
        //expect
        UserRegistrationResponse pojo = userApiService.registerNewUser(userPayload)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("id", not(Matchers.isEmptyString())))
                .asPojo(UserRegistrationResponse.class);
        assertThat(pojo.getId()).isNotEmpty();

        System.out.println("User id: " + pojo.getId());


    }

    @Test
    public void testCanNotCreateSameUserTwice() {
        //given
        UserPayload userPayload = new UserPayload()
                .username(RandomStringUtils.randomAlphabetic(6))
                .password("12345")
                .email("demo@email.com");

        /**
         * To get value as ID like string and Use it
         */
        //when
        String id = userApiService.registerNewUser(userPayload)
                .shouldHave(statusCode(200))
                .shouldHave(bodyField("id", not(Matchers.isEmptyString())))
                .getValue("id");
        System.out.println("User id: " + id);

        //then
        userApiService.registerNewUser(userPayload)
                .shouldHave(statusCode(SC_INTERNAL_SERVER_ERROR));

    }
}

