import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GetInfoAboutUsersTests extends TestBase {

    @Test
    void GetListUsersTest() {
        given()
                .log().uri()
                .header("x-api-key", "reqres-free-v1")
                .queryParam("page", 2)
                .when()
                .get(baseURI + basePath + "/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("page", is(2))
                .body("data.id", contains(7, 8, 9, 10, 11, 12))
                .body("data.email", hasItem("george.edwards@reqres.in"))
                .body("data.first_name", hasItem("George"))
                .body("data.last_name", hasItem("Edwards"))
                .body("data.avatar", hasItem("https://reqres.in/img/faces/11-image.jpg"));
    }


    @Test
    void GetSingleUserTest() {

        given()
                .log().uri()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .get(baseURI + basePath + "/users/11")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.id", is(11))
                .body("data.email", is("george.edwards@reqres.in"))
                .body("data.first_name", is("George"))
                .body("data.last_name", is("Edwards"))
                .body("data.avatar", is("https://reqres.in/img/faces/11-image.jpg"));


    }
    @Test
    void unsuccessfulGetSingleUserTest() {

        given()
                .log().uri()
                .header("x-api-key", "reqres-free-v1")
                .when()
                .get(baseURI + basePath + "/users/23")
                .then()
                .log().status()
                .log().body()
                .statusCode(404);
    }
}