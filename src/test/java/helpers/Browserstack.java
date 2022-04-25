package helpers;

import config.Validation;
import static io.restassured.RestAssured.given;

public class Browserstack {
    public static String videoUrl (String sessionId) {
        return given()
                .auth().basic(Validation.config.user(), Validation.config.password())
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
