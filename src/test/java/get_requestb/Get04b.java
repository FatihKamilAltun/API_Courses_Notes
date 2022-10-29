package get_requestb;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get04b extends RestfulBaseUrl {
     /*
    Given
        https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
    When
        User sends get request to the URL
    Then
        Status code is 200
    And
    Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"
    */

    @Test
    public void get01() {
        spec.pathParam("first","booking").queryParams("firstname","Almedin","lastname","Alikadic");
        Response response=given().spec(spec).get("/{first}");
        response.prettyPrint();

        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));


    }
}
