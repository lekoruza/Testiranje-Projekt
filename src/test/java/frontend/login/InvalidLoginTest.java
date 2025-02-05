package frontend.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.DriverSetup;

public class InvalidLoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        DriverSetup setup = new DriverSetup(DriverSetup.BrowserType.CHROME);
        driver = setup.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @Test(description = "Invalid password test")
    public void invalidPasswordLoginTest() {
        loginPage.login(loginPage.sUsername, "invalid_password");
        Assert.assertEquals(loginPage.getErrorMessage(), loginPage.sErrorMessage, "Error message not as expected!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
