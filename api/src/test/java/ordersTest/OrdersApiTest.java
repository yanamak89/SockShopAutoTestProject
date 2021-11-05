package ordersTest;

import baseTest.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import service.OrdersApiService;

public class OrdersApiTest{

    private final OrdersApiService ordersApiService = new OrdersApiService();

    @BeforeClass
    static void setUp() {
        RestAssured.baseURI = "http://localhost:80";
    }

    @Test
    void testCanGetUserOrders(){
        ordersApiService.getUserOrders()
                .then().assertThat().statusCode(201);

    }


}
