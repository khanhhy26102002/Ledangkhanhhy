package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    protected WebDriver driver;
    private By byEmails = By.id("email");
    private By byPassword = By.id("pass");
    private By byLogin = By.id("send2");
    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver wishlist(String emails, String message) {
        // Fill in the textbox value
        driver.findElement(byEmails).sendKeys(emails);
        driver.findElement(byPassword).sendKeys(message);

        // Click Share Wishlist, and return the driver
        driver.findElement(byLogin).click();
        return driver;
    }
}
