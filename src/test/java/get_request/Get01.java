package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    1-) Postman, manuel API testleri icin kullandik,
    2-) Otomasyon testleri icin de Rest Assured Library kullanacagiz
    3-) Otomasyon testlerimizi yaparken asagidaki adimlari izliyoruz
        a) Gereksinimleri anlamak
        b) Test Case yaziyoruz
            i) Test Case yaziminda Gherkin dilini kullanacagiz. Bizler yazilim diline hakim olsak da, karsimizdaki kisiler
            hakim olmayabilir ama Gherkin ile yazilan testleri anlamakta zorluk cekmeyeceklerdir.


            - Given  : On kosullar
            - When   : Yapilacak aksiyonlar icin ( get(), put(), post(), patch() ve delete() )
            - Then   : Istek yaptiktan (request gonderdikten sonra) dogrulama kisimlarinda
            - And    : Coklu islemlerde kullanacagiz

        c) Test kodlarimizi yazmaya baslayacagiz

            i) set the URL,
            ii) set the expected data (beklenen datanin olusturulmasi, --> post, put, petch <-- )
            iii) type code to send request (Talep gondermek icin kod yazimi)
            iv) do assertion (dogrulama yapmak)

     */

    /*
    Given
        https://restful-booker.herokuapp.com/booking/101
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
    */

    @Test
    public void test() {
        // i) set the URL
        String url = "https://restful-booker.herokuapp.com/booking/101";

        // ii) set the expected data (beklenen datanin olusturulmasi, --> post, put, petch <-- )
        // bizden post, put, petch birisi istenmedigi icin bu case'de kullanmayacagiz

        // iii) type code to send request (Talep gondermek icin kod yazimi)
        Response response = given().when().get(url);
        response.prettyPrint();

        // iv) do assertion (dogrulama yapmak)
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        // Status Code konsola yazdiralim
        System.out.println("Status Code : " + response.getStatusCode());

        // Content Type konsola yazdiralim
        System.out.println("Content Type : " + response.getContentType());

        // Status Line konsola yazdiralim
        System.out.println("Status Line : " + response.getStatusLine());

        // Header konsola yazdiralim
        System.out.println("Header : " + response.getHeader("Server"));

        // Headers konsola yazdiralim
        System.out.println("Headers : " + response.getHeaders());

        // Time konsola yazdiralim
        System.out.println("Time : " + response.getTime());

    }
}
