package tests_api;

import baseUrl.BaseUrlRestApi;
import dataStorage.RestApiStorage;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C20_GetTestPojoDummy extends BaseUrlRestApi {
    @Test
    public void name()  {
        /*  http://dummy.restapiexample.com/api/v1/employee/3 urlâ€™ine bir GET request gonderdigimizde
            donen responseâ€™un status codeâ€™unun 200, content Typeâ€™inin application/json
            ve bodyâ€™sinin asagidaki gibi oldugunu test edin.
                Response Body
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
        // 1 -Request url ve body'sini hazirlama
        specRestApi.pathParams("pp1","employee","pp2",3);
        Response response=given()
                .spec(specRestApi)
                .when()
                .get("/{pp1}/{pp2}");
        response.prettyPrint();
        // 2- Expected Data'yi hazirla
        RestApiStorage rs=new RestApiStorage();
        JSONObject expectedData=rs.createBody();
        // 3- Response'u kaydet

        // 4- Assertion'lari yap
        JsonPath js=response.jsonPath();
       assertEquals(expectedData.get("status"),js.get("status"));
       assertEquals(expectedData.getJSONObject("data").get("id"),js.get("data.id"));
       assertEquals(expectedData.getJSONObject("data").get("employee_name"),js.get("data.employee_name"));
       assertEquals(expectedData.getJSONObject("data").get("employee_salary"),js.get("data.employee_salary"));
       assertEquals(expectedData.getJSONObject("data").get("employee_age"),js.get("data.employee_age"));
       assertEquals(expectedData.getJSONObject("data").get("profile_image"),js.get("data.profile_image"));
       assertEquals(expectedData.get("message"),js.get("message"));

    }
}
