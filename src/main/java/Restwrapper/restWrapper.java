package Restwrapper;

import java.util.Map;
import java.util.Properties;
import Enum.EndPoints;
import static Helper.PropertiesLoader.readPropertyFile;
import static io.restassured.RestAssured.given;

public class restWrapper {

    private static final Properties urlProps = readPropertyFile("config/APIURL.properties");

    public static <T> T restGet(EndPoints endpoint, Map<String, String> headers, String petID, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .when()
                .get(System.getProperty("url", urlProps.getProperty("url")).concat(endpoint.getValue()).concat("/").concat(petID))
                .then().log().body().and()
                .extract()
                .as(responseClass);
    }

    public static <T> T restPost(EndPoints endpoint, Map<String, String> headers, Object bodyData, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(bodyData)
                .log().body()
                .when()
                .post(System.getProperty("url", urlProps.getProperty("url")).concat(endpoint.getValue()))
                .then().log().body().and()
                .extract()
                .as(responseClass);
    }

    public static <T> T restPut(EndPoints endpoint, Map<String, String> headers, Object bodyData, Class<T> responseClass) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .body(bodyData)
                .log().body()
                .when()
                .put(System.getProperty("url", urlProps.getProperty("url")).concat(endpoint.getValue()))
                .then()
                .log().body().and()
                .extract()
                .as(responseClass);
    }

    public static int restDelete(EndPoints endpoint, Map<String, String> headers,String Path) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headers)
                .when()
                .delete(System.getProperty("url", urlProps.getProperty("url")).concat(endpoint.getValue()).concat("/").concat(Path))
                .then()
                .log().body().
                extract().statusCode();
    }
}
