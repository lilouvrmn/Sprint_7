package courier;

import io.restassured.response.ValidatableResponse;
import order.Client;

import static io.restassured.RestAssured.given;

public class CourierClient extends Client {

    private static final String PATH_CREATE = "/api/v1/courier";
    private static final String PATH_LOGIN = "/api/v1/courier/login";
    private static final String PATH_DELETE = "/api/v1/courier/";

    public io.restassured.response.ValidatableResponse create(Courier courier) {
        return given()
                .spec(getSpec())
                .body(courier)
                .when()
                .post(PATH_CREATE)
                .then();
    }

    public io.restassured.response.ValidatableResponse login(Authorization authorization) {
        return given()
                .spec(getSpec())
                .body(authorization)
                .when()
                .post(PATH_LOGIN)
                .then();
    }

    public io.restassured.response.ValidatableResponse login(LoginOnlyAuthorization authorization) {
        return given()
                .spec(getSpec())
                .body(authorization)
                .when()
                .post(PATH_LOGIN)
                .then();
    }

    public io.restassured.response.ValidatableResponse login(PasswordOnlyAuthorization authorization) {
        return given()
                .spec(getSpec())
                .body(authorization)
                .when()
                .post(PATH_LOGIN)
                .then();
    }

    public ValidatableResponse delete(int id) {
        return given()
                .spec(getSpec())
                .delete(PATH_DELETE + id)
                .then();
    }
}