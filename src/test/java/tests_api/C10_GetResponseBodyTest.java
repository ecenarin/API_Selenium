package tests_api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_GetResponseBodyTest {
    @Test
    public void testName() {

    /*
            http://dummy.restapiexample.com/api/v1/employees url'ine bir GET request yolladigimizda
            donen Response'in
            status code'unun 200,
            ve content type'inin Aplication.JSON,
            ve response body'sindeki
                employees sayisinin 24
                ve employee'lerden birinin "Ashton Cox"
                ve girilen yaslar icinde 61,40 ve 30 degerlerinin oldugunu test edin
            test edin.
     */

        // 1 - request url ve body'sini hazirlamak
        Response response=
                given()
                        .when()
                        .get("http://dummy.restapiexample.com/api/v1/employees");
        response.prettyPrint();
        // 2- Expected Data'yi hazirla
        // 3- Response'u kaydet
        // 4- Assertion'lari yap
        /*
        "status": "success",
    "data": [
        {
            "id": 1,
            "employee_name": "Tiger Nixon",
            "employee_salary": 320800,
            "employee_age": 61,
            "profile_image": ""
        },
         */
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id", hasSize(24)
                        ,"data.employee_name",hasItem("Ashton Cox")
                        ,"data.employee_age",hasItems(61,40,30));

    }
}
