package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

import static io.restassured.RestAssured.*;

public class Get09 extends RestfulBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/91
    When
        I send GET Request to the url
    Then
        Response body should be like that;
        {
    "firstname": "Sally",
    "lastname": "Brown",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2013-02-23",
        "checkout": "2014-10-23"
    },
    "additionalneeds": "Breakfast"
    */

    @Test
    public void get09() {

        spec.pathParams("first", "booking", "second", 91);

        Map<String, String> bookingDatesMaps = new HashMap<>();
        bookingDatesMaps.put("checkin", "2013-02-03");
        bookingDatesMaps.put("checkout", "2014-10-23");

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Sally");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingDatesMaps);
        expectedData.put("additionalneeds", "Breakfast");
        System.out.println(expectedData);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        SoftAssert softAssert = new SoftAssert();
        Map<String, Object> actualData = response.as(HashMap.class);
        softAssert.assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        softAssert.assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        softAssert.assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        softAssert.assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        softAssert.assertEquals(bookingDatesMaps.get("checkin"),((Map)(actualData.get("bookingdates"))).get("checkin"));
        softAssert.assertEquals(bookingDatesMaps.get("checkout"),((Map)(actualData.get("bookingdates"))).get("checkout"));
        softAssert.assertEquals(expectedData.get("additionalneeds"),actualData.get("additionalneeds"));


    }
}

