package get_request;

import base_url.GorestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13Pojo extends GorestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
                      {
                "meta": null,
                "data": {
                    "id": 2508,
                    "name": "Rajinder Acharya",
                    "email": "rajinder_acharya@mosciski.net",
                    "gender": "female",
                    "status": "active"
                }
            }
    */

    @Test
    public void get01() {
        // Set the url
        spec.pathParams("first", "users", "second", 2508);

        // Set the expected data
        GoRestDataPojo goRestDataPojo = new GoRestDataPojo(2508, "Rajinder Acharya", "rajinder_acharya@mosciski.net", "female", "active");
        GoRestPojo expectedData = new GoRestPojo(null, goRestDataPojo);

        // Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do assertion
        GoRestPojo actualData = response.as(GoRestPojo.class);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getMeta(),actualData.getMeta());
        assertEquals(expectedData.getData().getId(),actualData.getData().getId());
        assertEquals(expectedData.getData().getName(),actualData.getData().getName());
        assertEquals(expectedData.getData().getEmail(),actualData.getData().getEmail());
        assertEquals(expectedData.getData().getGender(),actualData.getData().getGender());
        assertEquals(expectedData.getData().getStatus(),actualData.getData().getStatus());



    }
}
