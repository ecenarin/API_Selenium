package tests_api;

import baseUrl.BaseUrlRestApi;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojo.DataRestApi;
import pojo.ExpDataRestApi;

import static io.restassured.RestAssured.given;

public class C29_GetPojoData extends BaseUrlRestApi {
    @Test
    public void name() {
        /*
                            http://dummy.restapiexample.com/api/v1/employee/3 url’ine
                            bir GET request gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

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
                    // 1 -Request url ve body'sini hazirlamak,
        specRestApi.pathParams("pp1","employee","pp2",3);
        Response response=given()
                .spec(specRestApi)
                .contentType(ContentType.JSON)
                .when()
                .get("/{pp1}/{pp2}");
                    // 2- Expected Data'yi hazirla
        DataRestApi data=new DataRestApi(3,"Ashton Cox",86000,66,"");
        ExpDataRestApi expData=new ExpDataRestApi("success",data,"Successfully! Record has been fetched.");
                    // 3- Response'u kaydet
        ExpDataRestApi actualData=response.as(ExpDataRestApi.class);
        // Pojo class'lari web sitelerinden yardim alarak olusturdugumuzda
        // attribute isimlerini degistirdiginden response'i convert etmek istedigimizde
        // inner pojo'lari olusturmada sorunlar cikabilir

        // bu sorunun cozumu icin
        // komplex response body'lerinde alt attribute'lere ulasmanin en kolay yolu olan
        // JsonPath kullaniriz
       JsonPath act=response.jsonPath();
        // 4- Assertion'lari yap
        response
                .then()
                .assertThat()
                .statusCode(200);
        Assert.assertEquals(expData.getData().getEmployeeName(),act.get("data.employee_name"));
        Assert.assertEquals(expData.getData().getEmployeeSalary(),act.get("data.employee_salary"));
        Assert.assertEquals(expData.getData().getEmployeeAge(),act.get("data.employee_age"));
        Assert.assertEquals(expData.getData().getProfileImage(),act.get("data.profile_image"));
        Assert.assertEquals(expData.getData().getId(),act.get("data.id"));
        Assert.assertEquals(expData.getStatus(),act.get("status"));
        Assert.assertEquals(expData.getMessage(),act.get("message"));
    }
}
