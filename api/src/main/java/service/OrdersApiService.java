package service;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class OrdersApiService extends ApiService{

    @Step
    public Response getUserOrders(){
        return setup()
                .cookie("logged_in", "=8ohYmW_gYcRs9m4J1ekVAi3aLd3ZfhH1")
                .get("/orders");
    }
}
