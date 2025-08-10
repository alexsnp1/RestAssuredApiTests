import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;
public class CreateUserTests extends TestBase {

    @Test
    void successfulCreateTest() {
        String authData = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "    }";

        given()
                .body(authData)
                .contentType(JSON)
                .log().uri()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"))
                .body("job", is("leader"))
                .body("id", not(emptyOrNullString()))
                .body("createdAt", not(emptyOrNullString()));


    }

}
