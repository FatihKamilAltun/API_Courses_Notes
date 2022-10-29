package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get06b extends ReqresBaseUrl {
    /*
   Given
          https://reqres.in/api/unknown/
   When
        I send GET Request to the URL
   Then

        1)Status code is 200
        2)Print all pantone_values
        3)Print all ids greater than 3 on the console
          Assert that there are 3 ids greater than 3
        4)Print all names whose ids are less than 3 on the console
          Assert that the number of names whose ids are less than 3 is 2
*/

    @Test
    public void get01() {
        spec.pathParams("first", "api","second","unknown");

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        assertEquals(200,response.statusCode());
        JsonPath jsonPath=response.jsonPath();

        System.out.println(jsonPath.getList("data.pantone_value"));


    }
}
