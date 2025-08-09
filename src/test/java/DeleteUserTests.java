import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
public class DeleteUserTests {

    @Test
    void successfulDeleteTest() {

        given()
                .log().uri()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);


    }

}
