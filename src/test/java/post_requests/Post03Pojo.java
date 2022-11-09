package post_requests;

import base_url.JsonplaceholderBaseUrl;
import org.junit.Test;

public class Post03Pojo extends JsonplaceholderBaseUrl {
    /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post01() {
        // Set the url
        spec.pathParam("first","todos");

        // Set the expected data

        // Send the request and get the response

        // Do assertions

    }
}
