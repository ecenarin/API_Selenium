package tests_api;

import baseUrl.BaseUrlRestApi;
import dataStorage.RestApiStorage;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C26_GetDeserialization extends BaseUrlRestApi {
    @Test
    public void name() {
         /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde
    donen response’un asagidaki gibi oldugunu test edin.
        Response Body // expected data
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
        specRestApi.pathParams("pp1","employee","pp2",70);
        Response response=given()
                .spec(specRestApi)
                .when()
                .get("/{pp1}/{pp2}");
        // 2- Expected Data'yi hazirla
        HashMap<String,Object> expData= new RestApiStorage().createNewMap();
        // 3- Response'u kaydet
        HashMap<String,Object> actualData=response.as(HashMap.class);
        // 4- Assertion'lari yap
        response.then()
                 .assertThat()
                 .statusCode(200);
        assertEquals( expData.get("status"),actualData.get("status"));
        assertEquals(  ((Map)  expData.get("status")).get("employee_name"),((Map)actualData.get("status")).get("employee_name"));
        assertEquals(  ((Map)  expData.get("status")).get("employee_salary"),((Map)actualData.get("status")).get("employee_salary"));
        assertEquals(  ((Map)  expData.get("status")).get("employee_age"),((Map)actualData.get("status")).get("employee_age"));
        assertEquals(  ((Map)  expData.get("status")).get("profile_image"),((Map)actualData.get("status")).get("profile_image"));
        assertEquals( expData.get("message"),actualData.get("message"));

    }
}
