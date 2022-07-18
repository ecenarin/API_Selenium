package tests_api;

import baseUrl.BaseUrlRestApi;
import dataStorage.RestApiStorage;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C23_Deserialization extends BaseUrlRestApi {
    @Test
    public void name() {

    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde
    donen response’un status code’unun 200, content Type’inin application/json
    ve body’sinin asagidaki gibi oldugunu test edin.
        Response Body==expected data
        {
            "status":"success",
            "data":{
                    "id":3,
                    "employee_name":"Ashton Cox",
                    "employee_salary":86000,
                    "employee_age":66,
                    "profile_image":""
                    },
            "message":"Successfully! Record has been fetched."
        }
     */
        // 1 -Request url ve body'sini hazirlamak
        specRestApi.pathParams("pp1","employee","pp2",3);
        Response response=given()
                .spec(specRestApi)
                .when()
                .get("/{pp1}/{pp2}");
        // 2- Expected Data'yi hazirla
        HashMap<String, Object> expmap=new RestApiStorage().createBodyMap();
        // 3- Response'u kaydet
        HashMap<String,Object> responseMap = response.as(HashMap.class);
        // 4- Assertion'lari yap
        response.then()
                .assertThat()
                .statusCode(200);
        assertEquals(expmap.get("status"),responseMap.get("status"));
        assertEquals(((Map)expmap.get("data")).get("id"),((Map)responseMap.get("data")).get("id"));
        assertEquals(((Map)expmap.get("data")).get("employee_name"),((Map)responseMap.get("data")).get("employee_name"));
        assertEquals(((Map)expmap.get("data")).get("employee_salary"),((Map)responseMap.get("data")).get("employee_salary"));
        assertEquals(((Map)expmap.get("data")).get("employee_age"),((Map)responseMap.get("data")).get("employee_age"));
        assertEquals(((Map)expmap.get("data")).get("profile_image"),((Map)responseMap.get("data")).get("profile_image"));
        assertEquals(expmap.get("message"),responseMap.get("message"));

    }
}
