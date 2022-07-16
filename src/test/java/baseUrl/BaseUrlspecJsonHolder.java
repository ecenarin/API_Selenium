package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrlspecJsonHolder {
    /*
     protected RequestSpecification specJsonPlace ;

    @Before
    public void setup(){
        specJsonPlace= new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com").
                build();

    }
     */
    public RequestSpecification specJsonPlace;
    @Before
    public void setUp(){
        specJsonPlace=new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    }

}
