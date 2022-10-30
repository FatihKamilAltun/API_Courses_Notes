package get_request;

import base_url.AutomationExerciseBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class GetOdev extends AutomationExerciseBaseUrl {
    /*
Given
    https://automationexercise.com/api/productsList
When
    User sends a GET Request to the url
Then
    HTTP Status Code should be 200
And
    Content Type should be "text/html; charset=utf-8"
And
    Status Line should be HTTP/1.1 200 OK
And
     There must be 12 Women, 9 Men, 13 Kids usertype in products
  */

    @Test
    public void getOdev() {
        spec.pathParams("first", "api", "second", "productsList");
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        response.then().assertThat().
                statusCode(200).
                contentType("text/html; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");
        JsonPath jsonPath = response.jsonPath();
        List<String> list1 = jsonPath.getList("findAll{it.usertype==Women}.usertype");
        System.out.println(list1);
    }
}
