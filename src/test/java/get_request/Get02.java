package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {

    /* Given
    https://restful-booker.herokuapp.com/booking/1
    When
    User send a GET Request to the url
    Then
    HTTP Status code should be 404
    And
    Status Line should be HTTP/1.1 404 Not Found
    And
    Response body contains "Not Found"
    And
    Response body does not contain "TechProEd"
    And
    Server is "Cowboy"
            */

    @Test
    public void test01() {

        // i) set the URL
        String url = "https://restful-booker.herokuapp.com/booking/1";

        // ii) set the expected data (beklenen datanin olusturulmasi, --> post, put, petch <-- )
        // bizden post, put, petch birisi istenmedigi icin bu case'de kullanmayacagiz

        // iii) type code to send request (Talep gondermek icin kod yazimi)
        Response response = given().when().get(url);
        response.prettyPrint();

        // iv) do assertion (dogrulama yapmak)
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        assertTrue(response.asString().contains("Not Found")); // Body not found iceriyor mu testi yapildi
        assertFalse(response.asString().contains("TechProEd")); // Body techproed icermedigi test edildi
        assertEquals("Cowboy", response.getHeader("Server")); // serverin cowboy olup olmadigi test edilidi

    }
}
