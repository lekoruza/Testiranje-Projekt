package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage {
    private WebDriver driver;

    // Selektori
    private By cartItems = By.className("cart_item");
    private By itemNameSelector = By.className("inventory_item_name");
    private By removeButton = By.className("cart_button");  // Klasa za gumb uklanjanja

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isItemInCart(String itemName) {
        List<WebElement> cartItemsList = driver.findElements(cartItems);
        List<String> itemNamesInCart = cartItemsList.stream()
                .map(item -> item.findElement(itemNameSelector).getText())
                .collect(Collectors.toList());

        return itemNamesInCart.contains(itemName);
    }

    public void removeItemFromCart(String itemName) {
        List<WebElement> cartItemsList = driver.findElements(cartItems);

        for (WebElement item : cartItemsList) {
            String name = item.findElement(itemNameSelector).getText();
            if (name.equals(itemName)) {
                item.findElement(removeButton).click();
                break;
            }
        }
    }
}
