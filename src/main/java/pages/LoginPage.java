package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    //elements
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    public By errorMessage = By.cssSelector("div.error");

    //strings
    public String sErrorMessage = "Epic sadface: Username and password do not match any user in this service";
    public String sUsername = "standard_user";
    public String sPassword = "secret_sauce";


    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }

}
