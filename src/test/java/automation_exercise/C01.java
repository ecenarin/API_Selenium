package automation_exercise;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01 {
    //API 1: Get All Products List
    //API URL: https://automationexercise.com/api/productsList
    //Request Method: GET
    //Response Code: 200
    //Response JSON: All products list

    @Test
    public void name() {
        // 1 - request url ve body'sini hazirlamak
        // 2- Expected Data'yi hazirla
        // 3- Response'u kaydet
        // 4- Assertion'lari yap
        Response response=given()
                .when()
                .get("https://automationexercise.com/api/productsList");

        response.jsonPath().prettyPrint();
        response.then().assertThat().statusCode(200);

    }

    @Test
    public void name1() {
        /*
        API URL: https://automationexercise.com/api/searchProduct
Request Method: POST
Request Parameter: search_product (For example: top, tshirt, jean)
Response Code: 200
Response JSON: Searched products list
         */
        //Response response=given().
      //  Response response=given().contentType(ContentType.JSON).when().
    }
}
