import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;
public class RegistrationTests {

    @Test
    void successfulRegisterTest() {
        String authData = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"pistol\"\n" +
                "}";

        given()
                .body(authData)
                .contentType(JSON)
                .log().uri()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("id", is(4))
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }
    @Test
    void unsuccessfulRegisterTest() {
        String authData = "{\n" +
                "    \"email\": \"sydneysweeney@wife\"\n" +
                "}";

        given()
                .body(authData)
                .contentType(JSON)
                .log().uri()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().status()
                .log().body()
                .statusCode(400)
                .body("error", is("Missing password"));
    }

}
