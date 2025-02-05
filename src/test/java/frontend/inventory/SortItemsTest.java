package frontend.inventory;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.InventoryPage;
import pages.LoginPage;
import utils.DriverSetup;

public class SortItemsTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void setUp() {
        DriverSetup setup = new DriverSetup(DriverSetup.BrowserType.EDGE);  // Koristi WebDriverManager
        driver = setup.getDriver();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
    }

    @Test(description = "Select the sorting from the Highest price to lowest and verify that the sorting is correct")
    public void sortItemsByPriceDescTest(){
        loginPage.login(loginPage.sUsername, loginPage.sPassword);
        inventoryPage.sortItemsByPriceDescending();
        Assert.assertTrue(inventoryPage.isSortedByPriceDescending(),"Items are not sorted from the highest price to lowest");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
