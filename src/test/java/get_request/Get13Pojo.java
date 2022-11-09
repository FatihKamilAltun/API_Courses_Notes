package get_request;

import base_url.GorestBaseUrl;
import org.junit.Test;

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
        spec.pathParams("first","users","second","2508");

        // Set the expected data


        // Send the request and get the response

        // Do assertion





    }
}
