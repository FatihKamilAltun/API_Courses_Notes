package get_request;

import base_url.GorestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get11 extends GorestBaseUrl {
    /*
    Given
        https://gorest.co.in/public/v1/users
    When
        User send GET Request
    Then
        The value of "pagination limit" is 10
    And
        The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
    And
        The number of users should  be 10
    And
        We have at least one "active" status
    And
        Fr. Paramartha Bandopadhyay, Pres. Amarnath Dhawan and Sujata Chaturvedi are among the users
    And
        The female users are less than or equals to male users
 */

    @Test
    public void test01() {

        spec.pathParam("first", "users");

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                body("meta.pagination.limit", equalTo(10),
                        "meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data", hasSize(10),
                        "data.status", hasItem("active"),
                        "data.name", hasItems("Miss Karan Varma", "Prasad Butt", "Girish Gill II"));

        // Kadın ve erkek sayılarını karşılaştırma
        // 1. Yol
        List<String> genders = response.jsonPath().getList("data.gender");
        int numFemale = 0;
        for (String w : genders
        ) {
            if (w.equalsIgnoreCase("female")) {
                numFemale++;
            }
        }
        assertTrue(numFemale <= genders.size() - numFemale);

        // 2. Yol
        List<String> femaleNames = response.jsonPath().getList("data.findAll{it.gender=='female'}.name");
        System.out.println("Female names : " + femaleNames);


        List<String> maleNames = response.jsonPath().getList("data.findAll{it.gender=='male'}.name");
        System.out.println("Male names : " + maleNames);

        assertTrue(femaleNames.size()<=maleNames.size());
    }
}
