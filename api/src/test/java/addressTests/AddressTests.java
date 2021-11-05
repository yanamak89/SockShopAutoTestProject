package addressTests;

import baseTest.BaseTest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import payload.AddressesPayload;
import service.AddressesService;

public class AddressTests extends BaseTest {

    public final AddressesService addressesService = new AddressesService();

    @BeforeMethod
    static void setUp(){
        RestAssured.baseURI = "http://localhost:80";
    }

    @Test
    public void testUserCanAddAddress(){

        //given
        AddressesPayload addressesPayload = new AddressesPayload()
                .street("Grzegorzecka")
                .number("1")
                .city("Krakow")
                .country("Poland")
                .postcode("01-112")
                //???? How to add here user ID that i get from Register test
                .userID("userID");

        //expect
        addressesService.addingNewUserAddress(addressesPayload)
                .then()
                .body("id", Matchers.not(Matchers.isEmptyString()));

    }

}
