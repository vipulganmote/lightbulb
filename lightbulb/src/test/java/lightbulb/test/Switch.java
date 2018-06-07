package lightbulb.test;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

public class Switch {

    @Test
    public void validateOff(){
        given().get("https://qa-challenges-lightbulb.atlassian.io/api/allmethods/off/?userId=389664ed-7480-b6aa-ac15-3e1af11e278b").
                then().assertThat().body(containsString("Switch set successfully"));
    }

    @Test
    public void validateOn(){

        given().header("Content-Type", "application/json").
                post("https://qa-challenges-lightbulb.atlassian.io/api/allmethods/on/?userId=389664ed-7480-b6aa-ac15-3e1af11e278b").
                then().assertThat().body(containsString("Switch set successfully"));
    }

    @Test
    public void validateOnWithPowerValue(){

        given().header("Content-Type", "application/json").
                body("\"power\":20").
                post("https://qa-challenges-lightbulb.atlassian.io/api/allmethods/on/?userId=389664ed-7480-b6aa-ac15-3e1af11e278b").
                then().assertThat().body(containsString("Switch & custom power set successfully"));
    }

}
