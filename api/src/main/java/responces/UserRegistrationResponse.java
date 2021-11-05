package responces;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class UserRegistrationResponse {
    @JsonProperty
    private String id;

}

