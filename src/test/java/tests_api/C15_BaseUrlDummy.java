package tests_api;

import baseUrl.BaseUrlspecJsonHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C15_BaseUrlDummy extends BaseUrlspecJsonHolder {
    @Test
    public void name() {
        //    Soru 1-  https://jsonplaceholder.typicode.com/posts endpointine
        //    bir GET request gonderdigimizde donen responseâ€™un status codeâ€™unun 200 oldugunu
        //    ve Responseâ€™ta 100 kayit oldugunu test edin

        // 1- Request url ve body'sini olustur
        // Framework'umuzu dinamik yapmak ve base url'de bir degisiklik oldugunda
        // tek tek tum test class'larini incelemek yerine sadece
        // BaseUrl class'ina gidip iradan tek degisiklikle sorunui cozmek icin
        // b yontem TERCIH EDILIR

        // 1 - request url ve body'sini hazirlamak
        specJsonPlace.pathParam("pp1","posts");
        Response response=given().spec(specJsonPlace).when().get("/{pp1}");
        response.prettyPrint();
        // 2- Expected Data'yi hazirla
        // 3- Response'u kaydet
        // 4- Assertion'lari yap

        response
                .then()
                .assertThat()
                .contentType(ContentType.JSON)
                .statusCode(200)
                .body("body", Matchers.hasSize(100));
    }

    @Test
    public void name1() {

        // 2- https://jsonplaceholder.typicode.com/posts/44 endpointine
        //    bir GET request gonderdigimizde donen responseâ€™un status codeâ€™unun 200 oldugunu
        //    ve â€œtitleâ€ degerinin â€œoptio dolor molestias sitâ€ oldugunu test edin
        // 1 - request url ve body'sini hazirlamak
        specJsonPlace.pathParams("pp1","posts","pp2",44);
        Response response=
                given()
                        .spec(specJsonPlace)
                        .when()
                        .get("/{pp1}/{pp2}");
        // 2- Expected Data'yi hazirla
        // 3- Response'u kaydet
        // 4- Assertion'lari yap
        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));

    }
}
