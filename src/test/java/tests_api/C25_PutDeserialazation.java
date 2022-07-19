package tests_api;

import baseUrl.BaseUrlspecJsonHolder;
import org.junit.Test;

public class C25_PutDeserialazation extends BaseUrlspecJsonHolder {

    @Test
    public void name() {
         /*
        https://jsonplaceholder.typicode.com/posts/70 url'ine
        asagidaki body’e sahip bir PUT request yolladigimizda donen response’in
        status kodunun 200,
        content type’inin “application/json; charset=utf-8”,
        Connection header degerinin “keep-alive”
        ve response body’sinin asagida verilen ile ayni oldugunu test ediniz

         Request Body

            {
            "title":"Hasan",
            "body":"Hoscakal",
            "userId":10.0,
            "id":70.0
            }

        Response body : // expected data

            {
            "title":"Hasan",
            "body":"Hoscakal",
            "userId":10.0,
            "id":70.0
            }
     */
        // 1 -Request url ve body'sini hazirlamak
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        // 2- Expected Data'yi hazirla
        // 3- Response'u kaydet
        // 4- Assertion'lari yap

    }
}
