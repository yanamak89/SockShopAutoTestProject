package cardsTests;

import baseTest.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import payload.CardsPayload;
import service.CardsService;

public class CardsTests {

    public final CardsService cardsService = new CardsService();

    @BeforeMethod
    static void setUp() {
        RestAssured.baseURI = "http://localhost:80";
    }

    @Test
    public void testUserCanAddCard(){
        //given
        CardsPayload cardsPayload = new CardsPayload()
                .expires("12.2022")
                .longNum("1234 1234 1234 1234")
                .ccv("123")
                .userID("UserID");

        //expect
        cardsService.addACard(cardsPayload)

                .then()
                .body("id", Matchers.not(Matchers.isEmptyString()));
    }
}
