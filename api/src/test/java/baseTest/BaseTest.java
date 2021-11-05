package baseTest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeClass
    static void setUp() {
        RestAssured.baseURI = "http://localhost:80";
    }

}
