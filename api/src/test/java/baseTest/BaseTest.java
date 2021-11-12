package baseTest;

import config.ProjectConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.singletonMap;
import static org.aeonbits.owner.ConfigFactory.getProperty;

public class BaseTest {

    private static final String ENV_VARIABLE_KEY = "env";

    @BeforeAll
    static void setUp() {
        ProjectConfig config = ConfigFactory.create
                (ProjectConfig.class, singletonMap
                        (ENV_VARIABLE_KEY, getProperty(ENV_VARIABLE_KEY)));
        RestAssured.baseURI = config.host();
    }

}
