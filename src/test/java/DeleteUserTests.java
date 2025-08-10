import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;

public class DeleteUserTests extends TestBase {

    @Test
    void successfulDeleteTest() {

        given()
                .log().uri()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .delete("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);


    }

}
