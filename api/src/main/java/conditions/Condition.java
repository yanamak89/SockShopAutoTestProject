package conditions;

import io.restassured.response.Response;

public interface Condition {
    public void check(Response response);
}
