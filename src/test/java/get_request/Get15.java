package get_request;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get15 extends RestfulBaseUrl {
    /*
        Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
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
                }
     */

    @Test
    public void get01() {
        // Set the url
        spec.pathParams("first", "booking", "second", 22);

        // Set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2013-02-23", "2014-10-23");
        BookingPojo expectedData = new BookingPojo("Sally", "Brown", 111, true, bookingDatesPojo, "Breakfast");

        // Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do assertion
        BookingPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), BookingPojo.class);

        // Soft assertion
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualData.getFirstname(), expectedData.getFirstname(),"Firstname uyusmadi");
        softAssert.assertEquals(actualData.getLastname(), expectedData.getLastname(),"Lastname uyusmadi");
        softAssert.assertEquals(actualData.getTotalprice(), expectedData.getTotalprice(),"Totalprice uyusmadi");
        softAssert.assertEquals(actualData.getDepositpaid(), expectedData.getDepositpaid(),"Depositpaid uyusmadi");
        softAssert.assertEquals(actualData.getAdditionalneeds(), expectedData.getAdditionalneeds(),"Additionalneeds uyusmadi");
        softAssert.assertEquals(actualData.getBookingdates().getCheckin(), bookingDatesPojo.getCheckin(),"Checkin uyusmadi");
        softAssert.assertEquals(actualData.getBookingdates().getCheckout(), bookingDatesPojo.getCheckout(),"Checkout uyusmadi");
        softAssert.assertAll();

        // Hard assertion
        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.getFirstname(),actualData.getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expectedData.getAdditionalneeds(),actualData.getAdditionalneeds());
        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBookingdates().getCheckout());



    }
}
