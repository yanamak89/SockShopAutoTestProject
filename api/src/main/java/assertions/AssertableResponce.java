package assertions;

import conditions.Condition;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class AssertableResponce {

    private final Response response;

    public AssertableResponce shouldHave(Condition condition){
        log.info("About to check condition[{}]", condition);
        condition.check(response);
        return this;
    }

    /**
     * To get ID
     * @param jsonPath
     * @return
     */
    public String getValue(String jsonPath){
        return response.jsonPath().getString(jsonPath);
    }

    public <T> T asPojo(Class<T> tClass){
        return response.as(tClass);
    }
}
