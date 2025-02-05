package backend;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManifestEndpointTest {

    @Test
    public void verifyManifestJsonEndpoint() {
        int statusCode = RestAssured.get("https://www.saucedemo.com/manifest.json").statusCode();
        Assert.assertEquals(statusCode, 200, "Expected status code 200 for manifest.json");
    }
}

