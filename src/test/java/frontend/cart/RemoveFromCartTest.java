package frontend.cart;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.DriverSetup;

public class RemoveFromCartTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;

    @BeforeMethod
    public void setUp() {
        DriverSetup setup = new DriverSetup(DriverSetup.BrowserType.CHROME);
        driver = setup.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(description = "Add and remove item from cart")
    public void addAndRemoveItemFromCartTest() {
        loginPage.login(loginPage.sUsername, loginPage.sPassword);
        String firstItemName = inventoryPage.getFirstItemName();
        inventoryPage.addFirstItemToCart();
        inventoryPage.goToCart();
        Assert.assertTrue(cartPage.isItemInCart(firstItemName), "Item is not added to the cart!");
        cartPage.removeItemFromCart(firstItemName);
        Assert.assertFalse(cartPage.isItemInCart(firstItemName), "Item is not removed from the cart!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
