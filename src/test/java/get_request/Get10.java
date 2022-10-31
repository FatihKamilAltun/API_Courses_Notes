package get_request;

import base_url.GorestBaseUrl;
import base_url.RestfulBaseUrl;
import org.junit.Test;

public class Get10 extends GorestBaseUrl {
    /*
   Given
       https://gorest.co.in/public/v1/users/2986
   When
       User send GET Request to the URL
   Then
       Status Code should be 200
   And
       Response body should be like
    {
   "meta": null,
    "data": {
        "id": 2986,
        "name": "Navin Talwar",
        "email": "navin_talwar@mclaughlin.name",
        "gender": "male",
        "status": "inactive"
            }
     }
*/

    @Test
    public void get10() {
        spec.pathParams("first", "users", "second", 2986);
    }
}
