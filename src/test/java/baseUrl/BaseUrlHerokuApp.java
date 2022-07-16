package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlHerokuApp {
    protected  RequestSpecification specHeroku;
    @Before
    public void setup(){
        specHeroku=new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();
    }
}
