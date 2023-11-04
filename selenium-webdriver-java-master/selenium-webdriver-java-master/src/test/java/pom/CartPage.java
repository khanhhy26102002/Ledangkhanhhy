package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    protected WebDriver driver;
    private By ByCountry = By.id("country");
    private By ByState = By.id("state");
    private By ByZip = By.id("zip");
    private By ESTIMATE = By.xpath("//button[@title='Estimate']");
    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    public WebDriver racer(String country, String state, String zip){
         driver.findElement(ByCountry).sendKeys(country);
         driver.findElement(ByState).sendKeys(state);
         driver.findElement(ByZip).sendKeys(zip);
         driver.findElement(ESTIMATE).click();
         return driver;
    }
}
