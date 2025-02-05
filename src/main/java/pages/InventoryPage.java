package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InventoryPage {
    private WebDriver driver;

    // Selektori
    private By inventoryItem = By.className("inventory_item");
    private By itemName = By.className("inventory_item_name");
    private By itemPrice = By.className("inventory_item_price");
    private By addToCartButton = By.className("btn_primary");
    private By cartLink = By.className("shopping_cart_link");
    private By sortContainer = By.className("product_sort_container");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
    public List<WebElement> getAllItems() {
        return driver.findElements(inventoryItem);
    }
    public String getFirstItemName() {
        return driver.findElements(itemName).get(0).getText();
    }
    public Double getItemPrice(WebElement item) {
        String priceText = item.findElement(itemPrice).getText();
        return Double.parseDouble(priceText.replace("$", ""));
    }

    public void sortItemsByPriceDescending() {
        WebElement sortDropdown = driver.findElement(sortContainer);
        Select select = new Select(sortDropdown);
        select.selectByValue("hilo");
    }

    public boolean isSortedByPriceDescending() {
        List<WebElement> items = getAllItems();
        List<Double> prices = new ArrayList<>();

        for (WebElement item : items) {
            prices.add(getItemPrice(item));
        }

        List<Double> sortedPrices = new ArrayList<>(prices);
        sortedPrices.sort(Comparator.reverseOrder());

        return prices.equals(sortedPrices);
    }

    public void addFirstItemToCart() {
        WebElement firstItem = getAllItems().get(0);
        firstItem.findElement(addToCartButton).click();
    }
    public void goToCart() {
        driver.findElement(cartLink).click();
    }
}
