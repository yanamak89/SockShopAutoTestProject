package payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.restassured.response.Validatable;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.processing.Generated;

@Getter
@Setter
@Accessors(fluent = true)
@Generated("com.robohorse.robopojogenerator")
public class AddressesPayload {

    @JsonProperty("number")
    private String number;

    @JsonProperty("country")
    private String country;

    @JsonProperty("city")
    private String city;

    @JsonProperty("street")
    private String street;

    @JsonProperty("postcode")
    private String postcode;

    @JsonProperty("userID")
    private String userID;


}
