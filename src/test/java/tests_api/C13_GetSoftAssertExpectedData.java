package tests_api;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_GetSoftAssertExpectedData {
    @Test
    public void name() {
        /*
        http://dummy.restapiexample.com/api/v1/employee/3 urlâ€™ine bir GET request gonderdigimizde
        donen responseâ€™un asagidaki gibi oldugunu test edin.
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
                    // 1 - request url ve body'sini hazirlamak
        Response response=given()
                .when()
                .get("http://dummy.restapiexample.com/api/v1/employee/3");
        response.prettyPrint();
                    // 2- Expected Data'yi hazirla
        JSONObject jsonObject=new JSONObject();
        JSONObject inner=new JSONObject();
        inner.put("id",3);
        inner.put("employee_name","Ashton Cox");
        inner.put("employee_salary",86000);
        inner.put("employee_age",66);
        inner.put("profile_image","");
        jsonObject.put("status","success");
        jsonObject.put("data",inner);
        jsonObject.put("message","Successfully! Record has been fetched.");
                    // 3- Response'u kaydet
        /*
        {
    "status": "success",
    "data": {
        "id": 3,
        "employee_name": "Ashton Cox",
        "employee_salary": 86000,
        "employee_age": 66,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
}
         */
                    // 4- Assertion'lari yap
        SoftAssert softAssert=new SoftAssert();
        JsonPath jsonPath=response.jsonPath();
        softAssert.assertEquals(jsonPath.get("status"),jsonObject.get("status"));
        softAssert.assertEquals(jsonPath.get("data.id"),jsonObject.getJSONObject("data").get("id"));
        softAssert.assertEquals(jsonPath.get("data.employee_name"),jsonObject.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(jsonPath.get("data.employee_salary"),jsonObject.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(jsonPath.get("data.employee_age"),jsonObject.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(jsonPath.get("data.profile_image"),jsonObject.getJSONObject("data").get("profile_image"));
        softAssert.assertEquals(jsonPath.get("message"),jsonObject.get("message"));

    }
}
