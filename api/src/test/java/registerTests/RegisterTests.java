package registerTests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RegisterTests {

    @Test
    public void registerNewUser(){
        given().spec(new RequestSpecBuilder()
                    .log(LogDetail.ALL)
                    .build())
                .body("{\"username\":\"test\"," +
                        "\"password\":\"12345\"," +
                        "\"email\":\"_test\"," +
                        "\"firstName\":\"test\"," +
                        "\"lastName\":\"test\"}")
        .when()
                .post("http://localhost/register")
        .then().spec(new ResponseSpecBuilder()
                .log(LogDetail.ALL).build())
                .assertThat().statusCode(200);



    }
}
