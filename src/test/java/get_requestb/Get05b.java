package get_requestb;

import base_url.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get05b extends ReqresBaseUrl {
     /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GEtT request o the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
        }
      */

    @Test
    public void get01() {
        spec.pathParams("first","api","second","unknown","third",3);
        Response response=given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        SoftAssert softAssert=new SoftAssert();
        JsonPath jsonPath=response.jsonPath();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        softAssert.assertEquals(response.statusCode(),200);
        softAssert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        softAssert.assertEquals(jsonPath.getInt("data.id"), 3,"Id degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("data.name"),"true red","Name degeri dogru degil");
        softAssert.assertEquals(jsonPath.getInt("data.year"),2002,"Year degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("data.color"),"#BF1932","Color degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("data.pantone_value"),"19-1664","Pantone degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("support.url"),"https://reqres.in/#support-heading","Url degeri dogru degil");
        softAssert.assertEquals(jsonPath.getString("support.text"),"To keep ReqRes free, contributions towards server costs are appreciated!","Text degeri dogru degil");
        softAssert.assertAll();

    }
}
